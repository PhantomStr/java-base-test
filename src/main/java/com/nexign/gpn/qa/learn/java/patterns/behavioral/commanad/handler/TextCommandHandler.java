package com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.handler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextCommandHandler implements SaveCommandHandler, CopyCommandHandler, PasteCommandHandler, CutCommandHandler {
    @Override
    public void handleSave() {
        log.info("save");
    }

    @Override
    public void handleCopy() {
        log.info("copy");
    }

    @Override
    public void handlePaste() {
        log.info("paste");
    }

    @Override
    public void handleCut() {
        log.info("cut");
    }

}
