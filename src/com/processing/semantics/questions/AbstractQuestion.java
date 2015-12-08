package com.processing.semantics.questions;

/**
 * Created by Sergiu Ivasenco on 14/03/14.
 */
public abstract class AbstractQuestion implements Question {

    private String userMessage;

    @Override
    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}
