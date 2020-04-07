package com.nexign.gpn.qa.learn.java.patterns.behavioral.templatemethod.solving;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

import static org.testng.reporters.Files.readFile;

@Slf4j
public class TxtPrinter extends BasePrinter {
    @Override
    protected byte[] convert(File file) throws IOException {
        return readFile(file).getBytes();
    }
}
