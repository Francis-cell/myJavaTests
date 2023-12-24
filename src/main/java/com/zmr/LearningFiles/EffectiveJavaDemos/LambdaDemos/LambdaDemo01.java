package com.zmr.LearningFiles.EffectiveJavaDemos.LambdaDemos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo01 {

    /***
     * 匿名内部类 demo
     */
    public static void anonymousClassTest(List<String> words) {
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
    }

    /***
     * lambda demo
     */
    public static void lambdaTest(List<String> words) {
        Collections.sort(words,
                (a, b) -> Integer.compare(a.length(), b.length()));
    }

    public static void simpleCompare(List<String> words) {
        Collections.sort(words,
                Comparator.comparingInt(String::length));
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("xiaohei");
        words.add("agen");
        // 使用匿名内部类
        // anonymousClassTest(words);

        // 使用 lambda 实现
        lambdaTest(words);
        for (String str : words) {
            System.out.println(str);
        }
    }
}
