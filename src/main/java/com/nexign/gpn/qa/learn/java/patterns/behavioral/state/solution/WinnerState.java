package com.nexign.gpn.qa.learn.java.patterns.behavioral.state.solution;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class WinnerState implements State {
    GumballMachine gumballMachine;

    @Override
    public void insertCoin() {
        log.info("Пожалуйста, подождите, шарики выдаются");
    }

    @Override
    public void ejectCoin() {
        log.warn("Извините, мистер счастливчик, вы уже дёрнули рычаг");
    }

    @Override
    public void turnCrank() {
        log.warn("Вставьте монетку!");
    }

    @Override
    public void dispense() {
        if (gumballMachine.getCount() > 1) {
            log.info("У нас победитель! Забирете свои шарики");
            gumballMachine.releaseBall();
            gumballMachine.releaseBall();
        } else if (gumballMachine.getCount() == 1) {
            log.info("У нас номинант в категории лузеров! Забирай своё шарик, но только один. Они закончились.");
            gumballMachine.releaseBall();
        } else {
            log.error("У нас победитель в категории лузеров! Шарики закончились. А мог бы получить два");
        }

        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.soldOutState);
        } else {
            gumballMachine.setState(gumballMachine.noCoinState);
        }
    }

}
