package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.DynamicProgramming;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/23 20:39
 * @description 0-1背包问题
 */
public class Bag_0_1 {
    /**
     * 暴力递归方式 (注意：背包中物品的w和v的值均可为0，但是不可为负值)
     * @param w 表示货物重量的数组
     * @param v 表示货物价值的数组
     * @param bag 表示提供的背包的容量，weight不能超过这个值
     * @return 不超重的情况下，能够得到的最大值
     */
    public static int maxValue(int[] w, int[] v, int bag) {
        // 边界条件处理
        if (w == null || v == null || w.length != v.length ||
        w.length == 0) {
            return 0;
        }
        return process(w, v, 0, bag);
    }

    /**
     * 暴力递归使用的递归方法
     * @param w 表示货物重量的数组 不变
     * @param v 表示货物价值的数组 不变
     * @param index 当前index位置之后的货物是可以被选择的
     * @param rest bag中剩余可以被装入物品的重量的值
     * @return 从index位置到后面背包中可以装入的物品最大的价值
     */
    public static int process(int[] w, int[] v, int index, int rest) {
        // base case
        // 如果背包剩余可以装入的weight的值<0（因为可能存在w == 0的货物）
        if (rest < 0) {
            return -1;
        }
        // 如果当前index越界了，那么返回0
        if (index == w.length) {
            return 0;
        }
        
        
        // 1、不选当前货物的情况下
        int p1 = process(w, v, index + 1, rest);
        // 2、选中当前货物的情况下
        int p2 = 0;
        int next = process(w, v, index + 1, rest - w[index]);
        // 说明上一个货物是有效的，才会将index位置的货物视作有效货物加入
        if (next != -1) {
            p2 = v[index] + next;
        }
        
        return Math.max(p1, p2);
    }

    /***
     * 直接使用动态规划表方式--省去中间的傻缓存方式
     * 
     * 通过分析暴力递归中的p1和p2的计算方式可以得出结论：
     * dp表中当前行的结果依赖于下一个行的结果
     * 
     * @param w 
     * @param v
     * @param bag
     * @return
     */
    public static int dpMethod(int[] w, int[] v, int bag) {
        // 边界条件处理
        if (w == null || v == null || w.length != v.length ||
                w.length == 0) {
            return 0;
        }
        
        int N = w.length;
        // 暴力递归方式中，index和rest是递归中主要的影响变量
        // index范围：[0~N)
        // rest范围： (负数~bag]，但是负数可以被程序过滤掉
        int[][] dp = new int[N + 1][bag+1];
        
        // 初始化base case
        // 1、最后一行，index == N，值为0，Java中不需要管
        // 2、小于第一列, rest < 0,值为-1，后面代码处理
        
        // 从倒数第二行向上
        for (int index = N - 1; index >= 0; index--) {
            // 从第一列向右
            for (int rest = 0; rest <= bag; rest++) {
                // 1、不选当前货物的情况下
                int p1 = dp[index + 1][rest];
                // 2、选中当前货物的情况下
                int p2 = 0;
                // TODO--在这里处理-1的情况
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                // 说明上一个货物是有效的，才会将index位置的货物视作有效货物加入
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }



    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7, 3, 1, 7 };
        int[] values = { 5, 6, 3, 19, 12, 4, 2 };
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dpMethod(weights, values, bag));
    }
    
}
