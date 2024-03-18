package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.MethodsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTest {

    public static List<String> getString(List<String> innerList) {
        return innerList.isEmpty() ? Collections.emptyList() : new ArrayList<String>(innerList);
    }

    public static List<String> getString01(List<String> innerList) {
        return innerList.isEmpty() ? null : new ArrayList<String>(innerList);
    }

    public static void main(String[] args) {
        List<String> testList01 = new ArrayList<>();
        testList01.add("1");
        testList01.add("2");
        testList01.add("3");
        List<String> testList02 = new ArrayList<>();
        System.out.println(getString(testList01));
        System.out.println(getString(testList02));


    }
}
