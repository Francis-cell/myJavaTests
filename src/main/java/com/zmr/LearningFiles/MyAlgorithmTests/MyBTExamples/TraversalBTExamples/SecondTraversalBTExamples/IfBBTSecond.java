package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.TraversalBTExamples.SecondTraversalBTExamples;

/**
 * @ClassName IfBST
 * @Description 判断一棵二叉树是否是平衡二叉树
 * 1、左子树为平衡二叉树
 * 2、右子树为平衡二叉树
 * 3、abs(左子树height - 右子树height) <= 1
 **/
public class IfBBTSecond {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node() {};
        public Node(int value) {
            this.value = value;
        }
    }
    
    /** main */
    public static boolean isBalancedBT (Node head) {
        return process(head).isBalanced;
    }
    
    /** Info类 */
    public static class Info {
        public int height;
        public boolean isBalanced;
        
        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    /** process方法 */
    public static Info process (Node x) {
        if (x == null) {
            return new Info(0, true);
        }
        
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = true;
        if (!leftInfo.isBalanced) {
            isBalanced = false;
        }
        if (!rightInfo.isBalanced) {
            isBalanced = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }
        
        return new Info(height, isBalanced);
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        //head.right.left = new Node(6);
        //head.right.right = new Node(7);
        head.left.left.left = new Node(8);
        head.left.left.right = new Node(9);
        //head.left.right.left = new Node(10);
        //head.left.right.right = new Node(11);

        System.out.println(isBalancedBT(head));
    }
}
