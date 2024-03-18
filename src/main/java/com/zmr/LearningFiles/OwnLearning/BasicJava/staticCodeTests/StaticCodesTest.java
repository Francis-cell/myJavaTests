package com.zmr.LearningFiles.OwnLearning.BasicJava.staticCodeTests;

/**
 * @ClassName StaticCodesTest
 * @Description 静态代码块测试
 * @Author zhumengren
 * @Date 2022/4/19 16:55
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class StaticCodesTest {
    private static int a;
    private int b;

    static {
        System.out.println("======静态代码块01======");
        StaticCodesTest.a = 3;
        System.out.println(a);

        StaticCodesTest t = new StaticCodesTest();
        t.f();

        t.b = 1000;
        System.out.println(t.b);
    }
    static {
        System.out.println();
        System.out.println("======静态代码块02======");
        StaticCodesTest.a = 4;
        System.out.println(a);
    }
    public static void main(String[] args) {
        // TODO 自动生成方法存根
    }
    static {
        System.out.println();
        System.out.println("======静态代码块03======");
        StaticCodesTest.a = 5;
        System.out.println(a);
    }
    public void f() {
        System.out.println("zmr");
    }
}
