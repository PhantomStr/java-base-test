package com.nexign.gpn.qa.learn.java.patterns.behavioral.commanad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class ShortcutListener {
    private Set<Shortcut> registered = new HashSet<>();

    public void registerShortcut(Shortcut shortcut) {
        registered.add(shortcut);
    }

    // логика отлова событий...
    public void trigger(Event event) {
        handleEvent(event.getKeys().split(" "));
    }

    private void handleEvent(String[] keys) {
        registered.stream()
                .filter(sc -> keys.length == sc.keys.size() && Stream.of(keys).collect(toSet()).containsAll(sc.keys))
                .findFirst()
                .ifPresent(Shortcut::execute);
    }

    @Getter
    @AllArgsConstructor
    public static class Event {
        String keys;

    }

}
