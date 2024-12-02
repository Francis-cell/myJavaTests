package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.TestToolsUtils.DataCompareUtils.DataCompareUtils;
import com.zmr.MyUtils.TestToolsUtils.DataCopyUtils.DataCopyUtils;
import com.zmr.MyUtils.TestToolsUtils.GenerateDataUtils.GenerateDataUtils;
import com.zmr.MyUtils.PrintUtils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class NumSum {

    /**
     * <p> 暴力解 </p>
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumCrude(int[] nums, int target) {
        int[] ans = new int[2];

        // 暴力解
        if (nums == null) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int right = nums[j];
                if (left + right == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return null;
    }

    /**
     * <p> 哈希表 </p>
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumWithHashTable(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        // 1、构建整体的 hash 表
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[] {hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        // PrintUtilsImpl prints = PrintUtilsImpl.getInstance();
        //
        // // examples
        // int[] nums1 = new int[] { 2, 7, 11, 15 };
        // int target1 = 9;
        //
        // int[] nums2 = new int[] { 3, 2, 4 };
        // int target2 = 6;
        //
        // int[] nums3 = new int[] { 3, 3 };
        // int target3 = 6;
        //
        // prints.printArr(twoSumWithHashTable(nums1, target1));
        // prints.printArr(twoSumWithHashTable(nums2, target2));
        // prints.printArr(twoSumWithHashTable(nums3, target3));


        // 对撞测试
        int maxValue = 1000;
        int maxSize = 1000;
        int testTime = 1000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            // 随机数组
            int[] nums = GenerateDataUtils.generateRandomIntArray(maxSize, maxValue);
            // 数组拷贝
            int[] numsCopy = DataCopyUtils.copyIntArray(nums);
            // 目标值
            int target = GenerateDataUtils.generateRandomInt(maxValue);

            // 对撞参数
            int[] ans1 = twoSumCrude(nums, target);
            int[] ans2 = twoSumWithHashTable(numsCopy, target);

            if (!DataCompareUtils.isEqualIntArray(ans1, ans2)) {
                System.out.println("测试失败，此时的测试数据为：");
                System.out.println("nums:");
                PrintUtils.printArr(nums);
                System.out.println("target:" + target);
                System.out.println("测试对比结果：");
                System.out.println("arr1: ");
                PrintUtils.printArr(ans1);
                System.out.println("arr2: ");
                PrintUtils.printArr(ans2);
                return;
            }
        }

        System.out.println("测试结束！");
    }
}
