package com.action.plans;

import com.action.plans.steps.DisplayMessage;

/**
 * Created by Sergiu Ivasenco on 13/03/14.
 */
public class SimpleResponseActionPlan extends AbstractActionPlan {

    private String userMessage;

    public SimpleResponseActionPlan(String messageToUser) {
        setUserMessage(messageToUser);
        getSteps().add(new DisplayMessage(messageToUser));
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}
