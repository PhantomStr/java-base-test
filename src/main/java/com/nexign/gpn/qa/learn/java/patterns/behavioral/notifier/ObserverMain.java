package com.nexign.gpn.qa.learn.java.patterns.behavioral.notifier;

public class ObserverMain {
    public static void main(String[] args) {
        HealthCheckNotifier notifier = new HealthCheck();
        HealthCheckSubscriber sms = new SmsSender();
        HealthCheckSubscriber email = new EmailSender();

        notifier.subscribe(sms);
        notifier.subscribe(email);
        notifier.notifySubscribers();

        notifier.unsubscribe(sms);
        notifier.notifySubscribers();
    }

}
