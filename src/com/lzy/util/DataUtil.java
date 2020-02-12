package com.lzy.util;

import java.util.Random;

public class DataUtil {

    public static int[] swap(int[] nums, int i, int j){

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

        return nums;
    }

    public static Integer[] generateRandomArray(int number, int max) {
        Integer[] nums = new Integer[number];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            nums[i] = random.nextInt(max);
        }
        return nums;
    }


}
