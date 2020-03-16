package com.nexign.gpn.qa.learn.java.patterns.creational.builder.problem;

public class Computer {
    public Computer(String motherboard, String ram, String corpus, String mouse, String cpu, String monitor, String keyboard, String videoAdapter, String powerBlock) {
        this.motherboard = motherboard;
        this.ram = ram;
        this.corpus = corpus;
        this.mouse = mouse;
        this.cpu = cpu;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.videoAdapter = videoAdapter;
        this.powerBlock = powerBlock;
    }

    String motherboard;
    String ram;
    String corpus;
    String mouse;
    String cpu;
    String monitor;
    String keyboard;
    String videoAdapter;
    String powerBlock;
}
