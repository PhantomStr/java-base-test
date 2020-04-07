package com.nexign.gpn.qa.learn.java.patterns.behavioral.state.solution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StateMain3 {
    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine(5);
        machine.logState();

        machine.insertCoin();
        machine.turnCrank();
        machine.logState();

        machine.insertCoin();
        machine.ejectCoin();
        machine.turnCrank();
        machine.logState();

        machine.insertCoin();
        machine.turnCrank();
        machine.insertCoin();
        machine.turnCrank();
        machine.ejectCoin();
        machine.logState();

        machine.insertCoin();
        machine.insertCoin();
        machine.turnCrank();
        machine.turnCrank();
        machine.insertCoin();
        machine.turnCrank();
        machine.insertCoin();
        machine.turnCrank();
        machine.logState();
    }

}
