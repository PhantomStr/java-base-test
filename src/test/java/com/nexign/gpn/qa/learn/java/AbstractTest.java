package com.nexign.gpn.qa.learn.java;

import org.testng.annotations.BeforeMethod;

abstract class AbstractTest<T> {
    protected T testedClass;

    @BeforeMethod
    public void setUp() {
        testedClass = getTestedClass();
    }

    protected abstract T getTestedClass();

}
