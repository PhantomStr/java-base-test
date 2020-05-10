package com.nexign.gpn.qa.learn.java.anton.agafonov;

import com.nexign.gpn.qa.learn.java.core.LearnArrays;

public class AntonLearnArrays implements LearnArrays {
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
    @Override
    public int matchUp(int[] nums1, int[] nums2) throws IllegalArgumentException {
        if (nums1 == null || nums2 == null || nums1.length != nums2.length) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (Math.abs(nums1[i] - nums2[i]) <= 2 && nums1[i] != nums2[i]) {
                count++;
            }
        }

        return count;
    }

    /**
     * Для данного массива целых чисел вернуть true,
     * если массив содержит либо 3 четных, либо 3 нечетных значения подряд.
     *
     * @param nums [1,2,3,7,5]
     * @return true
     * @throws IllegalArgumentException невалидные входные параметры
     */
    @Override
    public boolean modThree(int[] nums) throws IllegalArgumentException {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] % 2 == nums[i+1] % 2 && nums[i+1] % 2 == nums[i+2] % 2 ) {
                return true;
            }
        }

        return false;
    }

}