package com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.solvind;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.Transaction;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.TransactionType.MASTERCARD;
import static com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.TransactionType.VISA;

@Slf4j
public class StrategyMain {
    public static void main(String[] args) {
        Transaction transaction1 = Transaction.builder()
                .amount(1000)
                .type(VISA)
                .recipientAccount("4875 4569 7854 1568")
                .targetAccount("5467 7984 8745 6659")
                .build();

        Transaction transaction2 = Transaction.builder()
                .amount(1456)
                .type(MASTERCARD)
                .recipientAccount("4986 3264 4567 4549")
                .targetAccount("5467 7984 8745 6659")
                .build();

        Transaction transaction3 = Transaction.builder()
                .amount(7456)
                .type(MASTERCARD)
                .recipientAccount("5958 7451 6561 7874")
                .targetAccount("5467 7984 8745 6659")
                .build();

        Transaction transaction4 = Transaction.builder()
                .amount(6549)
                .type(VISA)
                .recipientAccount("5594 3321 4567 8554")
                .targetAccount("5467 7984 8745 6659")
                .build();

        executeTransaction(transaction1);
        executeTransaction(transaction2);
        executeTransaction(transaction3);
        executeTransaction(transaction4);
    }

    private static void executeTransaction(Transaction transaction) {
        //не стоит их хранить внутри метода, да и меод executeTransaction не должен быть статическим в мэйне.
        // Но для примера норм
        List<TransactionStrategy> strategies = new ArrayList<>();
        strategies.add(new VisaTransactionStrategy());
        strategies.add(new MasterCardTransactionStrategy());

        Set<TransactionStrategy> acceptableStrategies = strategies.stream()
                .filter(transactionStrategy -> transactionStrategy.isAcceptable(transaction))
                .collect(Collectors.toSet());
        if (acceptableStrategies.size() > 1) {
            log.error("Найдено более одной подходящей стратегии для обработки транзакции " + transaction);
            return;
        }
        if (acceptableStrategies.size() == 0) {
            log.error("Нет подходящей стратегии для обработки транзакции " + transaction.toString());
            return;
        }

        TransactionContext transactionContext = new TransactionContext();
        transactionContext.setStrategy(acceptableStrategies.iterator().next());
        transactionContext.executeTransaction(transaction);
    }

}
