package com.nexign.gpn.qa.learn.java;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import static java.util.Objects.requireNonNull;

public interface LearnCollections {

    /**
     * Получив строку с текстом, вернуть Map<String,Integer> с количеством повторений каждого слова (игнорируя регистр).
     * Все слова вернуть в lower case.
     *
     * @param phrase Я знаю, что ничего не знаю
     * @return {"я":1, "знаяю":2, "что":1, "ничего":1, "не":1}
     */
    Map<String, Integer> countWords(String phrase);

    /**
     * Получив список чисел, отфильтровать повторяющиеся и отсортировать в порядке возрастания (прямая сортировка).
     *
     * @param unsortedList [5,3,4,2,5,3]
     * @return [2, 3, 4, 5]
     * null-> []
     */
    SortedSet<Integer> toSortedSet(List<Integer> unsortedList);

    /**
     * Реализовать класс Reverse, который принимает в конструктор строку и при итеративном обходе возвращает слова этой строки начиная с конца.
     *
     * @param str переверни тут всё!
     * @return Reverse или его наследник
     * @throws NullPointerException str=null
     */
    Reverse makeReverse(String str) throws NullPointerException;

    abstract class Reverse implements Iterable<String> {
        protected String raw;

        public Reverse(String str) {
            requireNonNull(str);
            raw = str;
        }

    }

}
