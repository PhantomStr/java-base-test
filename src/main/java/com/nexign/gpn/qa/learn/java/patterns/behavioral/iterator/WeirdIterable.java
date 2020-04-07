package com.nexign.gpn.qa.learn.java.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.lang3.RandomUtils.nextBoolean;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class WeirdIterable<E> implements Iterable<E> {
    List<E> elements = new ArrayList<>();

    public boolean add(E element) {
        return elements.add(element);
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return nextBoolean();
            }

            @Override
            public E next() {
                int nextInt = nextInt(0, elements.size());
                return elements.get(nextInt);
            }
        };
    }

}
