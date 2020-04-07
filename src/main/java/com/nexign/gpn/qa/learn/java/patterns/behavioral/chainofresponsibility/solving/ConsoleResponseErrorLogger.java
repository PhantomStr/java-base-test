package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.solving;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleResponseErrorLogger extends AbstractResponseHandler {
    @Override
    public void handle(Response response) {
        if (response.getError() != null) {
            log.error("CONSOLE LOGGER| ERROR {}:{}", response.getId(), response.getError());
        }

        handleNext(response);

    }

}
