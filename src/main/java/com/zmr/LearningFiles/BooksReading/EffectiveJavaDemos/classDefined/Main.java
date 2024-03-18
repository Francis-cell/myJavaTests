package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.classDefined;

import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 获取到不可修改的列表
        List<Thing> values = FinalClassDemo.VALUES;

        // 尝试修改列表，将返回 UnsupportedOperationException
        try {
            values.add(new Thing("thing4", "demo4"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Can't modify the unmodifiable list.");
        }

        // 打印列表内容
        for (Thing thing: values) {
            System.out.println(thing);
        }

        new BigInteger("10");
    }
}
