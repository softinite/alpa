package com.processing.semantics.questions;

import com.memory.KnowledgeBase;
import com.processing.func.figure.EmpiricFunction;
import com.processing.func.figure.FigureFunction;
import com.processing.func.figure.HypoteticalFunction;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Sergiu Ivasenco on 13/03/14.
 */
public class NumericQuestion extends AbstractQuestion {

    private FigureFunction matchingFunction;
    private FigureFunction defaultFunction;
    private KnowledgeBase knowledgeBase;

    public NumericQuestion(String userQuestion, List<BigDecimal> inputNumbers, HypoteticalFunction hypotheticalFunction, KnowledgeBase kb) {
        if (hypotheticalFunction != null) {
            setMatchingFunction(hypotheticalFunction.getFigureFunction());
        }
        setDefaultFunction(new EmpiricFunction(inputNumbers));
        setUserMessage(userQuestion);
        setKnowledgeBase(kb);
    }

    public FigureFunction getFunction() {
        if (getMatchingFunction() != null) {
            return getMatchingFunction();
        }
        return getDefaultFunction();
    }

    protected FigureFunction getMatchingFunction() {
        return matchingFunction;
    }

    protected void setMatchingFunction(FigureFunction matchingFunction) {
        this.matchingFunction = matchingFunction;
    }

    protected FigureFunction getDefaultFunction() {
        return defaultFunction;
    }

    protected void setDefaultFunction(FigureFunction defaultFunction) {
        this.defaultFunction = defaultFunction;
    }

    @Override
    public void registerAnswer(String answer) {
        FigureFunction figureFunction = getFunction();
        figureFunction.setLabel(answer);
        getKnowledgeBase().getAcquiredKnowledge().add(figureFunction);
    }

    public KnowledgeBase getKnowledgeBase() {
        return knowledgeBase;
    }

    public void setKnowledgeBase(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }
}
