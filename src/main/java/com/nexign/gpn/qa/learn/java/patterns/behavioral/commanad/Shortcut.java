package com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad;


import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd.Command;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class Shortcut {
    Set<String> keys;
    Command command;

    public void execute(){
        command.execute();
    }
}
