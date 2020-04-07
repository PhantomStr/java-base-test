package com.nexign.gpn.qa.learn.java.patterns.behavioral.state.solution;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GumballMachine {
    State soldOutState;
    State noCoinState;
    State hasCoinState;
    State soldState;
    State winnerState;
    @Setter
    private State state;
    @Setter
    @Getter
    private int count;


    public GumballMachine(int count) {
        soldOutState = new SoldOutState(this);
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = count;
        if (count > 0) {
            state = noCoinState;
        } else {
            this.state = soldOutState;
        }
    }

    public void releaseBall() {
        if (count > 0) {
            count -= 1;
            log.info("Шарик выдан");
        }

    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void refill(int count) {
        this.count += count;
        if (count > 0) {
            state = noCoinState;
        } else {
            state = soldState;
        }
    }

    public void logState() {
        log.info("---\n{}\n---", this);
    }

    @Override
    public String toString() {
        return "count = " + count + "; state = " + state.getClass().getSimpleName();
    }

}
