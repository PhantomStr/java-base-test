package com.nexign.gpn.qa.learn.java.patterns.structural.composite.problem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompositeMain {
    public static void main(String[] args) {
        ProjectTag project = new ProjectTag();

        project.setGroupId(new GroupIdTag("com.nexign.gpn.qa"));
        project.setArtifactId(new ArtifactIdTag("java-base-test"));
        project.setVersion(new VersionTag("1.0.0-SNAPSHOT"));

        BuildTag build = new BuildTag();
        project.setBuild(build);
        PluginsTag plugins = new PluginsTag();
        build.setPlugins(plugins);
        PluginTag plugin = new PluginTag();
        plugins.addPlugin(plugin);
        plugin.setGroupId(new GroupIdTag("org.apache.maven.plugins"));
        plugin.setArtifactId(new ArtifactIdTag("maven-compiler-plugin"));
        ConfigurationTag configuration = new ConfigurationTag();
        plugin.setConfiguration(configuration);
        configuration.setSource(new SourceTag("11"));
        configuration.setTarget(new TargetTag("11"));

        //представим, что нужно вывести содержание такой структуры
        log.info(getContent(project));
    }

    private static String getContent(ProjectTag project) {
        StringBuilder builder = new StringBuilder();
        builder.append(openTag(project.getName())).append("\n\t")
                .append(openTag(project.getGroupId().getName())).append(project.getGroupId().getGroupId()).append(closeTag(project.getGroupId().getName())).append("\n\t")
                .append(openTag(project.getArtifactId().getName())).append(project.getArtifactId().getArtifactId()).append(closeTag(project.getArtifactId().getName())).append("\n\t")
                .append(openTag(project.getVersion().getName())).append(project.getVersion().getVersion()).append(closeTag(project.getVersion().getName())).append("\n\t")
                .append(openTag(project.getBuild().getName())).append("\n\t\t")
                .append(openTag(project.getBuild().getPlugins().getName())).append("\n\t\t");

        for (PluginTag plugin : project.getBuild().getPlugins().getPlugins()) {
            builder.append(openTag(plugin.getName())).append("\n\t\t\t")
                    .append(openTag(plugin.getGroupId().getName())).append(plugin.getGroupId().getGroupId()).append(closeTag(plugin.getGroupId().getName())).append("\n\t\t\t")
                    .append(openTag(plugin.getArtifactId().getName())).append(plugin.getArtifactId().getArtifactId()).append(closeTag(plugin.getArtifactId().getName())).append("\n\t\t\t")
                    .append(openTag(plugin.getConfiguration().getName())).append("\n\t\t\t\t")
                    .append(openTag(plugin.getConfiguration().getSource().getName())).append(plugin.getConfiguration().getSource().getSource()).append(closeTag(plugin.getConfiguration().getSource().getName())).append("\n\t\t\t\t")
                    .append(openTag(plugin.getConfiguration().getTarget().getName())).append(plugin.getConfiguration().getTarget().getTarget()).append(closeTag(plugin.getConfiguration().getTarget().getName())).append("\n\t\t\t\t")
                    .append(closeTag(plugin.getConfiguration().getName())).append("\n\t\t\t")
                    .append(closeTag(plugin.getName()));
            if (project.getBuild().getPlugins().getPlugins().indexOf(plugin) != project.getBuild().getPlugins().getPlugins().size() - 1) {
                builder.append("\n\t\t\t");
            }
        }

        builder.append("\n\t\t")
                .append(closeTag(project.getBuild().getPlugins().getName())).append("\n\t")
                .append(closeTag(project.getBuild().getName())).append("\n")

                .append(closeTag(project.getName()));
        return builder.toString();
    }

    private static String closeTag(String tagName) {
        return "</" + tagName + ">";
    }

    private static String openTag(String tagName) {
        return "<" + tagName + ">";
    }

}
