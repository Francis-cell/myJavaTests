package com.zmr.LearningFiles.BasicJava.MutilParamsTests;

import java.util.Arrays;

public class MultiParamsDemo {

    private static void multiParams(Object... values) {
        System.out.println(Arrays.toString(values));
    }

    public static void main(String[] args) {
        multiParams(1, 2, 3);
    }
}
