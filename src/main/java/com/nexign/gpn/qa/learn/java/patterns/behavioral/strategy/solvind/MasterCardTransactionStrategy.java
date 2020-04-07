package com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.solvind;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.Transaction;
import com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.TransactionType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardTransactionStrategy implements TransactionStrategy {
    @Override
    public void execute(Transaction transaction) {
        validate(transaction);
        log.info("Handle Mastercard transaction.\n \"{}\" -> \"{}\": {}", transaction.getRecipientAccount(), transaction.getTargetAccount(), transaction.getAmount());
    }

    @Override
    public boolean isAcceptable(Transaction transaction) {
        return transaction.getRecipientAccount().startsWith("5")
                && transaction.getType().equals(TransactionType.MASTERCARD);
    }

    private void validate(Transaction transaction) {
//        if (transaction.getType() != TransactionType.MASTERCARD) {
//            log.warn("wrong Transaction type! Please check it! Try execute this transaction with MasterCard payment system");
//        }
    }

}
