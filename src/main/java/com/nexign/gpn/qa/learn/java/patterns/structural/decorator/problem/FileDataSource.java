package com.nexign.gpn.qa.learn.java.patterns.structural.decorator.problem;

import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.io.FileUtils.getFile;

@AllArgsConstructor
public class FileDataSource implements DataSource {
    String fileName;


    @Override
    public void writeData(String message) throws IOException {
        FileUtils.write(getFile(fileName), message, UTF_8);
    }

    @Override
    public String readData() throws IOException {
        return FileUtils.readFileToString(getFile(fileName), UTF_8);
    }
    // далее много работы с данными

    @Override
    public void doSomethingElse() {
        System.out.println("something else");
    }

}
