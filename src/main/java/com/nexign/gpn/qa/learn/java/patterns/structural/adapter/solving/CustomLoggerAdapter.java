package com.nexign.gpn.qa.learn.java.patterns.structural.adapter.solving;

import com.nexign.gpn.qa.learn.java.patterns.structural.adapter.problem.CustomLogger;
import org.slf4j.Logger;

public class CustomLoggerAdapter implements CustomLogger {
    Logger adapted;

    public CustomLoggerAdapter(Logger log) {
        adapted = log;
    }

    @Override
    public void logInfo(String message) {
        adapted.info(message);
    }

    @Override
    public void logWarn(String message) {
        adapted.warn(message);
    }

    @Override
    public void logError(String message) {
        adapted.error(message);
    }

}
