package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.DynamicProgramming;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/18 22:49
 * @description 机器人行走问题 【暴力递归 --> 动态规划】
 * 补充说明：
 *    动态规划本质（将原本暴力递归过程中，执行的子过程结果存储起来，再次调用的时候直接获取使用，而不需要再次计算）
 *    什么样的暴力递归可以使用动态规划优化
 *    （[可优化]: 有重复调用同一个子问题的解，这种递归可以优化；
 *     [不可优化]: 如果每一个子问题都是不同的解，无法优化也不用优化）
 *     
 * 问题描述:
 *    1、N个位置:                          假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
 *    2、M起始坐标:                        开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
 *    3、1位置只能到2:                     如果机器人来到1位置，那么下一步只能往右来到2位置；
 *    4、N位置只能到N-1:                   如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
 *    5、其他位置可以到(x - 1)或(x + 1)位置: 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 *    6、可以走K步:                        规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 *    给定四个参数 N、start、aim、K，返回方法数。 
 */
public class RobotWalk {
    /** 第一步:设计暴力递归过程的解法 */
    public static int ways1(int N, int start, int aim, int K) { 
        // 处理一些无意义的数据输入情况
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        
        return process1(start, K, aim, N);
    }

    /**
     * 暴力递归写法【递归流程】
     * @param cur 机器人当前所处的位置
     * @param rest 机器人剩余的步数
     * @param aim 最终的目标位置
     * @param N 机器人能到的地方 1~N
     * @return 机器人从cur出发，经过rest步之后，最终停留在aim上，一共有多少种方法？
     */
    public static int process1(int cur, int rest, int aim, int N) {
        // base case
        // 如果rest = 0，说明已经走完了，检查当前位置是否在aim上，如果在，则方法数+1，反之+0
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        // 1、如果cur = 1，那么下一次机器人只能到2位置
        if (cur == 1) {
            return process1(2, rest - 1, aim, N);
        }
        // 2、如果cur = N，那么下一次机器人只能到(N - 1)位置
        if (cur == N) {
            return process1(N - 1, rest - 1, aim, N);
        }
        // 3、其他场景，方法数 = 机器人向左移动1格的方法数 + 机器人向右移动1格的方法数
        return process1(cur - 1, rest - 1, aim, N) +
                process1(cur + 1, rest - 1, aim, N);
    }
    
    
    /** 
     * 第二步：分析这个暴力递归过程中是否会有重复调用的子问题 
     * eg: 1, 2, 3, 4, 5
     * 要求从2 -> 4，可以走5步
     * 
     *         2
     *      1     3
     *      2    2 4  这一行就有两个2了，所以出现了重复的子过程了，可以进行缓存方式的动态规划优化
     *     ...   ...
     */
     public static int ways2(int N, int start, int aim, int K) {
         // 处理一些无意义的数据输入情况
         if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
             return -1;
         }
         
         // 使用一个二维数组存储数据(行代表cur[当前位置], 列代表rest[剩余步数])
         int[][] dp = new int[N + 1][K + 1];
         // 将dp中所有的数据都初始化为-1
         for (int i = 0; i <= N; i++) {
             for (int j = 0; j <= K; j++) {
                 dp[i][j] = -1;
             }
         }
         
         // dp[][]就是用来做缓存的
         // dp[cur][rest] == -1 表示：process2(cur, rest)之前没有算过
         // dp[cur][rest] != -1 表示：process2(cur, rest)之前算过! 可以直接返回使用
         return process2(start, K, aim, N, dp);
     }

    /**
     * 初步优化(借助缓存的动态规划优化)
     * @param cur 当前机器人所在的位置
     * @param rest 机器人剩余的可以走的步数
     * @param aim 机器人最终要抵达的目标位置
     * @param N 机器人能到的地方 1~N
     * @param dp 缓存表
     * @return 机器人从cur出发，经过rest步之后，最终停留在aim上，一共有多少种方法？
     */
     public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
         // 如果发现当前位置在缓存表中存在，则直接返回缓存表中的结果即可
         if (dp[cur][rest] != -1) {
             return dp[cur][rest];
         }
         
         // 否则说明之前没有计算过，所以没有缓存，接下来就是要计算相应的值了
         // 这里使用0，因为即使被计算位置的方法数为0，也可以缓存进去方法数量
         int ans = 0;
         // base case
         if (rest == 0) {
             ans = cur == aim ? 1 : 0;
         } else if (cur == 1) {
             // 当前位置在1位置，只能从1到2去
             ans = process2(2, rest - 1, aim, N, dp);
         } else if (cur == N) {
             // 当前位置在N位置，只能从N到(N - 1)位置上去
             ans = process2(N - 1, rest - 1, aim, N, dp);
         } else {
             // 普通位置，可以向左移动，也可以向右移动
             ans = process2(cur - 1, rest - 1, aim, N, dp) +
                     process2(cur + 1, rest - 1, aim, N, dp);
         }
         // 更新缓存表
         dp[cur][rest] = ans;
         return ans;
     }
     
     
     /** 
      * 第三步：重新根据暴力递归解法，分析dp表中的数据如何产生的，然后写出不需要递归，直接生成这张表的方法 
      * eg: 1, 2, 3, 4, 5
      * 机器人从2位置到4位置，可以移动6步
      * 
      * dp表：dp[cur][rest]
      *     0  1  2  3  4  5  6
      *    ----------------------------------
      * 0 | X  X  X  X  X  X  X
      * 1 | 0  0  0  1  0  4  0 
      * 2 | 0  0  1  0  4  0  13
      * 3 | 0  1  0  3  0  9  0
      * 4 | 1  0  2  0  5  0  14
      * 5 | 0  1  0  2  0  5  0
      * 
      * 
      * 1、因为当cur=0的时候，是不符合规定的数据(1~N位置是机器人可以停留的位置)，所以这些位置的数据都报废掉
      * 然后看最原始的暴力递归分析
      * ①、首先看base case：当rest=0的时候，只有cur = aim的时候才为1，其余部分都为0（更新上方的dp表）
      * ②、cur = 1的时候，取决于cur = 2和(rest - 1) 位置的数据，所以第2行数据依赖于它的【左下角】的数据
      * ③、cur = N的时候，取决于cur = N - 1和(rest - 1)位置的数据，所以第N行依赖于它的【左上角】的数据
      * ④、其余位置的cur位置，取决于它的【左上角】的数据 and 【左下角】的数据
      * ⑤、更新dp表
      * 
      * 上面的dp表更新完成之后，查看dp[2][6]就是最终的结果，所以上面的案例，最终返回的结果应该是13
      */
     public static int ways3(int N, int start, int aim, int K) {
         // 处理一些无意义的数据输入情况
         if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
             return -1;
         }
         
         // 初始化dp表(Java默认初始化int数组的时候，都填写了0值)
         int[][] dp = new int[N + 1][K + 1];
         // 1、更新上面的第①步，当rest = 0的时候，只有当cur = aim的时候，dp中的值才为1，其余的情况下都是0(保持初始化的时候)
         dp[aim][0] = 1;
         
         // 循环计算上面第②③④步骤中产生的数据，更新dp表记录
         // 一列一列的更新
         for (int rest = 1; rest <= K; rest++) {
             // ②、cur = 1的时候，取决于cur = 2和(rest - 1) 位置的数据，所以第2行数据依赖于它的【左下角】的数据
             dp[1][rest] = dp[2][rest - 1];
             // ④、其余位置的cur位置，取决于它的【左上角】的数据 and 【左下角】的数据
             // 直接从第1列开始，因为第0列在上面单独处理了
             for (int cur = 1; cur < N; cur++) {
                 dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
             }
             // ③、cur = N的时候，取决于cur = N - 1和(rest - 1)位置的数据，所以第N行依赖于它的【左上角】的数据
             dp[N][rest] = dp[N - 1][rest - 1];
         }
         
         // 最后直接返回dp表中的记录项即可
         return dp[start][K];
     }
     


    public static void main(String[] args) {
        System.out.println(ways1(5, 2, 4, 6));
        System.out.println(ways2(5, 2, 4, 6));
        System.out.println(ways3(5, 2, 4, 6));
    }
}
