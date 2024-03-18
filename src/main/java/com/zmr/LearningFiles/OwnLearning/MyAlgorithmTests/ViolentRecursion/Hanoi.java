package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.ViolentRecursion;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/18 14:10
 * @description 汉诺塔实现--递归
 */
public class Hanoi {
    /** 第一种方法--启发式的写法 */
    public static void hanoi01(int n) {
        // 最终其实就是 左 --> 右 的过程
        leftToRight(n);
    }
    
    /** 把 1~N 层圆盘移动，移动方式 左-->右 */
    public static void leftToRight(int n) {
        // base case
        if (n == 1) {
            System.out.println("Move 1 from left to right;");
            return;
        }
        // (n - 1)个节点 ~~~ 左-->中
        leftToMid(n - 1);
        System.out.println("Move " + n + " from left to right;");
        // (n - 1)个节点 ~~~ 中-->右
        midToRight(n - 1);
    }
    
    /** 把 1~N 层圆盘移动，移动方式 左-->中 */
    public static void leftToMid(int n) {
        // base case
        if (n == 1) {
            System.out.println("Move 1 from left to Middle;");
            return;
        }
        // (n - 1)个节点 ~~~ 左-->右
        leftToRight(n - 1);
        System.out.println("Move " + n + " from left to Middle;");
        // (n - 1)个节点 ~~~ 右-->中
        rightToMid(n - 1);
    }
    
    /** 把 1~N 层圆盘移动，移动方式 中-->左 */
    public static void midToLeft(int n) {
        // base case
        if (n == 1) {
            System.out.println("Move 1 from middle to left;");
            return;
        }
        // (n - 1)个节点 ~~~ 中-->右
        midToRight(n - 1);
        System.out.println("Move " + n + " from middle to left;");
        // (n - 1)个节点 ~~~ 右-->左
        rightToLeft(n - 1);
    }

    /** 把 1~N 层圆盘移动，移动方式 中-->右 */
    public static void midToRight(int n) {
        // base case
        if (n == 1) {
            System.out.println("Move 1 from middle to right;");
            return;
        }
        // (n - 1)个节点 ~~~ 中-->左
        midToLeft(n - 1);
        System.out.println("Move " + n + " from middle to right;");
        // (n - 1)个节点 ~~~ 左-->右
        leftToRight(n - 1);
    }

    /** 把 1~N 层圆盘移动，移动方式 右-->左 */
    public static void rightToLeft(int n) {
        // base case
        if (n == 1) {
            System.out.println("Move 1 from right to left;");
            return;
        }
        // (n - 1)个节点 ~~~ 右-->中
        rightToMid(n - 1);
        System.out.println("Move " + n + " from right to middle;");
        // (n - 1)个节点 ~~~ 中-->左
        midToLeft(n - 1);
    }

    /** 把 1~N 层圆盘移动，移动方式 右-->中 */
    public static void rightToMid(int n) {
        // base case
        if (n == 1) {
            System.out.println("Move 1 from right to middle;");
            return;
        }
        // (n - 1)个节点 ~~~ 右-->左
        rightToLeft(n - 1);
        System.out.println("Move " + n + " from right to middle;");
        // (n - 1)个节点 ~~~ 左-->中
        leftToMid(n - 1);
    }
    
    
    
    
    /** 使用更多的参数进行抽象化 */
    public static void hanoi02(int n) {
        if (n > 0) {
            func(n, "left", "right", "middle");
        }
    }
    
    /** 使用三个参数from, to, other代替原本的left, right, middle */
    public static void func(int N, String from, String to, String other) {
        // base case
        if (N == 1) {
            System.out.println("Move 1 from " + from + " to " + to + ";");
        } else {
            // N - 1 个节点先从from到other上去
            func(N - 1, from, other, to);
            System.out.println("Move " + N + " from " + from + " to " + to + ";");
            // N - 1个节点从other再回到to上去
            func(N - 1, other, to, from);
        }
    }
    

    public static void main(String[] args) {
        hanoi01(3);
        System.out.println("-----------");
        hanoi02(3);
    }
}
