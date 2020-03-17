package com.nexign.gpn.qa.learn.java.patterns.structural.facade.betersolving;

import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.Config;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class ConfigFacade {
    FileSystemConfigFacade fileSystemConfigFacade = new FileSystemConfigFacade();
    RemoteConfigFacade remoteConfigFacade = new RemoteConfigFacade();
    FtpConfigFacade ftpConfigFacade = new FtpConfigFacade();

    public Config getFileSystemConfig(String name) {
        return fileSystemConfigFacade.getConfig(name);
    }

    public Config getRemoteConfig(String name, String login, String password) {
        return remoteConfigFacade.getConfig(name, login, password);
    }

    public Config getFtpConfig(String name) {
        return ftpConfigFacade.getConfig(name);
    }

    public Config findPublicConfig(String name) {return findConfig(null, null, name);}

    public Config findConfig(String login, String password, String name) {
        Config fileSystemConfig = getFileSystemConfig(name);
        if (!fileSystemConfig.isEmpty()) return fileSystemConfig;

        Config ftpConfig = getFtpConfig(name);
        if (!ftpConfig.isEmpty()) return ftpConfig;

        if (StringUtils.isAllBlank(login, password)) { return new Config(name); }

        Config remoteConfig = getRemoteConfig(name, login, password);
        if (!remoteConfig.isEmpty()) { return remoteConfig; }

        return new Config(name);
    }


    public Config mergePublicConfig(String... names) {return mergeConfig(null, null, names);}

    public Config mergeConfig(String login, String password, String[] names) {
        return new Config("ALL").add(Arrays.stream(names)
                                             .map(name -> findConfig(login, password, name))
                                             .reduce(Config::add).orElse(new Config("ALL")));
    }

}
