package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2023Lists.D1_2.BubbleSort;

import java.util.Arrays;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 插入排序
 * @date 2023/1/2 11:06
 */
public class MyInsertionSort {
    /** 插入排序 */
    static int[] insertionSort(int[] nums) {
        // 外循环：base = nums[1], nums[2], nums[3], ..., nums[n-1]
        // i表示下一个排序完成的元素位置，从第一个元素开始
        for (int i = 1; i < nums.length; i++) {
            // base赋值
            int base = nums[i], j = i - 1;
            // 内循环，将base插入到左边已经排好序的数组部分中
            // 采用数组的数据结构进行存储的，插入元素需要逐个右移元素
            while (j >= 0 && nums[j] > base) {
                // 将nums[j]向右移动一位
                nums[j+1] = nums[j];
                j--;
            }
            // 将base赋值到正确的位置上
            nums[j+1] = base;
        }
        return nums;
    }

    public static void main(String[] args) {
        // 初始化数组
        int[] nums = {1, 4, 5, 7, 3, 6, 0, 2};
        System.out.println(Arrays.toString(insertionSort(nums)));
    }
}
