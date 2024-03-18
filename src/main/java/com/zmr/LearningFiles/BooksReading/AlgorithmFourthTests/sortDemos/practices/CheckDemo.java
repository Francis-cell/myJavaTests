package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.sortDemos.practices;

import java.util.Arrays;

public class CheckDemo {
    public static boolean check(int[] arr) {
        // 排序前的数组，需要进行拷贝一下
        int[] arrCopy = copyArray(arr);
        // 原数组排序
        Arrays.sort(arr);
        return compareArr(arr, arrCopy);
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
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * <p> 比较两个数组中的元素是否一致 </p>
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean compareArr(int[] arr1, int[] arr2) {
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

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 19, 8, 10};
        System.out.println(check(arr));
    }
}
