package com.nexign.gpn.qa.learn.java.patterns.structural.composite.solving;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Tag {
    private final String name;
    private String content;
    private List<Tag> childes;

    public Tag(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public void addChild(Tag child) {
        if (content != null) {
            throw new IllegalArgumentException("Tag already contain content!");
        }
        if (childes == null) {
            childes = new ArrayList<>();
        }
        childes.add(child);
    }

}
