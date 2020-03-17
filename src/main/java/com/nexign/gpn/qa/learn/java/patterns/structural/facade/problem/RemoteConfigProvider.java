package com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.util.Maps.newHashMap;

@Slf4j
@RequiredArgsConstructor
public class RemoteConfigProvider {
    private final String host;
    private final String port;
    @Getter
    private String login;
    private String token;

    public RemoteConfigProvider authorize(String login, String password) {
        log.info("\nAuthorization on remote config server {}:{}", host, port);
        token = getTokenMock(login, password);
        this.login = login;
        log.info("Token {}", token);
        return this;
    }

    public Config getConfig(String name) {
        if (token == null) {
            throw new RuntimeException("Need authorize");
        }
        log.info("Read config {} from {}:{}", name, host, port);
        return new Config(name).init(getRemoteConfigMock(name));
    }

    @SuppressWarnings("unused")
    public synchronized String getTokenMock(String username, String password) {
        return RandomStringUtils.randomAlphanumeric(+254);
    }

    private Map<String, Object> getRemoteConfigMock(String name) {
        switch (name) {
            case "pod.properties":
                return newHashMap("pod.url", "https://pod-host:8080/");
            default:
                return new HashMap<>();
        }
    }

}
