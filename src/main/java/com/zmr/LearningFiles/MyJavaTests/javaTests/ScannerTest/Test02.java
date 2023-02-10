package main.java.com.zmr.LearningFiles.MyJavaTests.javaTests.ScannerTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2021/9/25 15:33
 */


public class Test02 {
    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
        String str1 = "10";
        int i = Integer.parseInt(str1);
        System.out.println(i);
        double c = Double.parseDouble("5");
        int b = Integer.parseInt("444",16);
        System.out.println(c);
        System.out.println(b);
    }

    /* 实例测试Scanner */

    /* 多行输入元素，其中第一行几个数字表示下面几行的个数*/
    /**
     * 3 4
     * 10 2 3
     * 11 4 5 6
     */

    /**
     * 测试结果：
     * 输入：
     * 3 4
     * 10 2 3
     * 11 4 5 6
     * 验证输入数据的录入情况：
     * [10, 2, 3]
     * [11, 4, 5, 6]
     */
    public static void test01() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入：");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] num1 = new int[m];
        int[] num2 = new int[n];

        // 其他数据类型也一样，String时使用next()即可
        for (int i = 0; i < m; i++) {
            num1[i] = sc.nextInt(); // 将数据一个一个赋值给num1
        }
        for (int i = 0; i < n; i++) {
            num2[i] = sc.nextInt();
        }

        System.out.println("验证输入数据的录入情况：");
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));

        sc.close();
    }

    /* 在一行输入多个参数 */
    /**
     * ABB CCC DDD EEE 123 435
     */

    /**
     * 测试结果：
     * 输入:
     * ABB CCC DDD EEE 123 435
     * 输出数据：
     * ABB CCC DDD  EEE 123 435
     * [ABB, CCC, DDD, EEE, 123, 435]
     */
    public static void test02() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入:");
        String str = sc.nextLine();
        System.out.println("输出数据：");
        System.out.println(str);
        String[] strs = str.trim().split(" ");
        System.out.println(Arrays.toString(strs));
        sc.close();
    }

    /* 每行输入不等数量的参数 */
    /**
     * 3 4
     * AA bcd 123 54
     * AA BB
     * A B C
     */

    /**
     * 测试结果：
     * 输入数据：
     * 3 4
     * AA bcd 123 54
     * AA BB
     * A B C
     * 输出结果：
     * [AA bcd 123 54, AA BB, A B C]
     * [AA, bcd, 123, 54]
     * [AA, BB]
     * [A, B, C]
     */
    public static void test03() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数据：");
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine(); // 很重要，跳到第二行

        // int m = 3;
        String[] strArr = new String[m];
        // 从第二行开始读取
        for (int i = 0; i < m; i++) {
            strArr[i] = sc.nextLine();
        }
        System.out.println("输出结果：");
        System.out.println(Arrays.toString(strArr));

        ArrayList<String[]> strs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] tmp = strArr[i].trim().split(" ");
            strs.add(tmp);
        }
        for (int i = 0; i < strs.size(); i++) {
            System.out.println(Arrays.toString(strs.get(i)));
        }
    }

    /* 需要将读出来的字符串强行转换为数字（parseInt、parseLong等） */
}
