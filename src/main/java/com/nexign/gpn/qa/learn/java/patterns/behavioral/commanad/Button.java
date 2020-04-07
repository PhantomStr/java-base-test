package com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd.Command;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Button {
    String name;
    Command command;

    public void click(){
        command.execute();
    }
}
