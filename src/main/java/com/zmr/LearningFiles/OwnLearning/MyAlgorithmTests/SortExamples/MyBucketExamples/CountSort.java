package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.SortExamples.MyBucketExamples;

import java.util.Arrays;

/**
 * @ClassName CountSort
 * @Description 计数排序[限制：只能对正整数做排序]
 **/
public class CountSort {
    /** 计数排序 */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 找到整个要排序的arr中的最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        
        // 创建max + 1个桶
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        
        // 返回最终结果
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            // 桶中还有数据
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
    
    /** 对数器 */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /** 随机数组 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random()*(maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(maxSize + 1));
        }
        return arr;
    }
    
    /** 数组拷贝 */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        return tmp;
    }
    
    /** 数组比较 */
    public static boolean isEqualArray(int[] arr1, int[] arr2) {
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
    
    /** 数组打印 */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            // 随机数组，拷贝，处理，比较
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            countSort(arr1);
            comparator(arr2);
            if (!isEqualArray(arr1, arr2)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
