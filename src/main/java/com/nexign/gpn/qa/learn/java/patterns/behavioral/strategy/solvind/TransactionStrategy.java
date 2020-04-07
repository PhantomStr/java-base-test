package com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.solvind;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.Transaction;

public interface TransactionStrategy {
    void execute(Transaction transaction);

    boolean isAcceptable(Transaction transaction);

}
