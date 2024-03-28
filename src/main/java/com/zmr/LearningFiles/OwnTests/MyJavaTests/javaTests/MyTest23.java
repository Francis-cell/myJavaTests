package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import java.util.Arrays;

public class MyTest23 {
    private static  <T>  void printArr(T[] arr) {
        for (T t : arr) {
            System.out.printf(t + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 查看 Java 中一个指定下标元素被删除之后的状态
        Integer[] arr = new Integer[] {1, 2, 3, 4, 5, 6};

        // 要移除的元素
        int val = 5;

        // 先找到元素对应的下标，然后将对应下标位置后面的元素全部向前移动，并将最后一个位置的元素重置
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                index = i;
                break;
            }
        }

        // 数组中元素向前移动
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = 0;
        printArr(arr);
    }
}
