package com.processing.semantics;

/**
 * Created by Sergiu Ivasenco on 13/03/14.
 */
public class TextParser implements  BasicParser {

    @Override
    public Boolean canUnderstand(Object input) {
        if (input == null || !(input instanceof String) || !(input instanceof String[])) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
