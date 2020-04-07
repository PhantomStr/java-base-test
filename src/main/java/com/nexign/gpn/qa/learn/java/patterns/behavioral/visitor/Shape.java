package com.nexign.gpn.qa.learn.java.patterns.behavioral.visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
