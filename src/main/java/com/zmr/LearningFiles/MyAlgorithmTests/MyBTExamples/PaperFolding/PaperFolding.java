package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.PaperFolding;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 16:12
 * @description 折纸条问题
 */
public class PaperFolding {
    /** 打印所有节点的方法 */
    public static void printAllFolds(int N) {
        process(1, N, true);
        System.out.println();
    }
    
    /** 
     * process程序
     * 1、这个节点在第i层，一共有N层，N是固定不变的
     * 2、如果这个节点是“凹”的，down = T
     * 3、如果这个节点是“凸”的，down = F
     * 4、方法的功能：中序打印以你想象的节点为头的整棵树
     */
    public static void process(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        // 打印左子树
        process(i + 1, N, true);
        System.out.print(down ? "凹 " : "凸 ");
        // 打印右子树
        process(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);
    }
}
