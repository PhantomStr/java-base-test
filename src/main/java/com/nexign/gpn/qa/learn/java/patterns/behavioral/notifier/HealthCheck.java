package com.nexign.gpn.qa.learn.java.patterns.behavioral.notifier;

import java.util.ArrayList;
import java.util.Collection;

public class HealthCheck implements HealthCheckNotifier {

    Collection<HealthCheckSubscriber> subscribers = new ArrayList<>();

    @Override
    public boolean subscribe(HealthCheckSubscriber subscriber) {
        return subscribers.add(subscriber);
    }

    @Override
    public boolean unsubscribe(HealthCheckSubscriber subscriber) {
        return subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        subscribers.forEach(HealthCheckSubscriber::update);
    }

}
