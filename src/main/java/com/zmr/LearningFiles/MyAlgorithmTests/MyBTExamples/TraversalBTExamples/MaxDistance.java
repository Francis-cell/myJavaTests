package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 18:47
 * @description 返回二叉树中两个节点之间的最大距离
 * 说明：1、不能走回头路；2、A-B-C，则A~C的距离为3，记录的是节点的数量
 * 
 * 解法：【递归】[非递归方式十分困难]
 * 一、不经过x的最大距离
 * 1、左树的最大距离
 * 2、右树的最大距离
 * 
 * 二、经过x的最大距离
 * 3、左树的高度 + 右树的高度 + 1 （这里的1表示当前的x节点）
 */
public class MaxDistance {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node (int value) {
            this.value = value;
        }
    }
    
    /** Info类 */
    public static class Info {
        public int maxDistance;
        public int height;
        
        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
    
    /** process方法【递归主方法】 */
    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        // 假设能拿到左右孩子节点的情况
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        
        // height就是左右子树height的最大值 + 1
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        
        // maxDistance的值
        // 1、左树的最大距离
        int leftDistance = leftInfo.maxDistance;
        // 2、右树的最大距离
        int rightDistance = rightInfo.maxDistance;
        // 3、左树高度 + 右树的高度 + 1
        int throughXDistance = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(Math.max(leftDistance, rightDistance), throughXDistance);
        return new Info(maxDistance, height);
    }
    
    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }
}
