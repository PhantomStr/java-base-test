package com.nexign.gpn.qa.learn.java.patterns.structural.composite.problem;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectTag {
    private final String name = "project";
    private GroupIdTag groupId;
    private ArtifactIdTag artifactId;
    private VersionTag version;
    private BuildTag build;

}
