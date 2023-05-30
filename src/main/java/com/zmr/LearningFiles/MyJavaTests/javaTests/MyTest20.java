package com.zmr.LearningFiles.MyJavaTests.javaTests;

import java.util.Arrays;

/**
 * @ClassName MyTest12
 **/
public class MyTest20 {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int b = 4;

        System.out.println(hasElement(a, b));
    }
    
    public static boolean hasElement(int[] arr, int val) {
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == val) {
                return true;
            } else if (arr[mid] < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
