package com.processing.semantics;

import com.action.plans.ActionPlan;
import com.memory.KnowledgeBase;
import com.processing.func.figure.CircleFunction;
import com.processing.func.figure.EmpiricFunction;
import com.processing.func.figure.FigureFunction;
import com.processing.func.figure.SquareFunction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergiu Ivasenco on 13/03/14.
 */
@RunWith(JUnit4.class)
public class SemanticParserTest {

    private SemanticParser semanticParser;

    @Before
    public void setup() {
        semanticParser = new SemanticParser(new KnowledgeBase());
    }

    @Test
    public void buildCommaSeparatedLabels() {
        List<FigureFunction> functions = new ArrayList<FigureFunction>();
        CircleFunction circleFunction = new CircleFunction();
        circleFunction.setLabel("Circle");
        functions.add(circleFunction);
        SquareFunction squareFunction = new SquareFunction();
        squareFunction.setLabel("Square");
        functions.add(squareFunction);
        EmpiricFunction empiricFunction = new EmpiricFunction(null);
        empiricFunction.setLabel("Random");
        functions.add(empiricFunction);

        Assert.assertEquals("Circle, Square, Random", semanticParser.buildCommaSeparatedLabels(functions));
    }

    @Test
    public void createResponseForNumbers() {
        List<BigDecimal> numbers = new ArrayList<BigDecimal>();
        ActionPlan actionPlan = semanticParser.createResponseForNumbers(numbers);
        Assert.assertNotNull(actionPlan);
    }

}
