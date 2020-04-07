package com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.handler.SaveCommandHandler;

public class SaveCommand implements Command {
    SaveCommandHandler handler;

    public SaveCommand(SaveCommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.handleSave();
    }

}
