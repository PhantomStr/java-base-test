package com.nexign.gpn.qa.learn.java;

import com.nexign.gpn.qa.learn.java.core.LearnCollections;
import com.nexign.gpn.qa.learn.java.dataprovider.CollectionsDataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public abstract class LearnCollectionsTest extends AbstractTest<LearnCollections> {

    @Test(dataProvider = "countWords", dataProviderClass = CollectionsDataProvider.class)
    public void countWords(String phrase, Map<String, Integer> expected) {
        assertThat(testedClass.countWords(phrase))
                .containsAllEntriesOf(expected)
                .hasSameSizeAs(expected);
    }

    @Test(dataProvider = "toSortedSet", dataProviderClass = CollectionsDataProvider.class)
    public void toSortedSet(List<Integer> unsortedList, Integer[] expected) {
        assertThat(testedClass.toSortedSet(unsortedList)).containsExactly(expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void toSortedSetEx() {
        testedClass.toSortedSet(null);
    }

    @Test(dataProvider = "makeReverse", dataProviderClass = CollectionsDataProvider.class)
    public void makeReverse(String phrase, String[] expected) {
        assertThat(testedClass.makeReverse(phrase)).containsExactly(expected);
    }

}