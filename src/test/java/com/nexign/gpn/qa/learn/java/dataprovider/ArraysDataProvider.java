package com.nexign.gpn.qa.learn.java.dataprovider;

import org.testng.annotations.DataProvider;

public class ArraysDataProvider {

    @DataProvider
    public Object[][] matchUp() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}, 2},
                {new int[]{1, 2, 3}, new int[]{2, 3, 10}, 2},
                {new int[]{1, 2, 3}, new int[]{2, 3, 5}, 3},
                {new int[]{5, 3}, new int[]{5, 5}, 1},
                {new int[]{5, 3}, new int[]{4, 4}, 2},
                {new int[]{5, 3}, new int[]{3, 3}, 1},
                {new int[]{5, 3}, new int[]{2, 2}, 1},
                {new int[]{5, 3}, new int[]{1, 1}, 1},
                {new int[]{5, 3}, new int[]{0, 0}, 0},
                {new int[]{3}, new int[]{3}, 0},
                {new int[]{3}, new int[]{5}, 1},
                {new int[]{}, new int[]{}, 0}
        };
    }

    @DataProvider
    public Object[][] matchUpEx() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4}, new int[]{5, 4, 3, 2, 1}},
                {null, new int[]{2, 3, 10}},
                {new int[]{1, 2, 3}, null},
                {null, null}
        };
    }

    @DataProvider
    public Object[][] modThree() {
        return new Object[][]{
                {new int[]{2, 1, 3, 5}, true},
                {new int[]{2, 1, 2, 5}, false},
                {new int[]{2, 4, 2, 5}, true},
                {new int[]{1, 2, 1, 2, 1}, false},
                {new int[]{9, 9, 9}, true},
                {new int[]{1, 2, 1}, false},
                {new int[]{1, 2}, false},
                {new int[]{1}, false},
                {new int[]{}, false},
                {new int[]{9, 7, 2, 9}, false},
                {new int[]{9, 7, 2, 9, 2, 2}, false},
                {new int[]{9, 7, 2, 9, 2, 2, 6}, true}
        };
    }

    @DataProvider
    public Object[][] modThreeEx() {
        return new Object[][]{
                {null}
        };
    }

}
