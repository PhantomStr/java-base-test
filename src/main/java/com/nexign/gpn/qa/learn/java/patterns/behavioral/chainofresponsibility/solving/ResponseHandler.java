package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.solving;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem.Response;

public interface ResponseHandler {

    ResponseHandler setNext(ResponseHandler nextHandler);

    void handle(Response response);

}
