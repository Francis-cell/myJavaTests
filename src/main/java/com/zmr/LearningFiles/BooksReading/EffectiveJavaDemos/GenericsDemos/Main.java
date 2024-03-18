package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.GenericsDemos;

public class Main {
    public static void main(String[] args) {
        // Object[] objs = new Object[] {"a", "b", "c"};
        // String[] strings = (String[]) objs;
        // for (String str : strings) {
        //     System.out.println(str);
        // }

        String[] strings = new String[] {"a", "b", "c"};
        for (Object str : (Object[]) strings) {
            System.out.println(str);
        }
    }
}
