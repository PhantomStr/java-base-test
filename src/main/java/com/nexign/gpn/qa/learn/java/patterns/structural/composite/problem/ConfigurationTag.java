package com.nexign.gpn.qa.learn.java.patterns.structural.composite.problem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigurationTag {
    private final String name = "configuration";
    SourceTag source;
    TargetTag target;

}
