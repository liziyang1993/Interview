package com.lzy.util;

import java.util.Random;

public class DataUtil {

    public static int[] swap(int[] nums, int i, int j){

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

        return nums;
    }

    public static int[] generateRandomArray(int number, int max) {
        int[] nums = new int[number];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            nums[i] = random.nextInt(max);
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = generateRandomArray(100, 100);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }
}
