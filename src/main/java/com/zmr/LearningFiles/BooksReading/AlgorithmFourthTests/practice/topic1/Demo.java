package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.practice.topic1;

import java.lang.reflect.Array;

/**
 * @Author franciszmr
 * @Date 2024/3/17 15:23
 * @Version 1.0
 * @Description TODO
 **/
public class Demo {
    public static void main(String[] args) {
        //// 整数溢出
        //System.out.println(Math.abs(-2147483648));
        //
        //// double 变量初始化为无穷大
        //// 1.0 / 0.0
        //double d1 = Double.POSITIVE_INFINITY;
        //// -1.0 / 0.0
        //double d2 = Double.NEGATIVE_INFINITY;

        //System.out.println(-14 / 3);
        //System.out.println(14 / -3);
        //System.out.println(14 % -3);
        //System.out.println(-14 % 3);

        //System.out.println(2.0e-6);
        //System.out.println(2.0e-6 * 100000000.1);


        //double t = 9.0;
        //while (Math.abs(t - 9.0/t) > .001)
        //    t = (9.0/t + t) / 2.0;
        //StdOut.printf("%.5f\n", t);

        //int sum = 0;
        //for (int i = 1; i < 1000; i++)
        //    for (int j = 0; j < i; j++)
        //        sum++;
        //StdOut.println(sum);

        //int sum = 0;
        //for (int i = 1; i < 1000; i *= 2)
        //    //for (int j = 0; j < 1000; j++)
        //    //    sum++;
        //    sum += 1000;
        //StdOut.println(sum);

        //System.out.println('b');
        //
        //System.out.println('b' + 'c');
        //System.out.println((char) ('b' + 'c'));
        //
        //System.out.println((char) ('a' + 4));

        //int N = 3;
        //String s = "";
        //for (int i = N; i > 0 ; i /= 2) {
        //    s = (i % 2) + s;
        //}
        //System.out.println(s);

        //boolean[][] b = {
        //        {true, false, true, false, true},
        //        {false, false, false, true, true},
        //        {true, true, true, true, true},
        //        {true, false, false, true, false},
        //        {true, false, true, false, false}
        //};
        //printBooleanArr(b);

        //int[] a = new int[10];
        //for (int i = 0; i < 10; i++)
        //    a[i] = 9 - i;
        //for (int i = 0; i < 10; i++)
        //    a[i] = a[a[i]];
        //for (int i = 0; i < 10; i++)
        //    System.out.println(a[i]);

        //Integer[][] arr = new Integer[][] {
        //        {1, 2, 3, 4},
        //        {5, 6, 7, 8},
        //        {9, 10, 11, 12},
        //        {13, 14, 14, 16}
        //};
        //Integer[][] ans = reverseArr(Integer.class, arr);
        //printArr(ans);

        System.out.println(lg(-3));
    }

    /**
     * 编写一个静态方法 lg() ，接受一个整型参数 N ，返回不大于log 2 N的最大整数。不要使用Math库
     * @param N
     * @return
     */
    public static int lg(int N) {
        // 负数和0处理
        if (N <= 0) {
            throw new IllegalArgumentException("N must be a positive integer.");
        }

        // 初始的 n 次方的数值
        int index = 0;
        // 当前 n 次方计算出来的结果
        int curVal = 1;
        while (curVal < N) {
            index++;
            curVal = generatePower(2, index);
        }
        return index - 1;
    }

    /**
     * 返回 basicVal ^ N 的结果
     * @param basicVal 基础数据
     * @param N 多少次方
     * @return
     */
    private static int generatePower(int basicVal, int N) {
        // 1、打印出从 2^0 到 2^N 的数值
        //for (int i = 0; i <= N; i++) {
        //    int ans = 1;
        //    // j 表示剩余的 2 的计数
        //    int j = i;
        //    while (j != 0) {
        //        ans *= 2;
        //        j--;
        //    }
        //    System.out.println(ans);
        //}

        // 2、打印出 basicVal^N 的结果
        int ans = 1;
        // i 表示剩余的 basicVal 的计数
        int i = N;
        while (i != 0) {
            ans *= basicVal;
            i--;
        }
        return ans;
    }

    public static void printBooleanArr(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]) {
                    System.out.printf("*");
                } else {
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
    }

    public static <T> T[][] reverseArr(Class<T> clazz, T[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return null;
        }
        int rows = arr[0].length;
        int cols = arr.length;
        // 创建泛型数组
        //T[][] ans = (T[][]) new Object[rows][cols];
        // 对于二维数组，需要手动传入 clazz 才行，下面的这种手段无法获取到数组的类型
        //T[][] ans = (T[][]) Array.newInstance(arr.getClass().getComponentType(), rows, cols);
        T[][] ans = (T[][]) Array.newInstance(clazz, rows, cols);
        // 转置
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ans[j][i] = arr[i][j];
            }
        }
        return ans;
    }

    public static <T> void printArr(T[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
