package com.nexign.gpn.qa.learn.java.patterns.structural.facade.betersolving;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacadeMain {
    @SneakyThrows
    public static void main(String[] args) {
        ConfigFacade configFacade = new ConfigFacade();
        configFacade.mergeConfig("MyLogin", "P@sSw0rD", new String[]{"pod.properties", "consumerService.properties"}).print();

        log.info("\nTry to find \"consumerService.properties\"");
        configFacade.findPublicConfig("consumerService.properties").print();

    }

}
