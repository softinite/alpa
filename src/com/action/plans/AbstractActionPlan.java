package com.action.plans;

import com.action.plans.steps.ActionStep;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Sergiu Ivasenco on 14/03/14.
 */
public abstract class AbstractActionPlan implements ActionPlan {

    private Queue<ActionStep> steps;

    protected AbstractActionPlan() {
        setSteps(new LinkedList<ActionStep>());
    }

    @Override
    public void executeNextStep() {
        ActionStep actionStep = getSteps().poll();
        if (actionStep != null) {
            actionStep.execute();
        }
    }

    @Override
    public boolean areThereMoreStepsToBeDone() {
        return CollectionUtils.isNotEmpty(getSteps());
    }

    public Queue<ActionStep> getSteps() {
        return steps;
    }

    public void setSteps(Queue<ActionStep> steps) {
        this.steps = steps;
    }
}
