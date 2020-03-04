package com.nexign.gpn.qa.learn.java.patterns.creational.singletone.solving;

public class DatabaseConnector {
    private static DatabaseConnector instance;

    private DatabaseConnector() {
    }

    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;

    }

    public int getConnection(){
        return 1;
    };

}
