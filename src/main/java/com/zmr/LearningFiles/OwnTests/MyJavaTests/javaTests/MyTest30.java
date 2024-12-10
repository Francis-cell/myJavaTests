package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import com.zmr.MyUtils.TestTools.PrintUtils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

public class MyTest30 {
    public static void main(String[] args) {
        String[] strings = {"Please", "sort", "the", "strings", "in", "REVERSE", "order"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return -a.compareToIgnoreCase(b);
            }
        });

        PrintUtils.printArr(strings);
    }
}
