package com.action.plans.steps;

/**
 * Created by Sergiu Ivasenco on 14/03/14.
 */
public class DisplayMessage implements ActionStep {

    private String message;

    public DisplayMessage(String text) {
        setMessage(text);
    }

    @Override
    public void execute() {
        System.out.println(getMessage());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
