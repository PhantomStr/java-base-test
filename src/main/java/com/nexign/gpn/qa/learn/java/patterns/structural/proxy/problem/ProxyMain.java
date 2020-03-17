package com.nexign.gpn.qa.learn.java.patterns.structural.proxy.problem;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ProxyMain {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReaderImpl();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            fileReader.read("test.txt");
        }
        long end = System.currentTimeMillis();
        log.info("{} ms", end - start);
    }

}
