package com.processing;

import com.action.plans.ActionPlan;
import com.action.AlpaAction;
import com.action.plans.SimpleResponseActionPlan;
import com.communication.AlpaMessage;
import com.memory.KnowledgeBase;
import com.processing.semantics.SemanticParser;

/**
 * Created by softinite on 04/02/14.
 */
public class AlpaMessageProcessor {

    private SemanticParser semanticParser;
    private KnowledgeBase knowledgeBase;

    public AlpaMessageProcessor(KnowledgeBase kb) {
        setSemanticParser(new SemanticParser(kb));
        setKnowledgeBase(kb);
    }

    public AlpaAction infereAction(AlpaMessage alpaMessage) {
        if (alpaMessage.isSemanticallyParseable()) {
            ActionPlan actionPlan = getSemanticParser().parse(alpaMessage);
            return new AlpaAction(actionPlan);
        }
        return new AlpaAction(new SimpleResponseActionPlan("Cannot understand input: " + String.valueOf(alpaMessage.getContent())));
    }

    public SemanticParser getSemanticParser() {
        return semanticParser;
    }

    public void setSemanticParser(SemanticParser semanticParser) {
        this.semanticParser = semanticParser;
    }

    public KnowledgeBase getKnowledgeBase() {
        return knowledgeBase;
    }

    public void setKnowledgeBase(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }
}
