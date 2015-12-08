package com.communication;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by softinite on 04/02/14.
 */
public class TextAlpaMessage implements AlpaMessage {

    private static final String STOP_MSG = "halt";
    private String text;

    public TextAlpaMessage(String text) {
        setText(text);
    }

    @Override
    public boolean isNotStopMessage() {
        return !StringUtils.equalsIgnoreCase(STOP_MSG, getText());
    }

    @Override
    public boolean isSemanticallyParseable() {
        return true;
    }

    @Override
    public Object getContent() {
        return (Object)getText();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
