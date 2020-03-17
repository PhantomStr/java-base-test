package com.nexign.gpn.qa.learn.java.patterns.structural.adapter.problem;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class AdapterMain {
    private static final Logger log = getLogger("my logger");

    public static void main(String[] args) {
        // new Worker(log).doSomething(); //не можем создать класс так как ожидается CustomLogger
    }

}
