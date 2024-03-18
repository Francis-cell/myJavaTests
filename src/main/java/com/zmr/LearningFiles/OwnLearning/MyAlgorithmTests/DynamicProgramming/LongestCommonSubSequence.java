package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.DynamicProgramming;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/24 21:15
 * @description 最长公共子序列计算
 * 链接：https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubSequence {
    /** 最长公共子序列方法 */
    public static int longestCommonSubsequence1(String s1, String s2) {
        // 边界条件
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        
        return process1(str1, str2, str1.length - 1, str2.length - 1);
    }
    
    /** 暴力递归的递归方法流程 */
    public static int process1(char[] str1, char[] str2, int i, int j) {
        // base case
        // 如果str1和str2的长度都为1
        if (i == 0 && j == 0) {
            // 检查两个元素的值是否一致，如果一致，则最长公共子序列的长度为1，否则为0
            return str1[i] == str2[j] ? 1 : 0;
        } 
        // 只有str1的长度为1，str2的长度 > 1
        else if (i == 0) {
            // 如果str2的最后一个字符和str1仅有的字符一致，则为1
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                // 否则str2向前继续查看是否有和str1相同的字符
                return process1(str1, str2, i, j - 1);
            }
        } 
        // 只有str2的长度为1，同理
        else if (j == 0) {
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return process1(str1, str2, i - 1, j);
            }
        }
        // 否则就是普通的情况，str1的长度 > 1，str2的长度也 > 1
        else {
            // 一共需要考虑3种情况（注意：这里属于教科书式的案例）
            // str1[0...i], str2[0...j]
            // 1、i"可能"为最长公共子序列的末尾，j"不"为最长公共子序列的末尾
            int p1 = process1(str1, str2, i, j - 1);
            // 2、i"不"为最长公共子序列的末尾，j"可能"为最长公共子序列的末尾
            int p2 = process1(str1, str2, i - 1, j);
            // 3、i为最长公共子序列的末尾，j为最长公共子序列的末尾
            // 这种情况下str1[i]和str2[j]的字符必须一致，然后向前递归即可
            int p3 = str1[i] == str2[j] ? (1 + process1(str1, str2, i - 1, j - 1)) : 0;
            
            // 最后求出这三种情况的最大值
            return Math.max(p1, Math.max(p2, p3));
        }
    }
    
    
    /** 暴力递归改动态规划表方式解决问题 */
    public static int longestCommonSubsequence2(String s1, String s2) {
        // 边界条件
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        // 观察暴力递归process流程中的变量，发现 i 和 j 是里面存在的变量
        // 以 i(对应str1的长度) 和 j(对应str2的长度) 构建对应的二维表即可
        int N = str1.length;
        int M = str2.length;
        int[][] dp = new int[N][M];
        
        // 将base case中的值插入进来
        // 1、i == 0 和 j == 0的时候
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        
        // 2、i == 0 的时候
        for (int j = 1; j < M; j++) {
            dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
        }
        
        // 3、j == 0 的时候
        for (int i = 1; i < N; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        
        return dp[N - 1][M - 1];
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "def";
        System.out.println(longestCommonSubsequence2(str1, str2));
    }
}
