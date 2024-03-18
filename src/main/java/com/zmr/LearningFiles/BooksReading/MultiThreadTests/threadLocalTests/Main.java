package com.zmr.LearningFiles.BooksReading.MultiThreadTests.threadLocalTests;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // SafePoint p1 = new SafePoint(1, 3);
        // SafePoint p2 = new SafePoint(p1);
        //
        // HashMap<String, String> map = new HashMap<>();
        // map.put("S", "a");

        Integer[] array = {1, 2, 3, 4, 5};
        // int target = 3;
        Integer target = null;

        int index = Arrays.binarySearch(array, target);
        if (index < 0) {
            System.out.println("元素不在数组中");
        } else {
            System.out.println("元素在数组中，位于索引 " + index);
        }
    }
}
