package com.nexign.gpn.qa.learn.java.artem.perestoronin;

import com.nexign.gpn.qa.learn.java.LearnCollections;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class ArtemLearnCollections implements LearnCollections {

    /**
     * Получив строку с текстом, вернуть Map<String,Integer> с количеством повторений каждого слова (игнорируя регистр).
     *
     * @param phrase Я знаю, что ничего не знаю
     * @return {"я":1, "знаяю":2, "что":1, "ничего":1, "не":1}
     */
    @Override
    public Map<String, Integer> countWords(String phrase) {
        Map<String, Integer> result = new HashMap<>();
        if (nonNull(phrase)) {
            String[] split = Arrays.stream(phrase.split("\\s"))
                    .map(word -> RegExUtils.removeAll(word.toLowerCase(), "[^a-zа-яё]"))
                    .filter(StringUtils::isNoneEmpty)
                    .toArray(String[]::new);
            for (String word : split) {
                result.put(word, result.getOrDefault(word, 0) + 1);
            }
        }
        return result;
    }

    /**
     * Получив список чисел, отфильтровать повторяющиеся и отсортировать в порядке возрастания (прямая сортировка).
     *
     * @param unsortedList [5,3,4,2,5,3]
     * @return [2, 3, 4, 5]
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
        return new Reverse(str) {
            @Override
            public Iterator<String> iterator() {
                return Arrays.stream(raw.split("\\s"))
                        .map(word -> RegExUtils.removeAll(word, "[^a-zA-Zа-яА-Яё]"))
                        .filter(StringUtils::isNoneEmpty)
                        .collect(Collectors.toCollection(LinkedList::new))
                        .descendingIterator();
            }
        };
    }

}
