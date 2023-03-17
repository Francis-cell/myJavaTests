package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.TraversalBTExamples.SecondTraversalBTExamples;

/**
 * @ClassName IfBSTSecond
 * @Description 判断一棵二叉树是否是搜索二叉树
 * 1、左子树是搜索二叉树
 * 2、右子树是搜索二叉树
 * 3、左子树max < 当前节点的值 < 右子树min
 **/
public class IfBSTSecond {
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
    
    /** main方法 */
    public static boolean ifBST (Node head) {
        if (head == null) {
            return true;
        }
        
        return process(head).isBST;
    }
    
    /** Info类 */
    public static class Info {
        public boolean isBST;
        public int max;
        public int min;
        
        public Info (boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
    
    /** process方法 */
    public static Info process (Node x) {
        if (x == null) {
            return null;
        }
        
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        
        int max = x.value;
        int min = x.value;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }

        boolean isBST = true;
        // 1、如果左子树不是搜索二叉树，那么isBST = false
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        // 2、如果右子树不是搜索二叉很俗，那么isBST = false
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        // 3、如果左子树的max >= x.value，那么isBST = false
        if (leftInfo != null && leftInfo.max >= x.value) {
            isBST = false;
        }
        // 4、如果右子树的min <= x.value，那么isBST = false
        if (rightInfo != null && rightInfo.min <= x.value) {
            isBST = false;
        }
        
        return new Info(isBST, max, min);
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

        System.out.println(ifBST(head));
    }
}
