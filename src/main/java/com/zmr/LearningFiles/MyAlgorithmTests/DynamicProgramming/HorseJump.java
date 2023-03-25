package com.zmr.LearningFiles.MyAlgorithmTests.DynamicProgramming;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/25 10:10
 * @description 跳马问题 -- 三维动态规划问题
 * 
 * 题目描述：
 * 请同学们自行搜索或者想象一个象棋的棋盘
 * 然后把整个棋盘放入第一象限, 棋盘的最左下角是(0, 0)位置
 * 那么整个棋盘就是横坐标上9条线, 纵坐标上 10 条线的区域
 * 给你三个参数 x, y, k
 * 返回 马从(0, 0)位置出发必须走 k 步
 * 最后落在(x, y)上的方法数有多少种 ?
 */
public class HorseJump {
    /**
     * 暴力递归方式实现
     * @param x 目标横坐标
     * @param y 目标纵坐标
     * @param k
     * @return
     */
    public static int jump(int x, int y, int k) {
        return process(0, 0, k, x, y);
    }

    /**
     * 暴力递归递归关键实现方法
     * @param x 出发位置的横坐标
     * @param y 出发位置的纵坐标
     * @param rest 剩余可以走的步数
     * @param a 目标位置的横坐标
     * @param b 目标位置的纵坐标
     * @return
     * 
     *  y+8 |   
     *  y+7 |   
     *  y+6 |   
     *  y+5 |   
     *  y+4 |              (a,b)     (a,b)
     *  y+3 |         (a,b)              (a,b)
     *  y+2 |                   (x,y)
     *  y+1 |         (a,b)              (a,b)
     *  y   |              (a,b)     (a,b)
     *      ---------------------------------------------
     *        x  x+1  x+2  x+3  x+4  x+5  x+6  x+7  x+8
     */
    public static int process(int x, int y, int rest, int a, int b) {
        // 棋盘横坐标长度为10，纵坐标长度为9(如果越界直接返回0即可)
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        // base case
        // 如果剩余0步，检查当前位置和目标位置的横纵坐标的位置是否一致即可
        if (rest == 0) {
            return (x == a && y == b) ? 1 : 0;
        }
        
        int ways = process(x + 2, y + 1, rest - 1, a, b);
        ways += process(x + 2, y - 1, rest - 1, a, b);
        ways += process(x + 1, y - 2, rest - 1, a, b);
        ways += process(x - 1, y - 2, rest - 1, a, b);
        ways += process(x - 2, y - 1, rest - 1, a, b);
        ways += process(x - 2, y + 1, rest - 1, a, b);
        ways += process(x - 1, y + 2, rest - 1, a, b);
        ways += process(x + 1, y + 2, rest - 1, a, b);
        return ways;
    }


    /**
     * 暴力递归转动态规划表
     *    z        x      y
     * int rest, int a, int b 这三个变量
     * 经过分析可以看出：base case会生成第0层的数据
     * 
     * step这里注意可以取到
     * 
     * 剩余层的数据都是在第0层数据出来的基础上产生的
     */
    public static int dp(int x, int y, int step) {
        // x最大不能超过10，y最大不能超过9
        int[][][] dp = new int[10][9][step + 1];
        // base case 初始化rest = 0的时候，即第0层的数据情况
        dp[x][y][0] = 1;
        // 一般情况(将越界情况转移到外面一个辅助方法进行判断即可)
        // 一层一层来
        for (int stepInner = 1; stepInner <= step; stepInner++) {
            // 每层中的x
            for (int i = 0; i < 10; i++) {
                // 每层中的y
                for (int j = 0; j < 9; j++) {
                    dp[i][j][stepInner] = getValue(dp, i + 2, j + 1, stepInner - 1) +
                            getValue(dp, i + 2, j - 1, stepInner - 1) +
                            getValue(dp, i + 1, j - 2, stepInner - 1) +
                            getValue(dp, i - 1, j - 2, stepInner - 1) + 
                            getValue(dp, i - 2, j - 1, stepInner - 1) +
                            getValue(dp, i - 2, j + 1, stepInner - 1) +
                            getValue(dp, i - 1, j + 2, stepInner - 1) +
                            getValue(dp, i + 1, j + 2, stepInner - 1);
                }
            }
        }
        return dp[0][0][step];
    }
    
    /** 辅助方法 */
    public static int getValue(int[][][] dp, int x, int y, int step) {
        // 棋盘横坐标长度为10，纵坐标长度为9(如果越界直接返回0即可)
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return dp[x][y][step];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(dp(x, y, step));

        System.out.println(jump(x, y, step));
    }
}
