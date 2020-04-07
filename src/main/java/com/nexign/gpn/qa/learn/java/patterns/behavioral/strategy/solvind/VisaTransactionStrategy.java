package com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.solvind;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.Transaction;
import com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.TransactionType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VisaTransactionStrategy implements TransactionStrategy {
    @Override
    public void execute(Transaction transaction) {
        validate(transaction);
        log.info("Handle Visa transaction.\n \"{}\" -> \"{}\": {}", transaction.getRecipientAccount(), transaction.getTargetAccount(), transaction.getAmount());
    }

    @Override
    public boolean isAcceptable(Transaction transaction) {
        return transaction.getRecipientAccount().startsWith("4")
                && transaction.getType().equals(TransactionType.VISA);
    }

    private void validate(Transaction transaction) {
        if (transaction.getType() != TransactionType.VISA) {
            log.warn("wrong Transaction type! Please check it! Try execute this transaction with Vise payment system");
        }
    }

}
