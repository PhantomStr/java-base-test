package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.extended;

public class ChainMain {
    public static void main(String[] args) throws MathExpressionValidator.MathExpressionValidationException {
        MathExpressionValidator validators = new BracketsValidator();
        validators.setNext(new PlusValidator())
                .setNext(new MinusValidator())
                .setNext(new DivValidator())
                .setNext(new PowValidator());

        validators.validate("2^2+8*(9-21/3)");
        validators.validate("2-^2+*8*(9-21/3/0)");
    }

}
