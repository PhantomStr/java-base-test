package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.solving;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResponseStatusCode5xxLogger extends AbstractResponseHandler {
    @Override
    public void handle(Response response) {
        Integer statusCode = response.getStatusCode();
        if (statusCode > 499) {
            log.error("SYSTEM ERRORS LOGGER| {}, status code={}, error={}", response.getId(), response.getStatusCode(), response.getError());
        }

        handleNext(response);
    }

}
