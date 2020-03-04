package com.nexign.gpn.qa.learn.java.core;

public interface LearnArrays {

    /**
     * Для массивов nums1 и nums2.
     * Для каждого элемента в nums1 рассмотрим соответствующий элемент в nums2 (с тем же индексом).
     * Возвратите количество раз, которое два элемента отличаются на 2 или меньше, но не равны.
     *
     * @param nums1 [1,2,3,4,5]
     * @param nums2 [5,4,3,2,1]
     * @return 2
     * @throws IllegalArgumentException невалидные входные параметры
     */
    int matchUp(int[] nums1, int[] nums2) throws IllegalArgumentException;

    /**
     * Для данного массива целых чисел вернуть true,
     * если массив содержит либо 3 четных, либо 3 нечетных значения подряд.
     *
     * @param nums [1,2,3,7,5]
     * @return true
     * @throws IllegalArgumentException невалидные входные параметры
     */
    boolean modThree(int[] nums) throws IllegalArgumentException;

}
