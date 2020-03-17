package com.nexign.gpn.qa.learn.java.patterns.structural.facade.solving;

import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.Config;
import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FileSystemConfigProvider;
import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FtpConfigProvider;
import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.RemoteConfigProvider;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ConfigFacade {
    public static final String LOCAL_FILE_SYSTEM_CONFIG_PATH = "C://MyApp/configurations";

    public static final String CONFIG_SERVER_PROPERTIES_FILE_NAME = "configServer.properties";
    public static final String REMOTE_CONFIG_HOST = "config.remote.host";
    public static final String REMOTE_CONFIG_PORT = "config.remote.port";

    public static final String CONFIG_FTP_PROPERTIES_FILE_NAME = "configFtp.properties";
    public static final String FTP_CONFIG_HOST = "config.ftp.host";
    public static final String FTP_CONFIG_PORT = "config.ftp.port";
    public static final String FTP_SERVICES_CONFIG_PATH = "ftp://services/cofig";

    private final Map<ConfigUniqueKey, Config> configCache = new HashMap<>();
    FileSystemConfigProvider fileSystemConfigProvider;
    RemoteConfigProvider remoteConfigProvider;
    FtpConfigProvider ftpConfigProvider;

    String remoteConfigLogin;
    String remoteConfigPassword;


    public ConfigFacade() {
        fileSystemConfigProvider = new FileSystemConfigProvider(LOCAL_FILE_SYSTEM_CONFIG_PATH);
    }

    @SneakyThrows
    public Config getFileSystemConfig(String name) {
        return getCachedConfig(() -> fileSystemConfigProvider.getConfig(name),
                               new ConfigUniqueKey(LOCAL_FILE_SYSTEM_CONFIG_PATH, name));
    }

    @SneakyThrows
    public Config getRemoteConfig(String name, String login, String password) {
        return getCachedConfig(() -> {
                                   initRemoteConfigProvider(login, password);
                                   remoteConfigLogin = login;
                                   remoteConfigPassword = password;
                                   return remoteConfigProvider.getConfig(name);
                               },
                               new ConfigUniqueKey(login, name));
    }

    @SneakyThrows
    public Config getFtpConfig(String name) {
        return getCachedConfig(() -> {
                                   initFtpConfigProvider();
                                   return ftpConfigProvider.getConfig(name);
                               },
                               new ConfigUniqueKey(FTP_SERVICES_CONFIG_PATH, name));

    }

    @SneakyThrows
    private void initFtpConfigProvider() {
        if (ftpConfigProvider == null) {
            Config configFtpProperties = new FileSystemConfigProvider(LOCAL_FILE_SYSTEM_CONFIG_PATH).getConfig(CONFIG_FTP_PROPERTIES_FILE_NAME);
            String ftpHost = String.valueOf(configFtpProperties.get(FTP_CONFIG_HOST));
            String ftpPort = String.valueOf(configFtpProperties.get(FTP_CONFIG_PORT));
            ftpConfigProvider = new FtpConfigProvider(ftpHost, ftpPort)
                    .setConfigDirectory(FTP_SERVICES_CONFIG_PATH);
        }
    }

    @SneakyThrows
    private void initRemoteConfigProvider(String login, String password) {
        if (remoteConfigProvider == null || !remoteConfigProvider.getLogin().equals(login)) {
            Config configServerProperties = getFileSystemConfig(CONFIG_SERVER_PROPERTIES_FILE_NAME);
            String host = String.valueOf(configServerProperties.get(REMOTE_CONFIG_HOST));
            String port = String.valueOf(configServerProperties.get(REMOTE_CONFIG_PORT));
            remoteConfigProvider = new RemoteConfigProvider(host, port)
                    .authorize(login, password);
        }
    }

    private Config getCachedConfig(Supplier<Config> supplier, ConfigUniqueKey configUniqueKey) {
        if (configCache.containsKey(configUniqueKey)) {
            return configCache.get(configUniqueKey);
        }
        Config config = supplier.get();
        configCache.put(configUniqueKey, config);
        return config;
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    private static class ConfigUniqueKey {
        String source;
        String name;

    }


}
