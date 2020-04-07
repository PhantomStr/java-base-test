package com.nexign.gpn.qa.learn.java.patterns.behavioral.notifier;

public interface HealthCheckNotifier {

    boolean subscribe(HealthCheckSubscriber subscriber);

    boolean unsubscribe(HealthCheckSubscriber subscriber);

    void notifySubscribers();

}
