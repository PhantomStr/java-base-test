package com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

@RequiredArgsConstructor
@Getter
public class Config {

    private final String name;
    private Map<String, Object> properties = new HashMap<>();

    public Object get(String key) {
        return properties.get(key);
    }

    public Config init(Map<String, Object> properties) {
        this.properties = properties;
        return this;
    }

    public Config add(Map<String, Object> properties) {
        Objects.requireNonNull(properties, "expected not null properties");
        if (this.properties == null) {
            init(new HashMap<>());
        }
        this.properties.putAll(properties);
        return this;
    }

    public Config add(Config config) {
        return add(config.getProperties());
    }

    public void print() {
        Properties properties = new Properties();
        properties.putAll(this.properties);
        properties.list(System.out);
    }

    public boolean isEmpty() {
        return properties.isEmpty();
    }

}
