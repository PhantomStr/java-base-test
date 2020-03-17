package com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.util.Maps.newHashMap;

@Slf4j
@RequiredArgsConstructor
public class FtpConfigProvider {
    private final String host;
    private final String port;
    private String configDirectory;
    private boolean connected;

    public FtpConfigProvider setConfigDirectory(String configDirectory) {
        this.configDirectory = configDirectory;
        return this;
    }

    public Config getConfig(String name) {
        initConnection();
        log.info("Read config {} from {}:{}", name, host, port);
        Config config = new Config(name).init(getFtpConfigMock(name));
        if (!config.isEmpty()) {
            log.info("Resolved to {}/{}", configDirectory, name);
        }
        return config;
    }

    private void initConnection() {
        if (!connected) {
            connectFtp();
        }
    }

    private Map<String, Object> getFtpConfigMock(String name) {
        switch (name) {
            case "consumerService.properties":
                return newHashMap("service.consumer.host", "https://service-host:8080/");
            default:
                return new HashMap<>();
        }
    }

    private void connectFtp() {
        log.info("\nConnection to ftp server {}:{}", host, port);
        connected = true;
    }

}
