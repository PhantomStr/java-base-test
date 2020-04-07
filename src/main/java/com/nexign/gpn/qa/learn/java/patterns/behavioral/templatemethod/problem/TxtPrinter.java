package com.nexign.gpn.qa.learn.java.patterns.behavioral.templatemethod.problem;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import static org.testng.reporters.Files.readFile;

@Slf4j
public class TxtPrinter {
    public void print(File file) throws IOException {
        String content = readFile(file);
        OutputStream printer = getPrinter();
        printer.write(content.getBytes());
    }

    private OutputStream getPrinter() {
        return System.out;
    }

}
