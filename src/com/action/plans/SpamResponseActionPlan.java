package com.action.plans;

import com.action.plans.steps.DisplayMessage;
import com.memory.KnowledgeBase;

/**
 * Created by Sergiu Ivasenco on 09/05/14.
 */
public class SpamResponseActionPlan extends AbstractActionPlan {

    private static final String SPAM_DETECTED_MSG = "The email seems to be a spam.";
    private static final String SPAM_NOT_DETECTED_MSG = "The email does not seem to be a spam.";

    public SpamResponseActionPlan(Boolean spamDetected, KnowledgeBase knowledgeBase) {
        String message = null;
        if (spamDetected) {
            message = SPAM_DETECTED_MSG;
        } else {
            message = SPAM_NOT_DETECTED_MSG;
        }
        getSteps().add(new DisplayMessage(message));
    }
}
