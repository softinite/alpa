package com.processing.func.figure;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Sergiu Ivasenco on 14/03/14.
 */
public abstract class AbstractFigureFunction implements FigureFunction {

    private String label;

    @Override
    public abstract BigDecimal area(Integer x);

    @Override
    public Boolean match(List<BigDecimal> numbers) {
        if (CollectionUtils.size(numbers) == 2) {
            BigDecimal x = numbers.get(0);
            BigDecimal y = numbers.get(1);
            return y.equals(area(x.intValue()));
        }
        return null;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }
}
