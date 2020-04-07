package com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem;

import org.testng.annotations.Test;

public class TransactionChecker {

    @Test
    public boolean check(Transaction transaction) {
        switch (transaction.getType()) {
            case VISA:
                return transaction.getRecipientAccount().startsWith("4");
            case MASTERCARD:
                return transaction.getRecipientAccount().startsWith("5");
            default:
                return false;

        }
    }

}
