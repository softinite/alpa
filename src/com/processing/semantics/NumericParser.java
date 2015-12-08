package com.processing.semantics;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergiu Ivasenco on 13/03/14.
 * Provides basic interpretation to input represented by numbers
 */
public class NumericParser implements BasicParser {

    public static final String ARRAY_SEPARATOR = " ";

    @Override
    public Boolean canUnderstand(Object input) {
        if (input == null) {
            return Boolean.FALSE;
        }
        if (input.getClass().isArray()) {
            Object objects[] = (Object[]) input;
            if (isNotNumericArray(objects)) {
                return Boolean.FALSE;
            } else {
                return Boolean.TRUE;
            }
        }

        if (NumberUtils.isNumber(String.valueOf(input))) {
            return Boolean.TRUE;
        }

        String[] splitStr = StringUtils.split(String.valueOf(input), ARRAY_SEPARATOR);

        return !isNotNumericArray(splitStr);
    }

    private boolean isNotNumericArray(Object[] objects) {
        for(Object objVal : objects) {
            if (!NumberUtils.isNumber(String.valueOf(objVal))) {
                return true;
            }
        }
        return false;
    }

    public List<BigDecimal> parseNumbers(Object input) {
        List<BigDecimal> numbers = new ArrayList<BigDecimal>();
        if (input.getClass().isArray()) {
            Object objArr[] = (Object[]) input;
            parseArray(numbers, objArr);
        } else {
            String[] strArray = StringUtils.split(String.valueOf(input), ARRAY_SEPARATOR);
            parseArray(numbers, strArray);
        }
        return numbers;
    }

    private void parseArray(List<BigDecimal> numbers, Object[] objArr) {
        for(Object objNum : objArr) {
            numbers.add(new BigDecimal(String.valueOf(objNum)));
        }
    }
}
