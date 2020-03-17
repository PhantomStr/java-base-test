package com.nexign.gpn.qa.learn.java.patterns.structural.composite.solving;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.repeat;

@Slf4j
public class CompositeMain {
    public static void main(String[] args) {
        Tag project = new Tag("project");

        project.addChild(new Tag("groupId", "com.nexign.gpn.qa"));
        project.addChild(new Tag("artifactId", "java-base-test"));
        project.addChild(new Tag("version", "1.0.0-SNAPSHOT"));

        Tag build = new Tag("build");
        project.addChild(build);
        Tag plugins = new Tag("plugins");
        build.addChild(plugins);
        Tag plugin = new Tag("plugin");
        plugins.addChild(plugin);
        plugin.addChild(new Tag("groupId", "org.apache.maven.plugins"));
        plugin.addChild(new Tag("artifactId", "maven-compiler-plugin"));
        Tag configuration = new Tag("configuration");
        plugin.addChild(configuration);
        configuration.addChild(new Tag("source", "11"));
        configuration.addChild(new Tag("target", "11"));

        // нужно вывести содержание такой структуры придётся писать сложные рекурсивные функции

        log.info(getContent(project));
        log.info(getContent(plugins));
        log.info(getContent(configuration));

    }

    private static String getContent(Tag tag) {return getContent(tag, 0);}

    private static String getContent(Tag tag, int ident) {
        String identChars = "  ";
        String content = tag.getContent();
        if (content != null) {
            return repeat(identChars, ident) + formatTag(tag);
        }
        List<Tag> childes = tag.getChildes();
        if (childes != null) {
            StringBuilder builder = new StringBuilder();
            builder.append(repeat(identChars, ident)).append("<").append(tag.getName()).append(">\n");
            for (Tag child : childes) {
                builder.append(getContent(child, ident + 1));
            }
            builder.append(repeat(identChars, ident)).append("</").append(tag.getName()).append(">\n");
            return builder.toString();
        }
        return repeat(identChars, ident) + format("<%s/>", tag.getName());
    }

    private static String formatTag(Tag tag) {
        return format("<%s>%s</%s>\n", tag.getName(), tag.getContent(), tag.getName());
    }


}
