package com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.handler.PasteCommandHandler;

public class PasteCommand implements Command {
    private PasteCommandHandler handler;

    public PasteCommand(PasteCommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.handlePaste();
    }

}
