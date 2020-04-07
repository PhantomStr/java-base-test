package com.nexign.gpn.qa.learn.java.patterns.behavioral.state.solution;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
@AllArgsConstructor
public class HasCoinState implements State {
    GumballMachine gumballMachine;

    @Override
    public void insertCoin() {
        log.warn("Монетка уже вставлена!");
    }

    @Override
    public void ejectCoin() {
        log.info("Возврат монетки");
        gumballMachine.setState(gumballMachine.noCoinState);
    }

    @Override
    public void turnCrank() {
        log.info("Рычаг нажат");
        if (RandomUtils.nextInt(0, 10) == 0) {
            gumballMachine.setState(gumballMachine.winnerState);
        } else {
            gumballMachine.setState(gumballMachine.soldState);
        }
    }

    @Override
    public void dispense() {
    }

}
