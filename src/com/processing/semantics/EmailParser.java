package com.processing.semantics;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Sergiu Ivasenco on 09/05/14.
 */
public class EmailParser implements BasicParser {

    public static final String EMAIL_PREFIX = "Email:";
    public static final int EMAIL_PREFIX_LENGTH = StringUtils.length(EMAIL_PREFIX);

    @Override
    public Boolean canUnderstand(Object input) {
        if (input == null) {
            return Boolean.FALSE;
        }
        String strInput = input.toString();
        return StringUtils.startsWith(strInput, EMAIL_PREFIX);
    }

    public String parseEmail(Object content) {
        String strContent = content.toString();
        return StringUtils.right(strContent, StringUtils.length(strContent) - EMAIL_PREFIX_LENGTH);
    }
}
