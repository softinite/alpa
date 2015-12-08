package com;

import com.action.AlpaAction;
import com.communication.AlpaMessage;
import com.io.AlpaMessageReader;
import com.memory.KnowledgeBase;
import com.processing.AlpaMessageProcessor;

/**
 * Created by softinite on 04/02/14.
 */
public class Alpa {

    public static void main(String...args) {
        System.out.println("Alpa started - waiting for input (for example 'radius area')");
        KnowledgeBase kb = new KnowledgeBase();
        AlpaMessageReader messageReader = new AlpaMessageReader();
        AlpaMessage alpaMessage = messageReader.readMessage();
        AlpaMessageProcessor messageProcessor = new AlpaMessageProcessor(kb);
        while(alpaMessage.isNotStopMessage()) {
            AlpaAction alpaAction = messageProcessor.infereAction(alpaMessage);
            alpaAction.perform();
            alpaMessage = messageReader.readMessage();
        }
    }
}
