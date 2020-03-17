package com.nexign.gpn.qa.learn.java.patterns.structural.proxy.solving;

import com.nexign.gpn.qa.learn.java.patterns.structural.proxy.problem.FileReader;
import com.nexign.gpn.qa.learn.java.patterns.structural.proxy.problem.FileReaderImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReaderProxy implements FileReader {
    Map<String, String> cache = new HashMap<>();
    FileReader reader = new FileReaderImpl();

    @Override
    public String read(String fileName) throws IOException {
        String cached = cache.get(fileName);
        if (cached != null) {
            return cached;
        }
        String content = reader.read(fileName);
        cache.put(fileName, content);
        return content;

    }

}
