package com.nexign.gpn.qa.learn.java.patterns.structural.facade.betersolving;

import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.Config;
import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.FtpConfigProvider;
import lombok.SneakyThrows;

public class FtpConfigFacade extends AbstractConfigFacade {
    public static final String CONFIG_FTP_PROPERTIES_FILE_NAME = "configFtp.properties";
    public static final String FTP_CONFIG_HOST = "config.ftp.host";
    public static final String FTP_CONFIG_PORT = "config.ftp.port";
    public static final String FTP_SERVICES_CONFIG_PATH = "ftp://services/cofig";

    FtpConfigProvider ftpConfigProvider;

    @SneakyThrows
    public Config getConfig(String name) {
        return getCachedConfig(() -> {
                                   initFtpConfigProvider();
                                   return ftpConfigProvider.getConfig(name);
                               },
                               new ConfigUniqueKey(FTP_SERVICES_CONFIG_PATH, name));

    }

    @SneakyThrows
    private void initFtpConfigProvider() {
        if (ftpConfigProvider == null) {
            Config configFtpProperties = new FileSystemConfigFacade().getConfig(CONFIG_FTP_PROPERTIES_FILE_NAME);
            String ftpHost = String.valueOf(configFtpProperties.get(FTP_CONFIG_HOST));
            String ftpPort = String.valueOf(configFtpProperties.get(FTP_CONFIG_PORT));
            ftpConfigProvider = new FtpConfigProvider(ftpHost, ftpPort)
                    .setConfigDirectory(FTP_SERVICES_CONFIG_PATH);
        }
    }

}
