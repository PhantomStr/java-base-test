package com.nexign.gpn.qa.learn.java.patterns.structural.proxy.problem;

import org.apache.commons.io.FileUtils;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.io.FileUtils.getFile;

public class FileReaderImpl implements FileReader {
    @Override
    public String read(String fileName) throws IOException {
        return FileUtils.readFileToString(getFile(fileName), UTF_8);
    }

}
