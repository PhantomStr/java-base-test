package com.nexign.gpn.qa.learn.java.patterns.creational.builder.solving;

public class BuilderMain {
    public static void main(String[] args) {
        Computer.ComputerBuilder builder = Computer.builder();

        String motherboard = getMotherBoard();
        builder.motherboard(motherboard);

        String cpu = getCpu();
        builder.cpu(cpu);

        builder.build();

    }

    private static String getCpu() {
        return "i7";
    }

    private static String getMotherBoard() {
        return "asdasd";
    }

}
