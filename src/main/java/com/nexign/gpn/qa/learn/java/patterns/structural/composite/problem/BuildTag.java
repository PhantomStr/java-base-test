package com.nexign.gpn.qa.learn.java.patterns.structural.composite.problem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildTag {
    private final String name = "build";
    PluginsTag plugins;

}
