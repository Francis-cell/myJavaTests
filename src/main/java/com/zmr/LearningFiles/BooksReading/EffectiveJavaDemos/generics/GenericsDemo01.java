package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author franciszmr
 * @Date 2023/12/18 22:02
 * @Version 1.0
 * @Description TODO
 **/
public class GenericsDemo01 {
    public static void main(String[] args) {
        // 数组和泛型的比较

        // 数组
        // Fails at runtime
        Object[] objectArray = new Long[1];
        // Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
        objectArray[0] = "I don't fit in.";

        // 泛型
        // Won't compile
        //List<Object> ol = new ArrayList<Long>();
        //ol.add("I don't fit in");
    }
}
