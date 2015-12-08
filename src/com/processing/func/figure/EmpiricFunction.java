package com.processing.func.figure;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Responsible for holding a user specified function
 * Created by Sergiu Ivasenco on 14/03/14.
 */
public class EmpiricFunction extends AbstractFigureFunction {

    private BigDecimal userX;
    private BigDecimal userY;

    public EmpiricFunction(List<BigDecimal> inputNumbers) {
        if (CollectionUtils.size(inputNumbers) == 2) {
            setUserX(inputNumbers.get(0));
            setUserY(inputNumbers.get(1));
        }
    }


    @Override
    public BigDecimal area(Integer x) {
        if (getUserX().intValue() == x) {
            return getUserY();
        }
        return null;
    }

    public BigDecimal getUserX() {
        return userX;
    }

    public void setUserX(BigDecimal userX) {
        this.userX = userX;
    }

    public BigDecimal getUserY() {
        return userY;
    }

    public void setUserY(BigDecimal userY) {
        this.userY = userY;
    }
}
