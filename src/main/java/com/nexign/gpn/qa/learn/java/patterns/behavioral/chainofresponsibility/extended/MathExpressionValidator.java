package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.extended;

import java.util.List;

public interface MathExpressionValidator {
    MathExpressionValidator setNext(MathExpressionValidator nextHandler);

    boolean validate(String expression) throws MathExpressionValidationException;

    boolean validate(String expression, List<MathExpressionValidationException> errors) throws MathExpressionValidationException;

    class MathExpressionValidationException extends Throwable {
        public MathExpressionValidationException(String errorMessage, String expression) {
            super(errorMessage + ": " + expression);
        }

    }

}
