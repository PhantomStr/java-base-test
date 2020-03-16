package com.nexign.gpn.qa.learn.java.artem.perestoronin;

import com.nexign.gpn.qa.learn.java.core.LearnArrays;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.abs;
import static java.lang.String.format;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.ArrayUtils.isSameLength;
import static org.apache.commons.lang3.ObjectUtils.allNotNull;

public class ArtemLearnArrays implements LearnArrays {

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
        if (allNotNull(nums1, nums2) && isSameLength(nums1, nums2)) {
            int matchUp = 0;
            for (int i = 0; i < nums1.length; i++) {
                int dif = abs(nums1[i] - nums2[i]);
                if (0 < dif && dif <= 2) {
                    matchUp++;
                }
            }
            return matchUp;
        }
        throw new IllegalArgumentException(format("Ожидались массивы одинаковой длины, но получены %s, %s ",
                                                  Arrays.toString(nums1),
                                                  Arrays.toString(nums2)));
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
        if (isNull(nums)) {
            throw new IllegalArgumentException("Ожидался массив, но получен null");
        }
        if (nums.length < 3) {
            return false;
        }
        Boolean[] evens = IntStream.of(nums)
                .mapToObj(i -> (i % 2) == 0)
                .toArray(Boolean[]::new);
        for (int i = 0; i < evens.length - 2; i++) {
            if (evens[i] == evens[i + 1] && evens[i + 1] == evens[i + 2]) {
                return true;
            }
        }
        return false;
    }

}
