package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

/**
 * @ClassName RecursiveTraversalBT
 * @Description 递归遍历二叉树
 **/
public class RecursiveTraversalBT {
    /** 辅助类Node */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node(int val) {
            value = val;
        }
    }
    
    /** 主要方法 */
    public static void traverseBT(Node head) {
        if (head == null) {
            return;
        }
        // 先序遍历
        //System.out.print(head.value);
        traverseBT(head.left);
        // 中序遍历
        //System.out.println(head.value);
        traverseBT(head.right);
        // 后序遍历
        //System.out.println(head.value);
    }
}
