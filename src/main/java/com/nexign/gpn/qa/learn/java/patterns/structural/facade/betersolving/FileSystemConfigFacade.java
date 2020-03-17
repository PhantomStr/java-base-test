package com.nexign.gpn.qa.learn.java.patterns.structural.facade.betersolving;

import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.Config;
import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FileSystemConfigProvider;
import lombok.SneakyThrows;

public class FileSystemConfigFacade extends AbstractConfigFacade {
    public static final String LOCAL_FILE_SYSTEM_CONFIG_PATH = "C://MyApp/configurations";
    FileSystemConfigProvider fileSystemConfigProvider;

    public FileSystemConfigFacade() {
        fileSystemConfigProvider = new FileSystemConfigProvider(LOCAL_FILE_SYSTEM_CONFIG_PATH);

    }

    @SneakyThrows
    public Config getConfig(String name) {
        return getCachedConfig(() -> fileSystemConfigProvider.getConfig(name), new ConfigUniqueKey(LOCAL_FILE_SYSTEM_CONFIG_PATH, name));
    }

}
