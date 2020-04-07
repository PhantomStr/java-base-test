package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.solving;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem.Response;

public class StopHandlingIfError extends AbstractResponseHandler {


    @Override
    public void handle(Response response) {
        Integer statusCode = response.getStatusCode();
        if (statusCode == null || statusCode > 299) {
            return;
        }
        handleNext(response);
    }

}
