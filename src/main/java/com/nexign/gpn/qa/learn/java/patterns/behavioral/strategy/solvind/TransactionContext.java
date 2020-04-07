package com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.solvind;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.Transaction;
import lombok.Setter;

public class TransactionContext {
    @Setter
    private TransactionStrategy strategy;

    public void executeTransaction(Transaction transaction){
        strategy.execute(transaction);
    }
}
