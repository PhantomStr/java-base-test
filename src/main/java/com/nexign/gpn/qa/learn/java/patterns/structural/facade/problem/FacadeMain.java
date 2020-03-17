package com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem;

import lombok.SneakyThrows;

public class FacadeMain {
    //такие константы должны быть не в свалке а раскиданы по соответствующим классам, но сейчас не об этом
    public static final String REMOTE_CONFIG_HOST = "config.remote.host";
    public static final String REMOTE_CONFIG_PORT = "config.remote.port";
    public static final String FTP_CONFIG_HOST = "config.ftp.host";
    public static final String FTP_CONFIG_PORT = "config.ftp.port";
    public static final String REMOTE_CONFIG_LOGIN = "config.remote.login";
    public static final String REMOTE_CONFIG_PASSWORD = "config.remote.password";

    @SneakyThrows
    public static void main(String[] args) {

        Config configServerProperties = new FileSystemConfigProvider("C://MyApp/configurations").getConfig("configServer.properties");
        String host = String.valueOf(configServerProperties.get(REMOTE_CONFIG_HOST));
        String port = String.valueOf(configServerProperties.get(REMOTE_CONFIG_PORT));

        Config podConfig = new RemoteConfigProvider(host, port)
                .authorize("MyLogin", "P@sSw0rD")
                .getConfig("pod.properties");

        Config configFtpProperties = new FileSystemConfigProvider("C://MyApp/configurations").getConfig("configFtp.properties");

        String ftpHost = String.valueOf(configFtpProperties.get(FTP_CONFIG_HOST));
        String ftpPort = String.valueOf(configFtpProperties.get(FTP_CONFIG_PORT));

        Config consumerServiceConfig = new FtpConfigProvider(ftpHost, ftpPort)
                .setConfigDirectory("ftp://services/cofig")
                .getConfig("consumerService.properties");

        Config allConfigs = new Config("ALL")
                .add(podConfig)
                .add(consumerServiceConfig);

        allConfigs.print();

    }

}
