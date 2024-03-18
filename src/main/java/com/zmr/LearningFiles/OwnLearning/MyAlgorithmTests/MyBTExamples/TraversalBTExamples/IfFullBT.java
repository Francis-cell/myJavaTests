package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 20:42
 * @description 判断一棵树是否是满二叉树
 * 满二叉树：假设树的高度为h，则树的节点数量应该为 (2^h - 1) 个节点
 * 
 * 【递归】需要获取的子树信息有
 * 1、左右子树的高度
 * 2、左右子树的节点数量
 */
public class IfFullBT {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node() {
        }
        
        public Node (int val) {
            value = val;
        }
    }

    /** Info类 */
    public static class Info {
        public int height;
        public int nodeNum;
        
        public Info(int h, int n) {
            height = h;
            nodeNum = n;
        }
    }
    
    /** 满二叉树递归方法process */
    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        // 假设可以获取到左右子树的信息
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        // 获取height信息
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 获取nodeNum信息
        int nodeNum = leftInfo.nodeNum + rightInfo.nodeNum + 1;
        return new Info(height, nodeNum);
    }
    
    /** 满二叉树判断主方法 */
    public static boolean ifFullBT(Node head) {
        return process(head).nodeNum == (int)(Math.pow(2, process(head).height)) - 1;
    }

    public static void main(String[] args) {
        //Node head = new Node(1);
        //head.left = new Node(2);
        //head.right = new Node(3);
        //head.left.left = new Node(4);
        //head.left.right = new Node(5);
        //head.right.left = new Node(6);
        //head.right.right = new Node(7);
        //head.left.left.left = new Node(8);
        //head.left.left.right = new Node(9);
        //head.left.right.left = new Node(10);
        //head.left.right.right = new Node(11);
        //head.right.left.left = new Node(12);
        //head.right.left.right = new Node(13);
        //head.right.right.left = new Node(14);
        //head.right.right.right = new Node(15);

        Node head = new Node();

        System.out.println(ifFullBT(head));
    }
}
