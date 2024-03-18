package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.GenericsDemos;


import java.util.List;

public class Dangerous {
    // static void dangerous(List<String>... stringLists) {
    //     List<Integer> intList = List.of(42);
    //     Object[] objects = stringLists;
    //     objects[0] = intList;
    //     String s = stringLists[0].get(0);
    // }

    public void main(String[] args) {
        Object[] objs = new Object[] {"a", "b", "c"};
        String[] strings = (String[]) objs;
        for (String str : strings) {
            System.out.println(str);
        }

        // String[] strings = new String[] {"a", "b", "c"};
        // for (Object str : (Object[]) strings) {
        //     System.out.println(str);
        // }

    }
}
