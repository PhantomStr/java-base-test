package com.nexign.gpn.qa.learn.java.patterns.structural.decorator.solving;

import com.nexign.gpn.qa.learn.java.patterns.structural.decorator.problem.DataSource;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MyDecorator extends DataSourceDecorator {

    public MyDecorator(DataSource wrapped) {
        super(wrapped);
    }

    @Override
    public String readData() throws IOException {
        String data = super.readData();
        log.info("log data:{}",data);
        return data;
    }

}
