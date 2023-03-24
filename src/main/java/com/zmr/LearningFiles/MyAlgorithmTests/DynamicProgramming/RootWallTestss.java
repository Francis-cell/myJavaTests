package com.zmr.LearningFiles.MyAlgorithmTests.DynamicProgramming;

/**
 * @ClassName RootWallTestss
 * @Description 机器人走路测试
 **/
public class RootWallTestss {
    /** 暴力递归方式 N--> 范围：1~N */
    public static int ways1(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        return process1(start, K, aim, N);
    }
    
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        // 当处于最左侧的时候
        if (cur == 1) {
            return process1(2, rest - 1, aim, N);
        }
        // 当处于最右侧的时候
        if (cur == N) {
            return process1(N - 1, rest - 1, aim, N);
        }
        // 当处于普遍位置的时候
        return process1(cur + 1, rest - 1, aim, N) + process1(cur - 1, rest - 1, aim, N);
    }

    /** 第一次优化 */
    public static int ways2(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        // 声明一个二维数组存储数据 f[cur][rest]
        int[][] f = new int[N+1][K+1];
        // 初始化二维数组中的数据为-1
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                f[i][j] = -1;
            }
        }
        
        return process2(start, K, aim, N, f);
    }
    
    public static int process2(int cur, int rest, int aim, int N, int[][] f) {
        // 触发
        if (f[cur][rest] != -1) {
            return f[cur][rest];
        }
        
        int ans = 0;
        // base case
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(2, rest - 1, aim, N, f);
        } else if (cur == N) {
            ans = process2(N - 1, rest - 1, aim, N, f);
        } else {
            ans = process2(cur + 1, rest - 1, aim, N, f) + process2(cur - 1, rest - 1, aim, N, f);
        }
        f[cur][rest] = ans;
        return ans;
    }
    
    
    /** 动态规划表: N--1~N, start: 开始位置, aim: 目标位置, K: 步数 */
    public static int ways3(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 0) {
            return -1;
        }
        
        int[][] dp = new int[N + 1][K + 1];
        // 初始化第一列数据
        dp[aim][0] = 1;

        for (int rest = 1; rest <= K; rest++) {
            // 第一行数据
            dp[1][rest] = dp[2][rest - 1];
            // 初始化普通行数据
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            // 最后一行数据
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        
        return dp[start][K];
    }
    
    

    public static void main(String[] args) {
        System.out.println(ways1(5, 2, 4, 6));
        System.out.println(ways2(5, 2, 4, 6));
        System.out.println(ways3(5, 2, 4, 6));
    }
}
