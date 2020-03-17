package com.nexign.gpn.qa.learn.java.patterns.structural.facade.betersolving;

import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.Config;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
public abstract class AbstractConfigFacade {
    private final static Map<ConfigUniqueKey, Config> configCache = new HashMap<>();

    protected Config getCachedConfig(Supplier<Config> supplier, ConfigUniqueKey configUniqueKey) {
        if (configCache.containsKey(configUniqueKey)) {
            log.info("config {} found in cache", configUniqueKey.name);
            return configCache.get(configUniqueKey);
        }
        Config config = supplier.get();
        if (!config.isEmpty()) {
            configCache.put(configUniqueKey, config);
        }
        return config;
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    protected static class ConfigUniqueKey {
        String source;
        String name;

    }

}
