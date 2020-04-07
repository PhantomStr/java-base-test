package com.nexign.gpn.qa.learn.java.patterns.behavioral.templatemethod.solving;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import static org.testng.reporters.Files.readFile;

public abstract class BasePrinter {
    public void print(File file) throws IOException {
        String content = readFile(file);
        validate(content);
        getPrinter().write(convert(file));
    }

    protected abstract byte[] convert(File file) throws IOException;

    protected OutputStream getPrinter() {
        return System.out;
    }

    protected void validate(String content) {}

}
