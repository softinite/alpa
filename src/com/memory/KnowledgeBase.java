package com.memory;

import com.processing.func.email.SpamDetectionFunction;
import com.processing.func.figure.FigureFunction;
import com.processing.semantics.questions.Question;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergiu Ivasenco on 13/03/14.
 */
public class KnowledgeBase {

    private Question pendingQuestion;
    private List<FigureFunction> acquiredKnowledge;
    private SpamDetectionFunction spamDetectionFunction;

    public KnowledgeBase() {
        setAcquiredKnowledge(new ArrayList<FigureFunction>());
        setSpamDetectionFunction(new SpamDetectionFunction());
    }

    public Question getPendingQuestion() {
        return pendingQuestion;
    }

    public void setPendingQuestion(Question pendingQuestion) {
        this.pendingQuestion = pendingQuestion;
    }

    public void registerResponseLabel(String trainingLabel) {
        getPendingQuestion().registerAnswer(trainingLabel);
        setPendingQuestion(null);
    }

    public List<FigureFunction> getAcquiredKnowledge() {
        return acquiredKnowledge;
    }

    public void setAcquiredKnowledge(List<FigureFunction> acquiredKnowledge) {
        this.acquiredKnowledge = acquiredKnowledge;
    }

    public List<FigureFunction> lookupMatchingFunctions(List<BigDecimal> numbers) {
        List<FigureFunction> matchedFunctions = new ArrayList<FigureFunction>();
        for(FigureFunction figureFunction : getAcquiredKnowledge()) {
            if (figureFunction.match(numbers)) {
                matchedFunctions.add(figureFunction);
            }
        }
        return matchedFunctions;
    }

    public SpamDetectionFunction getSpamDetectionFunction() {
        return spamDetectionFunction;
    }

    protected void setSpamDetectionFunction(SpamDetectionFunction spamDetectionFunction) {
        this.spamDetectionFunction = spamDetectionFunction;
    }
}
