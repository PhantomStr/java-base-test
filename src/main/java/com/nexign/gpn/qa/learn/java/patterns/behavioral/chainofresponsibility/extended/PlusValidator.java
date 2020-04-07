package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.extended;

import lombok.Getter;

public class PlusValidator extends SimpleOperationValidator {
    @Getter
    String errorMessage = "exception with '+'";

    @Override
    protected boolean validateExpression(String expression) {
        return validateSimpleOperation(expression, "\\+");
    }

}
