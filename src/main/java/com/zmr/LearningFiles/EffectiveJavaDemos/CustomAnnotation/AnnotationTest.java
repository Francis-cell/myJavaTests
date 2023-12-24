package com.zmr.LearningFiles.EffectiveJavaDemos.CustomAnnotation;

/**
 * 自定义注解测试运行类
 */
public class AnnotationTest {

    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        System.out.println("run");
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        System.out.println("run");
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {
        System.out.println("run");
    }

    // public static void main(String[] args) throws Exception {
    //     // m1();
    //     m2();
    //     // m3();
    // }
}
