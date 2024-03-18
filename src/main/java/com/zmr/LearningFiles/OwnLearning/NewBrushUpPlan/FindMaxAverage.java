package com.zmr.LearningFiles.OwnLearning.NewBrushUpPlan;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/6/6 21:57
 * @description https://leetcode.cn/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
 */
public class FindMaxAverage {
    /**
     * 子数组最大平均数 I      找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。 （暴力解 + 前缀和数组 + 滑动窗口）
     * @param nums  n == nums.length  n == nums.length  -104 <= nums[i] <= 104
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        // 1、先计算出整个nums的k前缀和数组
        int[] sumNums = new int[nums.length - k + 1];
        int sumIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 这段区域的数据都是属于k前缀和数组的第一个元素的值的
            if (i < k) {
                sumNums[sumIndex] += nums[i];
            } 
            // 后面形成的k前缀和数组中的值只需要添加上下一个元素，删除 i - k位置上的元素的值即可
            else {
                sumNums[++sumIndex] = sumNums[sumIndex - 1] + nums[i] - nums[i - k];
            }
        }

        //System.out.println("形成的前缀和数组为：" + Arrays.toString(sumNums));
        
        
        double tmp = sumNums[0];
        // 2、循环遍历前缀和数组，然后从中找到最大值最后返回
        for (int i = 1; i < sumNums.length; i++) {
            // 直接找到最大值
            tmp = Math.max(tmp, sumNums[i]);
        }
        
        return tmp / k;
    }


    /**
     * 子数组最大平均数 I      找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。 （滑动窗口解法）
     * @param nums  n == nums.length  n == nums.length  -104 <= nums[i] <= 104
     * @param k
     * @return
     */
    public static double findMaxAverage01(int[] nums, int k) {
        // 1、先计算出整个nums的k前缀和数组
        int sumTemp = 0;
        // 用于记录最大和
        int maxSum = Integer.MIN_VALUE; 
        for (int i = 0; i < nums.length; i++) {
            // 这段区域的数据都是属于k前缀和数组的第一个元素的值的
            if (i < k) {
                sumTemp += nums[i];
                if (i == k - 1) {
                    // 初始化最大和
                    maxSum = sumTemp; 
                }
            }
            // 后面形成的k前缀和数组中的值只需要添加上下一个元素，删除 i - k位置上的元素的值即可
            else {
                sumTemp = sumTemp + nums[i] - nums[i - k];
                // 更新最大和
                maxSum = Math.max(maxSum, sumTemp);
            }
        }

        // System.out.println("中途形成的最大值为：" + maxSum);

        return (double) maxSum / k;
    }

    
    /**
     * 随机初始化数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue + 1) - (int) (Math.random() * maxValue + 1);
        }
        return arr;
    }


    /**
     * 拷贝数组arr中的值
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        
        int[] tmpArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = arr[i];
        }
        return tmpArr;
    }
    
    public static void main(String[] args) {
        //int[] nums = new int[] {0,4,0,3,2};
        //int k = 1;
        //
        //System.out.println(findMaxAverage(nums, k));
        //System.out.println(findMaxAverage01(nums, k));
        
        
        int testTimes = 10000;
        int maxValue = 1000;
        int maxSize = 10000;

        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机初始化数组，随机初始化k的值，计算、比较
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int tmpK = (int) (Math.random() * arr.length) + 1;
            
            if (findMaxAverage(arr, tmpK) != findMaxAverage01(arr1, tmpK)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
