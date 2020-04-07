package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.solving;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleResponseBodyLogger extends AbstractResponseHandler {

    @Override
    public void handle(Response response) {
        if (response.getBody() != null) {
            log.info("CONSOLE LOGGER| BODY {}:{}", response.getId(), response.getBody());
        } else {
            log.info("CONSOLE LOGGER| Response {} without body", response.getId());
        }

        handleNext(response);
    }

}
