package com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem;

import lombok.extern.slf4j.Slf4j;

import static com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.TransactionType.MASTERCARD;
import static com.nexign.gpn.qa.learn.java.patterns.behavioral.strategy.problem.TransactionType.VISA;

@Slf4j
public class StrategyMain {
    TransactionChecker checker = new TransactionChecker();
    TransactionExecutor executor = new TransactionExecutor();

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

        StrategyMain main = new StrategyMain();
        main.executeTransaction(transaction1);
        main.executeTransaction(transaction2);
        main.executeTransaction(transaction3);
        main.executeTransaction(transaction4);
    }

    private void executeTransaction(Transaction transaction) {
        if (!checker.check(transaction)) {
            log.error("транзакция {} не будет обработана, так как некорректно заполнена", transaction);
            return;
        }
        executor.execute(transaction);

        //вдруг мы понимаем что мы можем обработать платежи ориентируясь на номер карты. Как понять нужный флоу обработки?
    }

}
