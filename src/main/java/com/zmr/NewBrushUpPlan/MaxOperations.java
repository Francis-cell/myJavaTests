package com.zmr.NewBrushUpPlan;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description https://leetcode.cn/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
 **/
public class MaxOperations {
    /**
     * @Description K 和数对的最大数目(暴力解)
     * @param nums
     * @param k
     * @return int
     */
    public static int maxOperations(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == k && nums[i] != -1 && nums[j] != -1) {
                    ans++;
                    nums[i] = -1;
                    nums[j] = -1;
                }
            }
        }
        return ans;
    }


    /**
     * @Description K 和数对的最大数目 结合hashMap的处理方法
     * @param nums
     * @param k
     * @return int
     */
    public static int maxOperations01(int[] nums, int k) {
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        // 第一遍遍历nums的时候，将nums中的数据依次放入到hashMap中
        for (int i = 0; i < nums.length; i++) {
            // 1、先在map中查看是否已经存在了数据，且它的key != 0
            if (map.containsKey(k - nums[i]) && map.get(k - nums[i]) != 0) {
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
                ans++;
                continue;
            }
            
            // 2、将数据存放到map中
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }


        return ans;
    }

    
    /**
     * @Description K 和数对的最大数目  双指针解法 首先排序（如果两个值的和就是当前的值，那么直接ans+1,如果过小，则左指针向右移动，如果过大则右指针向左移动）
     * @param nums
     * @param k
     * @return int
     */
    public static int maxOperations02(int[] nums, int k) {
        int ans = 0;

        // 排序
        Arrays.sort(nums);
        // 定义头尾指针
        int i = 0, j = nums.length - 1;
        
        while (i < j) { 
            if (nums[i] + nums[j] == k) {
                ans++;
                i++;
                j--;
            } 
            // 说明值比较大，只需要移动右指针让值变小即可
            else if (nums[i] + nums[j] > k) {
                j--;
            }
            // 说明值比较小，只需要移动左指针让值变大即可
            else {
                i++;
            }
        }

        return ans;
    }




    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1;
        }
        return arr;
    }
    
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        
        int[] tmpArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmpArray[i] = arr[i];
        }
        
        return tmpArray;
    }
    
    public static int generateRandomOperate(int maxOperation) {
        return (int) (Math.random() * maxOperation) + 1;
    }

    public static void main(String[] args) {
        //int[] nums = new int[] {9, 4, 7, 2, 5, 1, 5, 8, 8};
        //int[] nums1 = new int[] {9, 4, 7, 2, 5, 1, 5, 8, 8};
        //int k = 10;
        //System.out.println(maxOperations(nums, k));
        //System.out.println(maxOperations01(nums1, k));
        
        int testTimes = 10000;
        int maxValue = 10;
        int maxSize = 10;

        int maxOperation = 100;

        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 初始化随机数组，拷贝数组，生成比较
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);

            // 生成随机操作数
            int operations = generateRandomOperate(maxOperation);

            if (maxOperations(arr, operations) != maxOperations01(arr1, operations) && maxOperations(arr, operations) != maxOperations02(arr1, operations)) {
                System.out.println("出错了！");
                System.out.println(Arrays.toString(arr1));
                System.out.println("操作数：" + operations);
                break;
            }
        }
        System.out.println("测试结束!");
    }
}
