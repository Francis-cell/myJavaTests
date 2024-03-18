package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.CustomAnnotation;

public class ExceptionDemoTest {

    @ExceptionDemo(IndexOutOfBoundsException.class)
    @ExceptionDemo(NullPointerException.class)
    public static void doublyBad() {
        String a = null;
        System.out.println("run");
        System.out.println(a.length());
    }

    // public static void main(String[] args) {
    //     doublyBad();
    // }
}
