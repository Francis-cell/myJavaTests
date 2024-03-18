package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.DynamicProgramming;

import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/23 21:20
 * @description 将 类似 111 转换成英文字母，求解可以转换的方法
 * 111 -- > AAA; AK; KA;
 * 1 -> A; ... 26 -> Z
 */
public class ConvertToLetterString {
    /**
     * 暴力递归方法求解可以转换的方案数量
     * @param str 要进行转换的字符串
     * @return 可以转换的方法数量
     */
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    /**
     * 暴力递归流程
     * @param str char字符数组
     * @param i 从字符数组i位置开始转换，可以有多少种转换方式
     * @return 从i位置开始，可以转换的方法数量
     */
    public static int process(char[] str, int i) {
        // base case
        // 如果i能到达str.length，即数组越界的位置，说明前面走出了一条可以
        // 走完的路线，所以将结果记作1
        if (i == str.length) {
            return 1;
        }
        // i没有走到最后，说明之前的决定存在问题(103 -- > 1~A, 0~?转换失败)
        if (str[i] == '0') {
            return 0;
        }
        
        // str[i] != 0
        // 情况1：单转字符情况
        int ways = process(str, i + 1);
        // 情况2：和后面的字符组合转换
        // 1、i + 1不能越界 (i * 10) + (i + 1) * 1 不能大于26
        if (i + 1 < str.length && (str[i] - '0') * 10 + (str[i+1] - '0') < 27) {
            ways += process(str, i + 2);
        }
        return ways;
    }


    /**
     * 动态规划表方式实现
     * @param s
     * @return
     */
    public static int dp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] str = s.toCharArray();
        int N = str.length;
        // 因为process递归流程中，只有一个变量i，所以要形成的递归表只有一维
        int[] dp = new int[N + 1];
        
        // 写入base case的值
        dp[N] = 1;
        
        // 从上面可以看到，结果是从后面往前收集的，即最后一行向上收集的
        // process(str, i + 1);
        for (int i = N - 1; i >= 0; i--) {
            // 改造自暴力递归， == '0'的时候，值为0，所以只需对非'0'情况处理即可
            if (str[i] != '0') {
                int ways = dp[i + 1];
                // 情况2：和后面的字符组合转换
                // 1、i + 1不能越界 (i * 10) + (i + 1) * 1 不能大于26
                if (i + 1 < str.length && (str[i] - '0') * 10 + (str[i+1] - '0') < 27) {
                    ways += dp[i + 2];
                }
                dp[i] = ways;
            } 
        }
        return dp[0];
    }


    // 为了测试
    public static String randomString(int len) {
        char[] str = new char[len];
        for (int i = 0; i < len; i++) {
            str[i] = (char) ((int) (Math.random() * 10) + '0');
        }
        return String.valueOf(str);
    }

    // 为了测试
    public static void main(String[] args) {
        int N = 30;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * N);
            String s = randomString(len);
            int ans0 = number(s);
            int ans1 = number(s);
            int ans2 = dp(s);
            if (ans0 != ans1 || ans0 != ans2) {
                System.out.println(s);
                System.out.println(ans0);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
