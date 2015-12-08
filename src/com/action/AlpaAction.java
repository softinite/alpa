package com.action;

import com.action.plans.ActionPlan;

/**
 * Created by softinite on 04/02/14.
 */
public class AlpaAction {

    private ActionPlan actionPlan;

    public AlpaAction(ActionPlan actionPlan) {
        setActionPlan(actionPlan);
    }

    public void perform() {
        while(getActionPlan().areThereMoreStepsToBeDone()) {
            getActionPlan().executeNextStep();
        }
    }

    public ActionPlan getActionPlan() {
        return actionPlan;
    }

    public void setActionPlan(ActionPlan actionPlan) {
        this.actionPlan = actionPlan;
    }
}
