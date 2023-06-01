package com.zmr.NewBrushUpPlan;

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


    ///***
    // * 除自身以外数组的乘积(暴力递归)
    // * @param nums
    // * @return
    // */
    //public static int[] productExceptSelf(int[] nums) {
    //    
    //}
    
    
    public static void main(String[] args) {
        int[] nums = new int[] {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf01(nums)));
    }
}
