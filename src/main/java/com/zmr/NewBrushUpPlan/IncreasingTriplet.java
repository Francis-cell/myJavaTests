package com.zmr.NewBrushUpPlan;

/**
 * @ClassName IncreasingTriplet
 * @Description https://leetcode.cn/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
 * @Author zhumengren
 * @Date 2023/6/2 11:49
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class IncreasingTriplet {
    /***
     * @Description 递增的三元子序列(暴力解)
     * @param nums
     * @return boolean
     */
    public static boolean increasingTriplet01(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (increaseNum(nums[i], nums[j], nums[k])) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    /***
     * @Description 递增的三元子序列 ( 一个最小值 min ，一个次小值 mid)
     * @param nums
     * @return boolean
     */
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        
        // 初始化两个变量，一个最小值，一个次小值
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        
       
        for (int i = 0; i < nums.length; i++) {
            // 遍历的过程中，如果发现有数字 <= min, 更新min
            if (nums[i] <= min) {
                min = nums[i];
            }
            // 否则遍历的过程中，如果发现有数字 <= mid, 更新mid
            else if (nums[i] <= mid) {
                mid = nums[i];
            } 
            // 如果找到值大于mid，则说明存在这个三元递增子序列
            else if (nums[i] > mid) {
                return true;
            }
        }
        return false;
    }
    
    
    /***
     * @Description 如果 a < b < c 则返回true,否则返回false
     * @param a
     * @param b
     * @param c
     * @return boolean
     */
    private static boolean increaseNum (int a, int b, int c) {
        if (a < b && b < c) {
            return true;
        }
        return false;
    }
    
    
    /***
     * @Description 随机数字初始化方法
     * @param maxSize
     * @param maxValue
     * @return int[]
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }
    
    
    /***
     * @Description 数组拷贝
     * @param arr
     * @return int[]
     */
    private static int[] copyArray(int[] arr) {
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
        //int[] nums = new int[] {20,100,10,12,5,13};
        //System.out.println(increasingTriplet01(nums));
        //System.out.println(increasingTriplet(nums));
        
        
        int testTimes = 10000;
        int maxSize = 300;
        int maxValue = 500;

        System.out.println("测试开始！");

        for (int i = 0; i < testTimes; i++) {
            // 初始化随机数组、拷贝数组、比较
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            
            if (increasingTriplet01(arr) != increasingTriplet(arr1)) {
                System.out.println("出错了！");
                break;
            }
        }

        System.out.println("测试结束！");
    }
}
