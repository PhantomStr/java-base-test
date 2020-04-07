package com.nexign.gpn.qa.learn.java.patterns.behavioral.iterator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IteratorMain {
    public static void main(String[] args) {
        WeirdIterable<Integer> weirdIterable = new WeirdIterable<>();
        weirdIterable.add(0);
        weirdIterable.add(1);
        weirdIterable.add(2);
        weirdIterable.add(3);
        weirdIterable.add(4);
        weirdIterable.add(5);
        weirdIterable.add(6);

        log.info("try 1");
        weirdIterable.forEach(e -> log.info(e.toString()));
        log.info("try 2");
        weirdIterable.forEach(e -> log.info(e.toString()));
        log.info("try 3");
        weirdIterable.forEach(e -> log.info(e.toString()));
        log.info("try 4");
        weirdIterable.forEach(e -> log.info(e.toString()));
        log.info("try 5");
        weirdIterable.forEach(e -> log.info(e.toString()));
        log.info("try 6");
        weirdIterable.forEach(e -> log.info(e.toString()));
    }

}
