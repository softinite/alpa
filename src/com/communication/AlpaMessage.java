package com.communication;

/**
 * Created by softinite on 04/02/14.
 */
public interface AlpaMessage {

    /**
     * Is set to true in case a stop request has been detected
     * @return
     */
    public boolean isNotStopMessage();

    /**
     * Returns true in case a given message can be semnatically parsed. Which mean it represents a phrase.
     * @return
     */
    boolean isSemanticallyParseable();

    /**
     * Returns the basically parsed content
     * @return
     */
    public Object getContent();
}
