package com.lzy.top100;

import com.lzy.util.DataUtil;

import java.util.Comparator;
/**
 * 面试题：一次遍历，从10000个数中，选择最大的前100个数，通过小顶堆结构实现
 * */
public class Top100 {
    public static void main(String[] args) {
        Integer[] data = DataUtil.generateRandomArray(10000, 10000);
        for (int i : data) System.out.print(i + ",");
        System.out.println();
        Integer[] nums = new Integer[100];
        for (int i = 0; i < 100; i++) nums[i] = data[i];
        Heap<Integer> heap = new Heap<>(nums, new comparetor());
        for (int i = 100; i < data.length; i++) {
            if (data[i] > heap.root()) heap.setRoot(data[i]);
        }
        heap.traversHeap();
    }
}

class comparetor implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
