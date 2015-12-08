package com.action.plans;

/**
 * Created by softinite on 05/02/14.
 */
public interface ActionPlan {
    public boolean areThereMoreStepsToBeDone();

    void executeNextStep();
}
