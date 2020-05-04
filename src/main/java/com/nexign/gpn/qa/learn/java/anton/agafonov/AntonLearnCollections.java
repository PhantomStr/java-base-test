package com.nexign.gpn.qa.learn.java.anton.agafonov;

import com.nexign.gpn.qa.learn.java.core.LearnCollections;
import org.apache.commons.lang3.RegExUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class AntonLearnCollections implements LearnCollections {
    /**
     * Получив строку с текстом, вернуть Map<String,Integer> с количеством повторений каждого слова (игнорируя регистр).
     * Все слова вернуть в lower case.
     *
     * @param phrase Я знаю, что ничего не знаю
     * @return {"я":1, "знаяю":2, "что":1, "ничего":1, "не":1}
     */
    @Override
    public Map<String, Integer> countWords(String phrase) {
        if (phrase == null) {
            return Collections.emptyMap();
        }
        phrase = phrase.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        String[] split = phrase.split("\\s");
        for (String word : split) {
            word = RegExUtils.removeAll(word, "[^a-zа-я]*");
            if (word.isBlank()) {
                continue;
            }
            int count;
            if (map.get(word) == null) {
                count = 1;
            } else {
                count = map.get(word) + 1;
            }
            map.put(word, count);
        }

        return map;
    }

    /**
     * Получив список чисел, отфильтровать повторяющиеся и отсортировать в порядке возрастания (прямая сортировка).
     *
     * @param unsortedList [5,3,4,2,5,3]
     * @return [2, 3, 4, 5]
     * null-> []
     */
    @Override
    public SortedSet<Integer> toSortedSet(List<Integer> unsortedList) {
        return new TreeSet<>(unsortedList);
    }

    /**
     * Реализовать класс Reverse, который принимает в конструктор строку и при итеративном обходе возвращает слова этой строки начиная с конца.
     *
     * @param str переверни тут всё!
     * @return Reverse или его наследник
     * @throws NullPointerException str=null
     */
    @Override
    public Reverse makeReverse(String str) throws NullPointerException {
        Needls strings = new Needls(str);
        for (String s1: strings){
            System.out.println(s1);
        }
        return strings;
    }

    private static class Needls extends Reverse {
        public Needls(String str) {
            super(str);
        }

        @Override
        public Iterator<String> iterator() {
            return new Iterator<>() {
                String[] words = raw.split("\\s");
                int cursor = words.length - 1;

                @Override
                public boolean hasNext() {
                    return cursor != -1;
                }

                @Override
                public String next() {
                    String next = words[cursor];
                    next = RegExUtils.removeAll(next, "[^a-zа-яA-ZА-ЯЁё]*");
                    cursor--;
                    return next;
                }
            };
        }

    }

}
