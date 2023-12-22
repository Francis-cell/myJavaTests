package com.zmr.LearningFiles.EffectiveJavaDemos.originClass;

import java.util.ArrayList;
import java.util.List;

public class OriginClassDemo01 {
    // 通过了编译，但是没有通过运行（java.lang.Integer cannot be cast to java.lang.String）
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    // // 无法通过编译
    // private static void unsafeAdd(List<Object> list, Object o) {
    //     list.add(o);
    // }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0);
        System.out.println(s);
    }
}
