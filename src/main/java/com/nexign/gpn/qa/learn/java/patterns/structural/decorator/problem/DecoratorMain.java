package com.nexign.gpn.qa.learn.java.patterns.structural.decorator.problem;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class DecoratorMain {
    public static void main(String[] args) throws IOException {
        DataSource dataSource = new FileDataSource("test.txt");
        dataSource.writeData("content");
        log.info(dataSource.readData());

        //только в некоторых местах данные потребовалось хранить в шифрованном виде
        //менять код FileDataSource мы не можем, потому что он вообще не в нашей библиотеке
    }

}
