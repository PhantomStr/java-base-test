package com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
    private TransactionType type;
    private double amount;
    private String recipientAccount;
    private String targetAccount;

}
