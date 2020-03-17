package com.nexign.gpn.qa.learn.java.patterns.structural.facade.betersolving;

import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.Config;
import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.RemoteConfigProvider;
import lombok.SneakyThrows;

public class RemoteConfigFacade extends AbstractConfigFacade {
    public static final String CONFIG_SERVER_PROPERTIES_FILE_NAME = "configServer.properties";
    public static final String REMOTE_CONFIG_HOST = "config.remote.host";
    public static final String REMOTE_CONFIG_PORT = "config.remote.port";

    String remoteConfigLogin;
    String remoteConfigPassword;

    RemoteConfigProvider remoteConfigProvider;

    @SneakyThrows
    public Config getConfig(String name, String login, String password) {
        return getCachedConfig(() -> {
                                   initRemoteConfigProvider(login, password);
                                   remoteConfigLogin = login;
                                   remoteConfigPassword = password;
                                   return remoteConfigProvider.getConfig(name);
                               },
                               new ConfigUniqueKey(login, name));
    }

    @SneakyThrows
    private void initRemoteConfigProvider(String login, String password) {
        if (remoteConfigProvider == null || !remoteConfigProvider.getLogin().equals(login)) {
            Config configServerProperties = new FileSystemConfigFacade().getConfig(CONFIG_SERVER_PROPERTIES_FILE_NAME);
            String host = String.valueOf(configServerProperties.get(REMOTE_CONFIG_HOST));
            String port = String.valueOf(configServerProperties.get(REMOTE_CONFIG_PORT));
            remoteConfigProvider = new RemoteConfigProvider(host, port)
                    .authorize(login, password);
        }
    }

}
