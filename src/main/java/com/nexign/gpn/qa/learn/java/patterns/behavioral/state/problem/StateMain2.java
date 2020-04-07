package com.nexign.gpn.qa.learn.java.patterns.behavioral.state.problem;

public class StateMain2 {
    public static void main(String[] args) {
        GumballMachine2 machine = new GumballMachine2(5);
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

        /*
        И вот заказчик решил что было бы круто превратить покупку шарика в лотерею и в 10% случаев выдавать по 2 шарика
         */
    }
}
