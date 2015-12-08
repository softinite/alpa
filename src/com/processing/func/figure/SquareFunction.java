package com.processing.func.figure;

import java.math.BigDecimal;

/**
 * Created by Sergiu Ivasenco on 12/03/14.
 */
public class SquareFunction extends AbstractFigureFunction {

    @Override
    public BigDecimal area(Integer x) {
        return new BigDecimal(x * x);
    }
}
