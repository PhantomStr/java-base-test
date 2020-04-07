package com.nexign.gpn.qa.learn.java.patterns.behavioral.state.solution;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SoldState implements State {
    GumballMachine gumballMachine;

    @Override
    public void insertCoin() {
        log.warn("Пожалуйста, подождите, шарик выдаётся");
    }

    @Override
    public void ejectCoin() {
        log.warn("Извините, вы уже дёрнули рычаг");
    }

    @Override
    public void turnCrank() {
        log.warn("Пожалуйста, подождите, шарик выдаётся");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.noCoinState);
        } else {
            gumballMachine.setState(gumballMachine.soldOutState);
        }
    }

}
