package com.nexign.gpn.qa.learn.java.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.collections.Lists.newArrayList;

public class CollectionsDataProvider {

    @DataProvider
    public Object[][] countWords() {
        return new Object[][]{
                {"Тем, кто хочет учиться, часто вредит авторитет тех, кто учит.",
                        newHashMap(
                                new String[]{"тем", "кто", "хочет", "учиться", "часто", "вредит", "авторитет", "тех", "учит"},
                                new Integer[]{1, 2, 1, 1, 1, 1, 1, 1, 1})},
                {"Философия и медицина сделали человека самым разумным из животных, гадание и астрология — самым безумным, суеверие и деспотизм — самым несчастным.",
                        newHashMap(
                                new String[]{"философия", "и", "медицина", "сделали", "человека", "самым", "разумным", "из", "животных", "гадание", "астрология", "безумным", "суеверие", "деспотизм", "несчастным"},
                                new Integer[]{1, 3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1})},
                {" ", new HashMap<>()},
                {null, new HashMap<>()}
        };
    }

    @DataProvider
    public Object[][] toSortedSet() {
        return new Object[][]{
                {newArrayList(5, 3, 4, 2, 5, 3), new Integer[]{2, 3, 4, 5}},
                {newArrayList(9, 7, 2, 9, 2, 0, 6), new Integer[]{0, 2, 6, 7, 9}},
                {newArrayList(0, -1, 1), new Integer[]{-1, 0, 1}},
                {newArrayList(-5, -7, -6), new Integer[]{-7, -6, -5}},
                {new ArrayList<>(), new Integer[]{}}
        };
    }

    @DataProvider
    public Object[][] makeReverse() {
        return new Object[][]{
                {"переверни тут всё!", new String[]{"всё", "тут", "переверни"}},
                {"Oh, boy, so you actually learned something today? What is this, Full House?",
                        new String[]{"House", "Full", "this", "is", "What", "today", "something", "learned", "actually", "you", "so", "boy", "Oh"}},
        };
    }

    private <K, V> Map<K, V> newHashMap(K[] keys, V[] values) {
        assertThat(keys).hasSameSizeAs(values);
        Map<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

}
