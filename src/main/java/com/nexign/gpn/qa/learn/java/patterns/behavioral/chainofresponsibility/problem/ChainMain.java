package com.nexign.gpn.qa.learn.java.patterns.behavioral.chainofresponsibility.problem;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Slf4j
public class ChainMain {

    public static void main(String[] args) {
        checkFirstService();

        checkSecondService();

        checkThirdService();
    }

    private static void checkFirstService() {
        commonLog(Response.builder()
                          .id(UUID.randomUUID())
                          .body("{}")
                          .statusCode(204).build());

        commonLog(Response.builder()
                          .id(UUID.randomUUID())
                          .error("{type:validation_error, message:\"authorization required\"}")
                          .statusCode(403).build());

        commonLog(Response.builder()
                          .error("{type:runtime_exception, message:\"NullPointerException...\"}")
                          .statusCode(500).build());
    }

    //сервис вызывается очень часто и много спамит в лог, хочется оставить только логирование ошибок
    private static void checkSecondService() {
        logOnlyErrors(Response.builder()
                              .id(UUID.randomUUID())
                              .body("{userId:\"" + UUID.randomUUID() + "\"}")
                              .statusCode(200)
                              .build());

        logOnlyErrors(Response.builder()
                              .id(UUID.randomUUID())
                              .body("{userId:\"" + UUID.randomUUID() + "\"}")
                              .statusCode(200)
                              .build());

    }

    // а тут нам надо логировать редиректы (3хх status code) и (5xx)
    private static void checkThirdService() {
        logAllAndRedirects(Response.builder()
                                   .id(UUID.randomUUID())
                                   .body("{userId:\"" + UUID.randomUUID() + "\"}")
                                   .statusCode(200)
                                   .build());

        logAllAndRedirects(Response.builder()
                                   .id(UUID.randomUUID())
                                   .body("{url:\"#innerRedirect\"}")
                                   .statusCode(300)
                                   .build());
    }

    private static void logAllAndRedirects(Response response) {
        if (checkId(response)) return;
        logErrorInConsole(response);
        log3xx(response);
        log5xx(response);
        logBody(response);
    }

    private static void log3xx(Response response) {
        Integer statusCode = validateStatusCode(response);
        if (statusCode > 299 && statusCode < 400) {
            log.error("SYSTEM COMMON LOGGER| Redirect request {}, status code={}", response.getId(), response.getStatusCode());
        }
    }

    private static void commonLog(Response response) {
        if (checkId(response)) return;
        logErrorInConsole(response);
        log4xx(response);
        log5xx(response);
        logBody(response);

    }

    private static void log5xx(Response response) {
        Integer statusCode = validateStatusCode(response);
        if (statusCode > 399 && statusCode < 500) {
            log.error("SYSTEM ERRORS LOGGER| {}, status code={}, body={}", response.getId(), response.getStatusCode(), response.getBody());
        }
    }

    private static void logErrorInConsole(Response response) {
        if (response.getError() != null) {
            log.error("CONSOLE LOGGER| ERROR {}:{}", response.getId(), response.getError());
        }
    }

    private static void logOnlyErrors(Response response) {
        if (checkId(response)) return;
        logErrorInConsole(response);
        log4xx(response);
        log5xx(response);
    }

    private static void logBody(Response response) {
        if (response.getBody() != null) {
            log.info("CONSOLE LOGGER| BODY {}:{}", response.getId(), response.getBody());
        } else {
            log.info("CONSOLE LOGGER| Response {} without body", response.getId());
        }
    }

    private static void log4xx(Response response) {
        Integer statusCode = validateStatusCode(response);
        if (statusCode > 499) {
            log.error("SYSTEM ERRORS LOGGER| {}, status code={}, error={}", response.getId(), response.getStatusCode(), response.getError());
        }
    }

    private static Integer validateStatusCode(Response response) {
        Integer statusCode = response.getStatusCode();
        requireNonNull(statusCode, "Response " + response.getId() + ": status code required!");
        return statusCode;
    }

    private static boolean checkId(Response response) {
        UUID id = response.getId();
        if (id == null) {
            log.error("SYSTEM ERRORS LOGGER| response id required! But was " + response.toString());
            return true;
        }
        return false;
    }

}
