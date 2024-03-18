package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests.mathTest;

import java.util.Random;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2021/9/23 22:08
 */
public class MathTest01 {
    public static void main(String[] args) {
        usuallyUsed();
        random1();
        System.out.println();
        random2();
        random3();
        System.out.println("=========");
        random4();
    }

    /***
     * 随机生成3个100以内的随机数，没有使用种子
     */
    public static void random4() {
        for (int i = 0; i < 2; i++) {
            System.out.println("执行第" + (i + 1) + "次");
            Random random = new Random();
            for (int j = 0; j < 3; j++) {
                System.out.println("生成[1, 50)的整数值为： " + random.nextInt(50));
            }
        }
    }

    /***
     * 随机生成3个100以内的随机数，种子值为100
     */
    public static void random3() {
        for (int i = 0; i < 2; i++) {
            System.out.println("执行第" + (i + 1) + "次");
            Random random = new Random(100);
            for (int j = 0; j < 3; j++) {
                System.out.println("生成[1, 50)的整数值为： " + random.nextInt(50));
            }
        }
    }
    
    /***
     * 随机产生一个3位随机整数
     */
    public static void random2() {
        int ran = (int)(Math.random()*1000);
        System.out.println(ran);
    }

    /***
     * 通过Math.random产生随机数列[0, 1)之间的随机数
     */
    public static void random1() {
        for (int i = 0; i < 10; i++) {
            System.out.print(Math.random() + " ");
        }
    }

    /***
     * Math常用方法
     */
    public static void usuallyUsed() {
        // abs
        System.out.println(Math.abs(3.6)); // 3.6

        // +
        System.out.println(Math.addExact(1, 2)); // 3

        // -
        System.out.println(Math.subtractExact(2, 1)); // 1

        // 乘法
        System.out.println(Math.multiplyExact(3, 2)); // 6

        // 向上取整
        System.out.println(Math.ceil(3.1)); // 4.0

        // 向下取整
        System.out.println(Math.floor(3.9)); // 3.0

        // m的n次方
        System.out.println(Math.pow(2, 3)); // 8.0

        // 向上向下取整
        // 正数时：(0, 0.5)时向下取整, [0.5, 1)时向上取整
        // 负数时：(-1, 0.5)时向下取整, [-0.5, 0)时向上取整
        System.out.println(Math.round(3.1)); // 3
        System.out.println(Math.round(3.5)); // 4
        System.out.println(Math.round(3.9)); // 4

        System.out.println(Math.round(-3.1)); // -3
        System.out.println(Math.round(-3.5)); // -3
        System.out.println(Math.round(-3.9)); // -4
    }
}
