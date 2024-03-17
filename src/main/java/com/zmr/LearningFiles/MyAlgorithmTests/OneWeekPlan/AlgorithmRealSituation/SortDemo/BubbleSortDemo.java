package com.zmr.LearningFiles.MyAlgorithmTests.OneWeekPlan.AlgorithmRealSituation.SortDemo;

import java.util.Arrays;

/**
 * <p> 冒泡排序摸底 </p>
 * <p> 习题链接：https://leetcode.cn/problems/sort-colors/description/ </p>
 */
public class BubbleSortDemo {
    public static void bubbleSortArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // 交换元素位置
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * <p> 数组交换两个位置的元素 </p>
     * @param arr
     * @param indexA
     * @param indexB
     */
    public static void swap(int [] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    /**
     * <p> 对数器 </p>
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * <p> 随机数组生成器 </p>
     * @param maxSize
     * @return
     */
    public static int[] generateRandomArray(int maxSize) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = (int) (Math.random() * (maxValue + 1));
        // }
        
        // 数组元素刚好只有 0、1、2
        for (int i = 0; i < arr.length; i++) {
            double tmpVal = Math.random();
            if (tmpVal < 3.3) {
                arr[i] = 0;
            } else if (tmpVal < 6.6) {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }
        
        return arr;
    }

    /**
     * <p> 数组拷贝 </p>
     * @param arr
     * @return
     */
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

    /**
     * <p> 数组比较 </p>
     * @param arr1
     * @param arr2
     * @return
     */
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

    /**
     * <p> 数组打印 </p>
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTimes = 1000000;
        int maxSize = 300;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机数组
            int[] arr1 = generateRandomArray(maxSize);
            int[] arr2 = copyArray(arr1);

            bubbleSortArr(arr1);
            comparator(arr2);
            if (!isEqualArray(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
