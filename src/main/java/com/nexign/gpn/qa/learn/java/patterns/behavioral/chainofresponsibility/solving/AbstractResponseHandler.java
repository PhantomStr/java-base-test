package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.solving;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem.Response;

public abstract class AbstractResponseHandler implements ResponseHandler {
    private ResponseHandler next;

    @Override
    public ResponseHandler setNext(ResponseHandler nextHandler) {
        next = nextHandler;
        return next;
    }

    protected void handleNext(Response response) {
        if (next != null) {
            next.handle(response);
        }
    }

}
