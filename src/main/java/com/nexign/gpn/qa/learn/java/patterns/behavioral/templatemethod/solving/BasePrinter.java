package com.nexign.gpn.qa.learn.java.patterns.behavioral.templatemethod.solving;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import static org.testng.reporters.Files.readFile;

public abstract class BasePrinter {
    public void print(File file) throws IOException {
        String content = getContent(file); //1
        validate(content); //2
        getPrinter().write(convert(file)); //3, 4
    }

    private String getContent(File file) throws IOException {
        return readFile(file);
    }

    protected abstract byte[] convert(File file) throws IOException;

    protected OutputStream getPrinter() {
        return System.out;
    }

    protected void validate(String content) {}

}
