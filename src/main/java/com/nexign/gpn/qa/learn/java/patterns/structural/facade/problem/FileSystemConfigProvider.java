package com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FacadeMain.FTP_CONFIG_HOST;
import static com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FacadeMain.FTP_CONFIG_PORT;
import static com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FacadeMain.REMOTE_CONFIG_HOST;
import static com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FacadeMain.REMOTE_CONFIG_LOGIN;
import static com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FacadeMain.REMOTE_CONFIG_PASSWORD;
import static com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FacadeMain.REMOTE_CONFIG_PORT;

@Slf4j
@RequiredArgsConstructor
public class FileSystemConfigProvider {
    private final String configDirectory;

    public Config getConfig(String name) {
        log.info("\nRead config {} on file system", name);
        Config config = new Config(name).init(readFileMock(name));
        if (!config.isEmpty()) {
            log.info("Resolved in path {}/{}", configDirectory, name);
        }
        return config;
    }

    private Map<String, Object> readFileMock(String name) {
        Map<String, Object> propertyMap = new HashMap<>();
        switch (name) {
            case "configServer.properties":
                propertyMap.put(REMOTE_CONFIG_HOST, "https://gpn.config.server/");
                propertyMap.put(REMOTE_CONFIG_PORT, "8080");
                propertyMap.put(REMOTE_CONFIG_LOGIN, "MyLogin");
                propertyMap.put(REMOTE_CONFIG_PASSWORD, "P@sSw0rD");
                break;
            case "configFtp.properties":
                propertyMap.put(FTP_CONFIG_HOST, "192.128.34.174");
                propertyMap.put(FTP_CONFIG_PORT, "21");
                break;
        }
        return propertyMap;
    }

}
