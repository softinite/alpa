package com.processing.func.figure;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Sergiu Ivasenco on 12/03/14.
 */
public interface FigureFunction {

    public BigDecimal area(Integer x);

    void setLabel(String trainingLabel);

    String getLabel();

    Boolean match(List<BigDecimal> numbers);
}
