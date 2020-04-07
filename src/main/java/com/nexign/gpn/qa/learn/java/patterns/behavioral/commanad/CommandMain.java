package com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad;

import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd.CopyCommand;
import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd.CutCommand;
import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd.PasteCommand;
import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.cmd.SaveCommand;
import com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad.handler.TextCommandHandler;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class CommandMain {
    public static void main(String[] args) {
        TextCommandHandler commandHandler = new TextCommandHandler();

        SaveCommand save = new SaveCommand(commandHandler);
        CopyCommand copy = new CopyCommand(commandHandler);
        PasteCommand paste = new PasteCommand(commandHandler);
        CutCommand cut = new CutCommand(commandHandler);

        ShortcutListener shortcutListener = new ShortcutListener();
        shortcutListener.registerShortcut(new Shortcut(Stream.of("CTRL", "S").collect(toSet()), save));
        shortcutListener.registerShortcut(new Shortcut(Stream.of("CTRL", "C").collect(toSet()), copy));
        shortcutListener.registerShortcut(new Shortcut(Stream.of("CTRL", "ALT", "Y").collect(toSet()), copy));
        shortcutListener.registerShortcut(new Shortcut(Stream.of("CTRL", "V").collect(toSet()), paste));
        shortcutListener.registerShortcut(new Shortcut(Stream.of("CTRL", "X").collect(toSet()), cut));

        Button saveButton = new Button("Save", save);
        Button copyButton = new Button("Copy", copy);
        Button pasteButton = new Button("Paste", paste);
        Button cutButton = new Button("Cut", cut);

        copyButton.click();
        pasteButton.click();
        cutButton.click();
        saveButton.click();

        shortcutListener.trigger(new ShortcutListener.Event("CTRL C"));
        shortcutListener.trigger(new ShortcutListener.Event("CTRL V"));
        shortcutListener.trigger(new ShortcutListener.Event("CTRL N"));
        shortcutListener.trigger(new ShortcutListener.Event("CTRL ALT Y"));
    }

}
