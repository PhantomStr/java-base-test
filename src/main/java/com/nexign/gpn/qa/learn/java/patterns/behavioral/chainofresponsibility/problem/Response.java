package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Builder
@Getter
@ToString
public class Response {
    private UUID id;
    private String body;
    private String error;
    private Integer statusCode;
}
