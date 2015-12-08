package com.action.plans;

import com.action.plans.AbstractActionPlan;
import com.action.plans.SimpleResponseActionPlan;
import com.action.plans.steps.ActionStep;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by Sergiu Ivasenco on 14/03/14.
 */
public class AbstractActionPlanTest {

    private AbstractActionPlan abstractActionPlan;

    @Before
    public void setup() {
        abstractActionPlan = new SimpleResponseActionPlan("test");
    }

    @Test
    public void checkMoreSteps() {
        Assert.assertTrue(abstractActionPlan.areThereMoreStepsToBeDone());
        abstractActionPlan.setSteps(new LinkedList<ActionStep>());
        Assert.assertFalse(abstractActionPlan.areThereMoreStepsToBeDone());
    }

}
