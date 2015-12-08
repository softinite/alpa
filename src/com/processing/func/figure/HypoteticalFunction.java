package com.processing.func.figure;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Sergiu Ivasenco on 14/03/14.
 */
public enum HypoteticalFunction {
    CIRCLE(new CircleFunction()), SQUARE(new SquareFunction());

    private FigureFunction figureFunction;

    HypoteticalFunction(FigureFunction figureFunction) {
        setFigureFunction(figureFunction);
    }

    public static HypoteticalFunction lookup(List<BigDecimal> numbers) {
        if (CollectionUtils.size(numbers) == 2) {
            BigDecimal x = numbers.get(0);
            BigDecimal y = numbers.get(1);
            for(HypoteticalFunction hypoteticalFunction : values()) {
                if (hypoteticalFunction.getFigureFunction().match(numbers)) {
                    return hypoteticalFunction;
                }
            }
        }
        return null;
    }

    public FigureFunction getFigureFunction() {
        return figureFunction;
    }

    public void setFigureFunction(FigureFunction figureFunction) {
        this.figureFunction = figureFunction;
    }
}
