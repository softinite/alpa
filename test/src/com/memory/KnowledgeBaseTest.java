package com.memory;

import com.processing.func.figure.HypoteticalFunction;
import com.processing.semantics.questions.NumericQuestion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Sergiu Ivasenco on 14/03/14.
 */
public class KnowledgeBaseTest {

    private KnowledgeBase knowledgeBase;

    @Before
    public void setup() {
        knowledgeBase = new KnowledgeBase();
    }

    @Test
    public void registerResponseLabel() {
        NumericQuestion pendingQuestion = new NumericQuestion("What is the number?", new ArrayList<BigDecimal>(), HypoteticalFunction.SQUARE, new KnowledgeBase());
        knowledgeBase.setPendingQuestion(pendingQuestion);
        String squareName = "Square";
        knowledgeBase.registerResponseLabel(squareName);
        Assert.assertEquals(squareName, pendingQuestion.getFunction().getLabel());
    }

}
