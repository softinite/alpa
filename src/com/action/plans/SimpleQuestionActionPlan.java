package com.action.plans;

import com.action.plans.steps.DisplayMessage;
import com.memory.KnowledgeBase;
import com.processing.semantics.questions.NumericQuestion;
import com.processing.semantics.questions.Question;

/**
 * Created by Sergiu Ivasenco on 14/03/14.
 */
public class SimpleQuestionActionPlan extends AbstractActionPlan {

    public SimpleQuestionActionPlan(Question question, KnowledgeBase knowledgeBase) {
        knowledgeBase.setPendingQuestion(question);
        getSteps().add(new DisplayMessage(question.getUserMessage()));
    }

}
