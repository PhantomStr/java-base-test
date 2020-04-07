package com.nexign.gpn.qa.learn.java.patterns.structural.decorator.solving;

import com.nexign.gpn.qa.learn.java.patterns.structural.decorator.problem.DataSource;
import com.nexign.gpn.qa.learn.java.patterns.structural.decorator.problem.FileDataSource;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class DecoratorMain {
    public static void main(String[] args) throws IOException {
        DataSource dataSource = new FileDataSource("test.txt");
        dataSource.writeData("content");
        log.info(dataSource.readData());

        //создаём декоратор
        DataSource encrypted = new EncryptedDataSourceDecorator(dataSource);

        encrypted.writeData("secret content");
        log.info(dataSource.readData());
        log.info(encrypted.readData());

        encrypted.doSomethingElse();

        DataSource logged = new MyDecorator(dataSource);
        logged.readData();
    }

}
