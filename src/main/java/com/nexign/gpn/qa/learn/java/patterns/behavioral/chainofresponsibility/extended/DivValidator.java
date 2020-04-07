package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.extended;

import lombok.Getter;
import org.apache.commons.lang3.RegExUtils;

public class DivValidator extends SimpleOperationValidator {
    @Getter
    String errorMessage = "exception with '/'";

    @Override
    protected boolean validateExpression(String expression) {
        String trim = RegExUtils.removeAll(expression, "\\s");
        String[] split = trim.split("/");
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
            if (!split[i].matches("[1-9(].*")) {
                return false;
            }
        }
        return true;
    }

}
