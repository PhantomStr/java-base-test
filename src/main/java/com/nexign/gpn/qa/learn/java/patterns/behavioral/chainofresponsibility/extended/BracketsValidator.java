package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.extended;

import lombok.Getter;

import static org.apache.commons.lang3.StringUtils.countMatches;

public class BracketsValidator extends AbstractMathExpressionValidator {
    @Getter
    String errorMessage = "exception with '+'";

    @Override
    protected boolean validateExpression(String expression) {
        return countMatches(expression, '(') == countMatches(expression, ')');
    }

}
