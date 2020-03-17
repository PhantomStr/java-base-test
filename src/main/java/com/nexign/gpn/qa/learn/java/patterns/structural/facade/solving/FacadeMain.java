package com.nexign.gpn.qa.learn.java.patterns.structural.facade.solving;

import com.nexign.gpn.qa.learn.java.patterns.structural.facade.problem.Config;
import lombok.SneakyThrows;

public class FacadeMain {
    @SneakyThrows
    public static void main(String[] args) {
        ConfigFacade configFacade = new ConfigFacade();

        Config podConfig = configFacade.getRemoteConfig("pod.properties", "MyLogin", "P@sSw0rD");
        Config consumerServiceConfig = configFacade.getFtpConfig("consumerService.properties");

        Config allConfigs = new Config("ALL")
                .add(podConfig)
                .add(consumerServiceConfig);

        allConfigs.print();

    }

}
