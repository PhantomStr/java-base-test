package com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving.pizza;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PepperoniPizza implements Pizza {
    @Override
    public String getType() {
        return "pepperoni";
    }

    @Override
    public void prepare() {
        log.info("prepare pepperoni");
    }

    @Override
    public void cut() {
        log.info("cut pepperoni");
    }

    @Override
    public void box() {
        log.info("box pepperoni");
    }

}
