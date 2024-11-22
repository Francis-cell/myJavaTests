package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.PrintUtils.impl.PrintUtilsImpl;
import com.zmr.MyUtils.TestToolsUtils.GenerateDataUtils.GenerateDataUtils;
import com.zmr.MyUtils.TestToolsUtils.WatchUtils.WatchUtils;

/**
 * <p> 盛水最多的容器 </p>
 */
public class MaxArea {
    /**
     * <p> 暴力解 O(n^2) </p>
     * @param height
     * @return
     */
    public static int maxAreaCrude(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int ans = 0;
        // 获取到 i ~ j 之间的最小高度，然后 * 间距 = 能放入的水的面积大小
        for (int i = 0; i < height.length; i++) {
            int outWeight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                // 当前边界的高度值
                int innerWeight = height[j];
                // 设置最小高度的值给 minHeight
                int minHeight = Math.min(outWeight, innerWeight);
                int tmpArea = (j - i) * minHeight;
                if (ans < tmpArea) {
                    ans = tmpArea;
                }
            }
        }
        return ans;
    }

    /**
     * <p> 双指针解法 </p>
     * @param height
     * @return
     */
    public static int maxAreaWithTwoCur(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        // 1、创建左右指针，移动较小的那个指针位置的值
        int leftCur = 0;
        int rightCur = height.length - 1;
        int maxArea = 0;
        while (leftCur != rightCur) {
            // 计算当前的面积
            int currentArea = Math.min(height[leftCur], height[rightCur]) * (rightCur - leftCur);
            maxArea = Math.max(currentArea, maxArea);
            if (height[leftCur] >= height[rightCur]) {
                rightCur--;
            } else {
                leftCur++;
            }
        }
        return maxArea;
    }

    /**
     * <p> 双指针解法（优化） </p>
     * @param height
     * @return
     */
    public static int maxAreaWithTwoCurForBetter(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        // 1、创建左右指针，移动较小的哪个指针位置的值
        int leftCur = 0;
        int rightCur = height.length - 1;
        int maxArea = 0;
        while (leftCur != rightCur) {
            // 当前边界的最小高度
            int h = Math.min(height[leftCur], height[rightCur]);
            // 计算当前的面积
            int currentArea = h * (rightCur - leftCur);
            maxArea = Math.max(currentArea, maxArea);
            // 减少计算的步骤，提前进行指针的向左向右移动
            while (leftCur != rightCur && height[rightCur] <= h) {
                rightCur--;
            }
            while (leftCur != rightCur && height[leftCur] <= h) {
                leftCur++;
            }
        }
        return maxArea;
    }

    /**
     * <p> 递归解法 </p>
     * @param height
     * @return
     */
    public static int maxAreaForRecursion(int[] height) {
        return solve(height, 0, height.length - 1);
    }

    /**
     * <p> 递归代码块 </p>
     * @param height
     * @param left
     * @param right
     * @return
     */
    public static int solve(int[] height, int left, int right) {
        // 终止条件
        if (left == right) {
            return 0;
        }

        int area = 0;
        area = (right - left) * Math.min(height[left], height[right]);
        return Math.max(area, height[left] < height[right] ? solve(height, left + 1, right) : solve(height, left, right - 1));
    }

    public static void main(String[] args) {
        // 49
        // int[] height1 = new int[] {1,8,6,2,5,4,8,3,7};
        // 1
        // int[] height2 = new int[] {1, 1};

        // System.out.println(maxAreaWithTwoCurForBetter(height1));
        // System.out.println(maxAreaWithTwoCurForBetter(height2));

        // 对撞测试
        WatchUtils.timeExecutionNano(() -> {
            int maxSize = 1000;
            int maxValue = 10000;
            int testTime = 100000;
            System.out.println("测试开始！");
            for (int i = 0; i < testTime; i++) {
                // 随机数组
                int[] arr = GenerateDataUtils.generateRandomIntArray(maxSize, maxValue);

                // 暴力解
                int ans1 = maxAreaCrude(arr);
                // 双指针解
                // int ans2 = maxAreaWithTwoCur(arr);
                // 双指针优化解
                int ans2 = maxAreaWithTwoCurForBetter(arr);
                // 递归解
                // int ans2 = maxAreaForRecursion(arr);
                if (ans1 != ans2) {
                    System.out.println("测试失败！");
                    System.out.println("当前数组为：");
                    PrintUtilsImpl.getInstance().printArr(arr);
                    System.out.println("ans1: " + ans1);
                    System.out.println("ans2: " + ans2);
                    return;
                }
            }
            System.out.println("测试结束！");
        });
    }
}