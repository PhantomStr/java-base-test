package com.nexign.gpn.qa.learn.java.patterns.structural.decorator.solving;

import com.nexign.gpn.qa.learn.java.patterns.structural.decorator.problem.DataSource;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@AllArgsConstructor
public class DataSourceDecorator implements DataSource {
    @Delegate(types = DataSource.class)
    DataSource wrapped;

}
