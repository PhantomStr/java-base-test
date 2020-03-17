package com.nexign.gpn.qa.learn.java.patterns.structural.adapter.problem;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Worker {
    private final CustomLogger logger;

    public void doSomething() {
        logger.logInfo("info message");
        logger.logWarn("warn message");
        logger.logError("error message");
    }

}
