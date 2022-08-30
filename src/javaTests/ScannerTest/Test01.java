package javaTests.ScannerTest;

import java.util.Scanner;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2021/9/25 15:15
 */
public class Test01 {
    public static void main(String[] args) {
        nextTest();
//        nextLineTest();
//        nextLineAndNext();
    }

    /**
     * next部分
     *
     * eg:
     * next方式接收数据
     * run able
     * 输入的数据为：run
     */
    public static void nextTest() {
        Scanner sc = new Scanner(System.in);

        // next方式接收字符串
        System.out.println("next方式接收数据");

        // 判断是否有数据输入
        if (sc.hasNext()) {
            String str = sc.next();
            System.out.println("输入的数据为：" + str);
        }
        sc.close();
    }

    /**
     * nextLine部分
     *
     * eg:
     * nextLine方式接收数据
     * run now
     * 输入的数据为：run now
     */
    public static void nextLineTest() {
        Scanner sc = new Scanner(System.in);

        // nextLine方式接收字符串
        System.out.println("nextLine方式接收数据");

        // 判断是否还有数据输入
        if (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println("输入的数据为：" + str);
        }

        sc.close();
    }

    /**
     * next和nextLine之间的区别
     *
     * eg:
     * 输入整数
     * 12
     * 整数的数据为12
     * 输入小数
     * 1.4
     * 小数数据为：1.4
     */
    public static void nextLineAndNext() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        float f = 0.0f;

        // 输入整数
        System.out.println("输入整数");
        if (sc.hasNextInt()) {
            // 判断输入的是否为整数
            i = sc.nextInt();
            System.out.println("整数的数据为" + i);
        } else {
            System.out.println("输入的数不是整数");
        }

        // 输入小数
        System.out.println("输入小数");
        if (sc.hasNextFloat()) {
            f = sc.nextFloat();
            System.out.println("小数数据为：" + f);
        } else {
            System.out.println("输入的数据不是小数");
        }
        sc.close();
    }
}
