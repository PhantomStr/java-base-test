package com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransactionExecutor {

    public void execute(Transaction transaction) {
        switch (transaction.getType()) {
            case VISA:
                log.info("Handle Visa transaction from {} to {}: {}", transaction.getRecipientAccount(), transaction.getTargetAccount(), transaction.getAmount());
                break;
            case MASTERCARD:
                log.info("Handle Mastercard transaction from {} to {}: {}", transaction.getRecipientAccount(), transaction.getTargetAccount(), transaction.getAmount());
        }
    }

}
