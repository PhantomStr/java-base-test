package com.nexign.gpn.qa.learn.java.patterns.behavioral.notifier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsSender implements HealthCheckSubscriber{
    @Override
    public void update() {
        log.info("SMS notification: health check failed!!");
    }

}
