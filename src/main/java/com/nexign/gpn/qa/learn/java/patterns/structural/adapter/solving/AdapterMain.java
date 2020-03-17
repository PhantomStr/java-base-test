package com.nexign.gpn.qa.learn.java.patterns.structural.adapter.solving;

import com.nexign.gpn.qa.learn.java.patterns.structural.adapter.problem.Worker;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class AdapterMain {
    private static final Logger log = getLogger("my logger");

    public static void main(String[] args) {
        CustomLoggerAdapter adapter = new CustomLoggerAdapter(log);
        new Worker(adapter).doSomething();
    }

}
