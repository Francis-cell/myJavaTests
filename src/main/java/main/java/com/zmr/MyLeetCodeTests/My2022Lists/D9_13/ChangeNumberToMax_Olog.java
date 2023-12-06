package main.java.com.zmr.MyLeetCodeTests.My2022Lists.D9_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description 给定一个非负整数，至多交换一次数字中的任意两位，返回你能得到的最大值
 * eg:2736--》7236
 *    9973不必交换
 * 数字范围: [0-10^8]                                 100000000
 * Java中int的范围：-2^31--2^31-1  ---- -2147483648——2147483647
 * 由此可见此处给出的数字范围还在int的范围之内
 **/
public class ChangeNumberToMax_Olog {
    public static int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10); num /= 10;
        }
        int n = list.size(), ans = 0;
        int[] idx = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            if (list.get(i) > list.get(j)) j = i;
            idx[i] = j;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(idx[i]) != list.get(i)) {
                int c = list.get(idx[i]);
                list.set(idx[i], list.get(i));
                list.set(i, c);
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {ans = ans * 10 + list.get(i);};
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(maximumSwap(num));
    }
}
