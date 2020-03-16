package com.nexign.gpn.qa.learn.java.patterns.creational.singletone.solving;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class singletonMain {
    public static void main(String[] args) {
        int con1 = DatabaseConnector.getInstance().getConnection();
        int con2 = DatabaseConnector.getInstance().getConnection();
        log.info("{},{}", con1, con2);

    }

}
