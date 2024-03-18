package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.printBT;


/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 11:26
 * @description 打印一棵二叉树(横向打印)
 */
public class PrintBinaryTree {
    /** 辅助类Node */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node(int val) {
            value = val;
        }
    }
    
    /** 打印二叉树主方法 */
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }
    
    /** 中序打印二叉树 */
    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        // 递归打印右子树
        printInOrder(head.right, height + 1, "v", len);
        // 拼接要打印在控制台的字符串
        String val = to + head.value + to;
        // 每个字符串实际上由三部分组成：①、左侧空白；②、val值；③、右侧空白；
        // val值
        int lenM = val.length();
        // 左侧空白长度
        int lenL = (len - lenM) / 2;
        // 右侧空白长度
        int lenR = len - lenM - lenL;
        
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        
        // 递归打印左子树
        printInOrder(head.left, height + 1, "^", len);
    }
    
    /** 生成指定数量的空格字符串，用来拼接回原本的字符串 */
    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
    
    
    /** main方法测试 */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(-222222222);
        head.right = new Node(3);
        head.left.left = new Node(Integer.MIN_VALUE);
        head.right.left = new Node(55555555);
        head.right.right = new Node(66);
        head.left.left.right = new Node(777);
        printTree(head);

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        printTree(head);

        head = new Node(1);
        head.left = new Node(1);
        head.right = new Node(1);
        head.left.left = new Node(1);
        head.right.left = new Node(1);
        head.right.right = new Node(1);
        head.left.left.right = new Node(1);
        printTree(head);
    }
}
