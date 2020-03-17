package com.nexign.gpn.qa.learn.java.patterns.structural.composite.problem;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PluginsTag {
    private final String name = "plugins";
    List<PluginTag> plugins;

    public void addPlugin(PluginTag plugin) {
        if (plugins == null) {
            plugins = new ArrayList<>();
        }
        plugins.add(plugin);
    }

}
