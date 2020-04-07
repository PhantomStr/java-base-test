package com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.handler.CopyCommandHandler;

public class CopyCommand implements Command {
    CopyCommandHandler handler;

    public CopyCommand(CopyCommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.handleCopy();
    }

}
