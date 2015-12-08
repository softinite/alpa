package com.processing.semantics.questions;

import com.processing.func.figure.FigureFunction;

/**
 * Created by Sergiu Ivasenco on 13/03/14.
 */
public interface Question {


    void registerAnswer(String answer);

    String getUserMessage();
}
