package main.java.com.zmr.MyLeetCodeTests.My2022Lists.D12_25;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Snippet1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入行
        int num = in.nextInt();
        // 获取后两行输入的数据
        int[] wi = new int[num];
        int[] ai = new int[num];
        for(int i = 0; i < num; i++) {
            wi[i] = in.nextInt();
        }
        for(int i = 0; i < num; i++) {
            ai[i] = in.nextInt();
        }

        // 状态方程 f[n] = w[n] + max(f[j]); j满足  (n-j) % a[j] == 0
        // 存储状态方程的值
        int[] fi = new int[num];
        // 将wi的值赋值给fi
        for (int i = 0; i < num; i++) {
            fi[i] = wi[i];
        }

        int max = 0;
        // 外层循环为n的循环，内层循环为j的循环
        for (int n = 0; n < num; n++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                // 如果j满足  (n-j) % a[j] == 0，那么将temp的值替换为Math.max(fi[j], temp)
                if ((n-j) % ai[j] == 0) {
                    temp = Math.max(fi[j], temp);
                }
                // 计算出到达n处时的fi的最大值
                fi[n] = Math.max(wi[n] + temp, fi[n]);
            }
        }

        for (int val: fi) {
            if (val > max) {
                max = val;
            }
        }

        System.out.println(max);
    }
}