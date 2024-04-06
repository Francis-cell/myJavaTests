package com.zmr.LearningFiles.OwnTests.MyJavaTests.CV;

/**
 * @Author franciszmr
 * @Date 2024/4/6 19:17
 * @Version 1.0
 * @Description TODO
 **/
public class Test01 {
    public static int[] solve (int n, int m, int[] a) {
        // 原始数组 1、2、3、4、5、6、7
        int k = m % n;

        if (m == 0) {
            return a;
        }
        // 第一次颠倒:7、6、5、4、3、2、1
        reverse(a, 0, n - 1);
        // 颠倒： 5、6、7     4、3、2、1
        reverse(a, 0, k - 1);
        // 颠倒剩余部分： 5、6、7    1、2、3、4
        reverse(a, k, n - 1);
        return a;
    }

    /**
     * <p> 数组翻转 </p>
     * @param a
     * @param start
     * @param end
     */
    private static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        int n = 7;
        int m = 3;
        solve(n, m, arr);
        for (int i : arr) {
            System.out.printf(i + ", ");
        }
    }
}
