package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.solving;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem.Response;

import java.util.UUID;

public class ChainMain {

    public static void main(String[] args) {
        // поведение обработки выносится в объекты, и каждый после обработки передаёт или не передаёт обработку следующему в цепочке.

        // удобно импользовать если мы не знаем какой обработчик нам понадобится, мы можем связать все в цепочку
        // если требуется единственный обработчик, то после обработки он вернёт результат, иначе вернёт результат следующего обработчика
        ResponseHandler chain = new ResponseIdChecker();
        chain
                .setNext(new ConsoleResponseErrorLogger())
                .setNext(new ResponseStatusCode4xxLogger())
                .setNext(new StopHandlingIfError())
                .setNext(new ConsoleResponseBodyLogger());


        chain.handle(Response.builder()
                             .id(UUID.randomUUID())
                             .body("{}")
                             .statusCode(204).build());

        chain.handle(Response.builder()
                             .id(UUID.randomUUID())
                             .error("{type:validation_error, message:\"authorization required\"}")
                             .statusCode(403).build());

        chain.handle(Response.builder()
                             .error("{type:runtime_exception, message:\"NullPointerException...\"}")
                             .statusCode(500).build());

    }

}
