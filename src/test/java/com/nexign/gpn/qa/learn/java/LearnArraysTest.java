package com.nexign.gpn.qa.learn.java;

import com.nexign.gpn.qa.learn.java.core.LearnArrays;
import com.nexign.gpn.qa.learn.java.dataprovider.ArraysDataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class LearnArraysTest extends AbstractTest<LearnArrays> {

    @Test(dataProvider = "matchUp", dataProviderClass = ArraysDataProvider.class)
    void matchUp(int[] num1, int[] num2, int expected) {
        assertThat(testedClass.matchUp(num1, num2)).isEqualTo(expected);
    }

    @Test(dataProvider = "matchUpEx", dataProviderClass = ArraysDataProvider.class,
            expectedExceptions = IllegalArgumentException.class)
    void matchUpIllegal(int[] num1, int[] num2) {
        testedClass.matchUp(num1, num2);
    }

    @Test(dataProvider = "modThree", dataProviderClass = ArraysDataProvider.class)
    void modThree(int[] nums, boolean expected) {
        assertThat(testedClass.modThree(nums)).isEqualTo(expected);
    }

    @Test(dataProvider = "modThreeEx", dataProviderClass = ArraysDataProvider.class,
            expectedExceptions = IllegalArgumentException.class)
    void modThree(int[] nums) {
        testedClass.modThree(nums);
    }

}
