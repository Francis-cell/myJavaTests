package com.zmr.NewBrushUpPlan;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/6/1 23:12
 * @description https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
 */
public class ProductArraysOtherThanItself {
    /***
     * 除自身以外数组的乘积(暴力解法--对数器方法)
     * @param nums
     * @return
     */
    public static int[] productExceptSelf01(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        
        if (nums.length == 1) {
            return new int[] {0};
        }
        
        int[] lastArrNums = new int[nums.length];

        // 外层 lastArrNums 的层级
        for (int i = 0; i < nums.length; i++) {
            lastArrNums[i] = 1;
            // 内层 nums 的层级
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    lastArrNums[i] *= nums[j];
                }
            }
        }
        return lastArrNums;
    }


    /***
     * 除自身以外数组的乘积 (总乘积 / 当前的值) -- 前提是当前的值不是0
     * @param nums
     * @return
     */
    public static int[] productExceptSelf02(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        
        if (nums.length == 1) {
            return new int[1];
        }
        
        int[] ans = new int[nums.length];
        
        // 用于存放乘积的值
        int pruduct = 1;
        // 建立一个ArrayList用来存放值为0的元素的下标
        ArrayList<Integer> tmpZeroValueIndexs = new ArrayList<>();
        // 首先计算出整体的乘积，并且保留包含0位置的元素（如果它是0，先记载下来它的坐标，然后把它当作1使用）
        for (int i = 0; i < nums.length; i++) {
            // 查看当前是否为0
            if (nums[i] != 0) {
                pruduct *= nums[i];
            } else {
                tmpZeroValueIndexs.add(i);
            }
        }

        // 如果有0元素存在的话，除了0位置本身不为0，其余位置均为0
        if (tmpZeroValueIndexs.size() == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (tmpZeroValueIndexs.contains(i)) {
                    ans[i] = pruduct;
                } else {
                    ans[i] = 0;
                }
            } 
        }
        
        // 如果没有0的存在，则所有位置的值等于 product / nums[i] 的值
        if (tmpZeroValueIndexs.size() == 0) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = pruduct / nums[i];
            }
        }
        
        return ans;
    }


    /**
     * 随机一个整数数组出来
     * @param maxSize
     * @param maxValue
     */
    private static int[] generateRandomArr(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }


    /**
     * 检查两个数组是否一致
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean isEqualArray(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 != null || arr1 != null && arr2 == null) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 拷贝数组
     * @param arr
     * @return
     */
    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        
        int[] tmpArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tmpArray[i] = arr[i];
        }
        return tmpArray;
    }
    
    
    public static void main(String[] args) {
        int[] nums = new int[] {11, -17, 22, 4, 13, -2, 12, 3, -16, 1, -20, -16, -25, 1};
        System.out.println(Arrays.toString(productExceptSelf01(nums)));
        System.out.println(Arrays.toString(productExceptSelf02(nums)));
        
        //int testTimes = 5000;
        //int maxSize = 100;
        //int maxValue = 30;
        //
        //System.out.println("开始测试!");
        //
        //for (int i = 0; i < testTimes; i++) {
        //    // 随机出数组出来
        //    int[] arr = generateRandomArr(maxSize, maxValue);
        //    // 拷贝数组
        //    int[] arr1 = copyArray(arr);
        //
        //    if (!isEqualArray(productExceptSelf02(arr), productExceptSelf01(arr1))) {
        //        System.out.println("出错了！");
        //
        //        System.out.println(Arrays.toString(arr));
        //
        //        break;
        //    }
        //}
        //
        //System.out.println("测试完成！");
    }
}
