package com.zmr.LearningFiles.MyAlgorithmTests.DynamicProgramming;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/24 22:50
 * @description 最长回文子序列--示例型动态规划题目
 * 测试链接：https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * 1、方式1（这里不采用）：使用之前的最长公共子序列方式进行求解【String str和自己的翻转字符串strRerverse之间找最长公共子序列，就是最终的结果】
 * 2、方式2（范围动态规划尝试）: f(String str, int start, int end)
 */
public class PalindromeSubSequence {
    /** 暴力递归尝试 */
    public static int longestCommonSubsequence01(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return process(str, 0, str.length - 1);
    }
    
    /** 暴力递归方程 */
    public static int process(char[] str, int L, int R) {
        // base case
        // 如果只有一个字符，则它本身就是回文的，所以返回1
        if (L == R) {
            return 1;
        }
        // 如果有两个字符，则判断这两个字符是否一样，如果一样返回2，否则返回1
        if (L == R - 1) {
            return str[L] == str[R] ? 2 : 1;
        }
        
        // TODO--典型范围示例（需要|考虑左右边界情况）
        // 1、左边界L取不到，右边界R取不到
        int p1 = process(str, L + 1, R - 1);
        // 2、左边界L可以取到，右边界R取不到
        int p2 = process(str, L, R - 1);
        // 3、左边界L取不到，右边界R可以取到
        int p3 = process(str, L + 1, R);
        // 4、左边界L可以取到，右边界R也可以取到
        // 这时候需要考虑L是否和R位置的字符相同
        int p4 = str[L] != str[R] ? 0 : (2 + process(str, L + 1, R - 1));
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    /**
     * 第一次优化--动态规划表
     * @param s
     * @return
     *            
     * eg: str = "abcdeccda"
     *     
     *        a  b  c  d  e  c  c  d  a
     *        0  1  2  3  4  5  6  7  8
     *      -----------------------------
     * a  0 | 1  1  
     * b  1 | X  1  1  
     * c  2 | X  X  1  1  
     * d  3 | X  X  X  1  1
     * e  4 | X  X  X  X  1  1  ④  ⑤  ⑥
     * c  5 | X  X  X  X  X  1  2  ②  ③        
     * c  6 | X  X  X  X  X  X  1  1  ①      N - 3
     * d  7 | X  X  X  X  X  X  X  1  1     N - 2
     * a  8 | X  X  X  X  X  X  X  X  1     N - 1
     * 
     * 1、首先 L不可能小于R，所以左下三角全部数据都无效
     * 2、对角线上数据全是1
     * 3、紧贴对角线的斜线，如果str[L] == str[R]，那么值为2，否则为1
     * 4、其他位置求，①左；②右；③左下；
     */
    public static int longestCommonSubsequence02(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        
        // process()中的两个变量分别是L和R，都收到N的限制
        int N = str.length;
        int[][] dp = new int[N][N];
        // 先初始化上面dp[8][8]位置的数据，这样可以一次填写两条斜线的数据
        dp[N - 1][N - 1] = 1;
        // 上面提到的2和3的初始化
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }
        // 上面提到的4的初始化(会发现从N - 3行初始化)
        for (int L = N - 3; L >= 0; L--) {
            // L + 2可以参考上面的案例，①位置，L = 6，列为8，所以+2
            for (int R = L + 2; R < N; R++) {
                // 经过观察，可以看到情况4：数据依赖于①左；②右；③左下；所以当前位置必然比左；左下；下；三个位置中任意一个位置的值都大
                // 但是”左“必然比”左下“大
                // 同样的”下“也比”左下“大
                
                // 所以，先比较"左"和"下"的大小
                dp[L][R] = Math.max(dp[L + 1][R], dp[L][R - 1]);
                // 和暴力递归中的p4进行比较
                if (str[L] == str[R]) {
                    dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }

    public static void main(String[] args) {
        String str = "abcdeccda";
        System.out.println(longestCommonSubsequence01(str));
        System.out.println(longestCommonSubsequence02(str));
    }
}
