package com.processing.func.figure;

import java.math.BigDecimal;

/**
 * Created by Sergiu Ivasenco on 12/03/14.
 */
public class CircleFunction extends AbstractFigureFunction {
    @Override
    public BigDecimal area(Integer x) {
        BigDecimal result = new BigDecimal("3.14");
        BigDecimal xDecimal = new BigDecimal(x);
        return result.multiply(xDecimal).multiply(xDecimal);
    }
}
