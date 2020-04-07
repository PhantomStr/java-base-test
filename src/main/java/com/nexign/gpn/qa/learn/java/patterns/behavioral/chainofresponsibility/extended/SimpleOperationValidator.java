package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.extended;

import org.apache.commons.lang3.RegExUtils;

public abstract class SimpleOperationValidator extends AbstractMathExpressionValidator {

    protected boolean validateSimpleOperation(String expression, String operationRegExp) {
        String trim = RegExUtils.removeAll(expression, "\\s");
        String[] split = trim.split(operationRegExp);
        int length = split.length;
        if (length < 2) {
            return true;
        }
        for (int i = 0; i < length - 1; i++) {
            if (!split[i].matches(".*[\\d)]")) {
                return false;
            }
        }
        for (int i = 1; i < length; i++) {
            if (!split[i].matches("[\\d(].*")) {
                return false;
            }
        }
        return true;
    }

}
