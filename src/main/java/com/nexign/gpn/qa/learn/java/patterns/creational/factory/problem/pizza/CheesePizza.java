package com.nexign.gpn.qa.learn.java.patterns.creational.factory.problem.pizza;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheesePizza implements Pizza {
    @Override
    public String getType() {
        return "cheese";
    }

    @Override
    public void prepare() {
        log.info("prepare cheese");
    }

    @Override
    public void cut() {
        log.info("cut cheese");
    }

    @Override
    public void box() {
        log.info("box cheese");
    }
}
