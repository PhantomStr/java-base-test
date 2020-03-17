package com.nexign.gpn.qa.learn.java.patterns.structural.decorator.problem;

import java.io.IOException;

public interface DataSource {
    void writeData(String message) throws IOException;

    String readData() throws IOException;

    void doSomethingElse();

}
