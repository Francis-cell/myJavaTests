package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 18:07
 * @description 判断一棵二叉树是否是搜索二叉树【递归】
 * 说明：经典的搜索树，是没有相同的节点的，如果有，使用链表形式挂到同一个节点上
 * 1、左树为搜索树
 * 2、右树为搜索树
 * 3、左树最大值 < 当前节点值
 * 4、右树最小值 > 当前节点值
 */ 
public class isBST {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node (int val) {
            this.value = val;
        }
    }
    
    /** 递归辅助类 */
    public static class Info {
        public boolean isSearchBT;
        public int maxValue;
        public int minValue;
        
        public Info (boolean isSearchBT, int maxValue, int minValue) {
            this.isSearchBT = isSearchBT;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
    
    public static boolean isSearchBT(Node head) {
        // 单独处理空情况
        if (head == null) {
            return true;
        }
        return process(head).isSearchBT;
    }
    
    /** 递归方法 */
    public static Info process(Node x) {
        // 上游在处理节点为空的时候，不知道怎么处理，直接返回null
        if (x == null) {
            return null;
        }
        // 假设已经拿到了左树和右树的信息
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        
        // 获取最大值
        int maxValue = x.value;
        if(leftInfo != null && leftInfo.maxValue > x.value) {
            maxValue = leftInfo.maxValue;
        }
        if (rightInfo != null && rightInfo.maxValue > x.value) {
            maxValue = rightInfo.maxValue;
        }
        // 获取最小值
        int minValue = x.value;
        if (leftInfo != null && leftInfo.minValue < x.value) {
            minValue = leftInfo.minValue;
        }
        if (rightInfo != null && rightInfo.minValue < x.value) {
            minValue = rightInfo.minValue;
        }
        
        // 获取是否是搜索树
        boolean isSearchBT = true;
        // 1、如果左子树不是搜索树; 那么当前树就不是搜索树
        if (leftInfo != null && !leftInfo.isSearchBT) {
            isSearchBT = false;
        }
        // 2、如果右子树不是搜索树; 那么当前树就不是搜索树
        if (rightInfo != null && !rightInfo.isSearchBT) {
            isSearchBT = false;
        }
        // 3、左树max值 < x值 < 右树min值
        if (leftInfo != null && leftInfo.maxValue >= x.value) {
            isSearchBT = false;
        }
        if (rightInfo != null && rightInfo.minValue <= x.value) {
            isSearchBT = false;
        }
        
        return new Info(isSearchBT, maxValue, minValue);
    }
}
