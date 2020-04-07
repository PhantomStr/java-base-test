package com.nexign.gpn.qa.learn.java.patterns.behavioral.state.solution;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class NoCoinState implements State {
    GumballMachine gumballMachine;

    @Override
    public void insertCoin() {
        log.info("Монетка принята");
        gumballMachine.setState(gumballMachine.hasCoinState);
    }

    @Override
    public void ejectCoin() {
        log.warn("Вы не всталяли монетку");
    }

    @Override
    public void turnCrank() {
        log.warn("Вы не всталяли монетку");
    }

    @Override
    public void dispense() {
    }

}
