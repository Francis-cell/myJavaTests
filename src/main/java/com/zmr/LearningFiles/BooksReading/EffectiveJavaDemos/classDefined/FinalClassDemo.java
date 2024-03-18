package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.classDefined;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FinalClassDemo {
    private static final Thing[] PRIVATE_VALUES = {
            new Thing("thing1", "demo1"),
            new Thing("thing2", "demo2"),
            new Thing("thing3", "demo3")
    };

    // 返回一个不可修改的列表，意味着你不可通过该列表修改其元素
    public static final List<Thing> VALUES =
            Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    public static final Thing[] values() {
        return PRIVATE_VALUES.clone();
    }
}
