package com.nexign.gpn.qa.learn.java.patterns.structural.composite.problem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PluginTag {
    private final String name = "plugin";
    GroupIdTag groupId;
    ArtifactIdTag artifactId;
    ConfigurationTag configuration;

}
