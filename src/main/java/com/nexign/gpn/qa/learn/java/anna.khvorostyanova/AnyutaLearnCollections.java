package com.nexign.gpn.qa.learn.java.anna.khvorostyanova;

import com.nexign.gpn.qa.learn.java.core.LearnCollections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnyutaLearnCollections implements LearnCollections {

    /**
     * Получив строку с текстом, вернуть Map<String,Integer> с количеством повторений каждого слова (игнорируя регистр).
     *
     * @param phrase Я знаю, что ничего не знаю
     * @return {"я":1, "знаю":2, "что":1, "ничего":1, "не":1}
     */
    @Override
    public Map<String, Integer> countWords(String phrase) {
        Map<String, Integer> counter = new TreeMap<>();
        if (phrase!=null) {
            Arrays.asList(phrase.replaceAll("[,.!—?]", "")
                    .split("[\\s]+"))
                    .forEach(word -> counter.put(word.toLowerCase(),
                            counter.getOrDefault(word, 0) + 1));
        }
        return counter;
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
//задание на отдохнуть?
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
        return new Reverse(str) {
            @Override
            public Iterator<String> iterator() {
                return new LinkedList<>(Stream.of(str.replaceAll("[!?,]", "")
                        .split("[\\s]"))
                        .collect(Collectors.toList()))
                        .descendingIterator();
            }
        };
    }
}
