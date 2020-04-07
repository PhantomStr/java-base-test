package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.extended;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AbstractMathExpressionValidator implements MathExpressionValidator {
    MathExpressionValidator next;
    List<MathExpressionValidationException> errors = new ArrayList<>();

    @Override
    public MathExpressionValidator setNext(MathExpressionValidator nextHandler) {
        next = nextHandler;
        return next;
    }

    @Override
    //заложена логика soft assertions
    public boolean validate(String expression) throws MathExpressionValidationException {return validate(expression, new ArrayList<>());}

    @Override
    public boolean validate(String expression, List<MathExpressionValidationException> errors) throws MathExpressionValidationException {
        this.errors = errors;
        if (!validateExpression(expression)) {
            this.errors.add(new MathExpressionValidationException(getErrorMessage(), expression));
        }
        if (next != null) {
            return next.validate(expression, errors);
        }
        handleErrors();
        return errors.isEmpty();
    }

    protected abstract String getErrorMessage();

    protected abstract boolean validateExpression(String expression);

    private void handleErrors() {
        errors.forEach(e -> log.error(e.getMessage()));
    }

}
