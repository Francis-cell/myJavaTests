package com.zmr.LearningFiles.MyJavaTests.javaTests;

/**
 * @ClassName MyTest12
 **/
public class MyTest21 {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] b = a.clone();
//        b[2] = 10;
        a[2] = 10;
        for (int tmpA : a) {
            System.out.println(tmpA);
        }
        System.out.println("-------------------");
        for (int tmpB : b) {
            System.out.println(tmpB);
        }
    }
}
