package com.nexign.gpn.qa.learn.java.patterns.behavioral.templatemethod.solving;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class PngPrinter extends BasePrinter {

    @Override
    protected byte[] convert(File file) throws IOException {
        return new Img2Ascii()
                .convertToAscii(new FileInputStream(file))
                .getBytes();
    }

    @Override
    protected void validate(String content) {
        log.info("validate png file");
    }

}
