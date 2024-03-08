package com.zmr.LearningFiles.AlgorithmFourthTests.basicDemos;

import java.util.Arrays;

/**
 * <p> 二分查找算法简单实现 </p>
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        // 数组需要是有序的
        Arrays.sort(a);

        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            // 被查找的元素要么不存在，要么必然能存在在 a[low, high]之间
            int middle = low + (high - low) >> 1;
            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * <p> 随机一个数组（数组大小和数组元素均进行随机） </p>
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArr(int maxSize, int maxValue) {
        int size = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    /**
     * <p> 数组打印 </p>
     * @param arr
     */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 1000;
        // 随机数组
        int[] arr = generateRandomArr(maxSize, maxValue);
        // 要查找的元素的值
        int value = 29;
        if (rank(value, arr) != -1) {
            System.out.println("找到了元素，对应的数组元素为：");
            printArr(arr);
        } else {
            System.out.println("很抱歉，元素没有找到，数组元素为：");
            printArr(arr);
        }
    }
}
