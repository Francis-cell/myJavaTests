package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/12 16:24
 * @description 给定一个二叉树头节点，返回这棵二叉树中最大的的二叉搜索树的头节点
 * 【寻找最大的二叉搜索树】
 * 1、最大的搜索二叉树头节点
 * 
 * 【二叉搜索树条件】
 * 1、左子树max < x值 < 右子树min
 */
public class FindMaxSizeBSTHead {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node() {};
        public Node(int val) {
            value = val;
        }
    }
    
    /** Info */
    public static class Info {
        public Node maxBSTHead;
        public int maxBSTSize;
        public int max;
        public int min;
        public int size;
        
        public Info(Node maxBSTHead, int maxBSTSize, int max, int min, int size) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    
    /** 主方法 */
    public static Node getMaxSizeBSTHead(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).maxBSTHead;
    }
    
    public static Info process(Node x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        
        int max = x.value;
        int min = x.value;
        int size = 1;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            size += leftInfo.size;
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            size += rightInfo.size;
        }
        
        int maxBSTSize;
        Node maxBSTHead;
        
        // 1、左树上的最大搜索二叉树
        int p1 = -1;
        Node maxBSTHead1 = null;
        if (leftInfo != null) {
            p1 = leftInfo.maxBSTSize;
            maxBSTHead1 = leftInfo.maxBSTHead;
        }
        
        // 2、右树上的最大搜索二叉树
        int p2 = -1;
        Node maxBSTHead2 = null;
        if (rightInfo != null) {
            p2 = rightInfo.maxBSTSize;
            maxBSTHead2 = rightInfo.maxBSTHead;
        }
        
        // 3、包含x节点的情况下的最大的搜索二叉树
        // 这种情况下，左子树和右子树都必须是搜索二叉树，且左子树max < 当前值 < 右子树min
        int p3 = -1;
        Node maxBSTHead3 = null;
        boolean isLeftBST = leftInfo == null ? true : leftInfo.maxBSTSize == leftInfo.size;
        boolean isRightBST = rightInfo == null ? true : rightInfo.maxBSTSize == rightInfo.size;
        if (isLeftBST && isRightBST) {
            // 左子树最大值 < 当前值
            boolean isLeftLessThanX = leftInfo == null ? true : leftInfo.max < x.value; 
            // 当前值 < 右子树min
            boolean isRightMoreThanX = rightInfo == null ? true : rightInfo.min > x.value;
            
            if (isLeftLessThanX && isRightMoreThanX) {
                // 获取左子树和右子树的size大小
                int leftSize = leftInfo == null ? 0 : leftInfo.size;
                int rightSize = rightInfo == null ? 0 : rightInfo.size;
                p3 = leftSize + rightSize + 1;
                maxBSTHead3 = x;
            }
        }
        
        maxBSTSize = Math.max(Math.max(p1, p2), p3);
        maxBSTHead = maxBSTSize == p1 ? maxBSTHead1 : maxBSTSize == p2 ? maxBSTHead2 : maxBSTHead3;
        return new Info(maxBSTHead, maxBSTSize, max, min, size);
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(5);
        head.left.left = new Node(2);
        head.left.left.left = new Node(1);
        head.left.left.right = new Node(3);
        
        head.right = new Node(8);
        head.right.left = new Node(7);
        head.right.right = new Node(9);

        System.out.println(getMaxSizeBSTHead(head).value);
    }
}
