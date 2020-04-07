package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.solving;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class ResponseIdChecker extends AbstractResponseHandler {
    @Override
    public void handle(Response response) {
        UUID id = response.getId();
        if (id == null) {
            log.error("SYSTEM ERRORS LOGGER| response id required! But was " + response.toString());
            return;
        }
        handleNext(response);
    }

}
