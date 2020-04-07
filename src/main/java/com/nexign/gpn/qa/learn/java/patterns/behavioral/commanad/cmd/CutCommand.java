package com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.handler.CutCommandHandler;

public class CutCommand implements Command {
    private final CutCommandHandler handler;

    public CutCommand(CutCommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.handleCut();
    }

}
