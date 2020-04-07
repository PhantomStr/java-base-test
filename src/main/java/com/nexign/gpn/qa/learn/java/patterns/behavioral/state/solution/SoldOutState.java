package com.nexign.gpn.qa.learn.java.patterns.behavioral.state.solution;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    @Override
    public void insertCoin() {
        log.warn("Все шарики проданы, монетка не принимается");
    }

    @Override
    public void ejectCoin() {
        log.error("Вы не всталяли монетку");
    }

    @Override
    public void turnCrank() {
        log.warn("Все шарики проданы!");
    }
    @Override
    public void dispense() {
    }

}
