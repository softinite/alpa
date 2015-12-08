package com.processing.semantics;

import com.action.plans.ActionPlan;
import com.action.plans.SimpleQuestionActionPlan;
import com.action.plans.SimpleResponseActionPlan;
import com.action.plans.SpamResponseActionPlan;
import com.communication.AlpaMessage;
import com.memory.KnowledgeBase;
import com.processing.func.email.SpamDetectionFunction;
import com.processing.func.figure.FigureFunction;
import com.processing.func.figure.HypoteticalFunction;
import com.processing.semantics.questions.NumericQuestion;
import com.processing.semantics.questions.Question;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by softinite on 05/02/14.
 */
public class SemanticParser {

    private NumericParser numericParser;
    private EmailParser emailParser;
    private TextParser textParser;
    private KnowledgeBase knowledgeBase;

    public SemanticParser(KnowledgeBase kb) {
        setNumericParser(new NumericParser());
        setTextParser(new TextParser());
        setKnowledgeBase(kb);
    }

    public ActionPlan parse(AlpaMessage alpaMessage) {
        Question question = getKnowledgeBase().getPendingQuestion();

        if (question != null) {
            getKnowledgeBase().registerResponseLabel(String.valueOf(alpaMessage.getContent()));
            return new SimpleResponseActionPlan("Understood");
        }
        if (getNumericParser().canUnderstand(alpaMessage.getContent())) {
            return createResponseForNumbers(getNumericParser().parseNumbers(alpaMessage.getContent()));
        }
        if (getEmailParser().canUnderstand(alpaMessage.getContent())) {
            return createResponseForEmail(getEmailParser().parseEmail(alpaMessage.getContent()));
        }
        return new SimpleResponseActionPlan("Option not available at the moment.");
    }

    private ActionPlan createResponseForEmail(String messageContent) {
        SpamDetectionFunction spamDetectionFunction = getKnowledgeBase().getSpamDetectionFunction();
        return new SpamResponseActionPlan(spamDetectionFunction.isSpam(messageContent), getKnowledgeBase());
    }

    protected ActionPlan createResponseForNumbers(List<BigDecimal> bigDecimals) {
        List<FigureFunction> matchedFunctions = getKnowledgeBase().lookupMatchingFunctions(bigDecimals);
        if (CollectionUtils.isEmpty(matchedFunctions)) {
            return new SimpleQuestionActionPlan(new NumericQuestion("What does it mean?", bigDecimals, HypoteticalFunction.lookup(bigDecimals), getKnowledgeBase()), getKnowledgeBase());
        }
        if (matchedFunctions.size() > 1) {
            return new SimpleResponseActionPlan("It can mean any of the following: " + buildCommaSeparatedLabels(matchedFunctions));
        }
        return new SimpleResponseActionPlan(matchedFunctions.get(0).getLabel());
    }

    protected String buildCommaSeparatedLabels(List<FigureFunction> matchedFunctions) {
        StringBuilder sb = new StringBuilder(matchedFunctions.get(0).getLabel());
        Boolean isFirst = Boolean.TRUE;
        for(FigureFunction figureFunction : matchedFunctions) {
            if (isFirst) {
                isFirst = Boolean.FALSE;
            } else {
                sb.append(", ").append(figureFunction.getLabel());
            }
        }
        return sb.toString();
    }

    public NumericParser getNumericParser() {
        return numericParser;
    }

    public void setNumericParser(NumericParser numericParser) {
        this.numericParser = numericParser;
    }

    public TextParser getTextParser() {
        return textParser;
    }

    public void setTextParser(TextParser textParser) {
        this.textParser = textParser;
    }

    public KnowledgeBase getKnowledgeBase() {
        return knowledgeBase;
    }

    public void setKnowledgeBase(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public EmailParser getEmailParser() {
        return emailParser;
    }

    public void setEmailParser(EmailParser emailParser) {
        this.emailParser = emailParser;
    }
}
