package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 21:05
 * @description 在一棵二叉树中找到节点数量最多的搜索二叉树并返回它的节点数量
 * 
 * 一、当前节点不参与
 * 1、左子树中寻找节点最多的搜索二叉树
 * 2、右子树中寻找节点最多的搜索二叉树
 * 
 * 二、当前节点参与
 * 1、左子树是搜索二叉树
 * 2、右子树是搜索二叉树
 * 3、左子树max < 当前节点的值
 * 4、右子树min > 当前节点的值
 * 5、左子树size + 右子树size + 1 = 最终求解的节点数量
 */
public class FindMaxSizeBSTInBT {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node() {}
        
        public Node (int value) {
            this.value = value;
        }
    }
    
    /** 
     * Info类 
     * 
     * 其中可以简化掉一个信息isBST
     * 当maxBSTSize == size的时候，则isBST = true，反之isBST = false
     */
    public static class Info {
        public int maxBSTSize;
        //public boolean isBST;
        public int max;
        public int min;
        public int size;
        
        public Info(int m, int ma, int mi, int s) {
            maxBSTSize = m;
            //isBST = i;
            max = ma;
            min = mi;
            size = s;
        }
    }
    
    /** 递归程序process方法 */
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
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
            size += leftInfo.size;
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
            size += rightInfo.size;
        }
        
        // TODO--核心
        // maxBSTSize获取
        int maxBSTSize = 0;
        // 一、如果当前节点不参与
        // 左子树中最大的搜索二叉树子树
        int p1 = -1;
        if (leftInfo != null) {
            p1 = leftInfo.maxBSTSize;
        }
        // 右子树中最大的搜索二叉树子树
        int p2 = -1;
        if (rightInfo != null) {
            p2 = rightInfo.maxBSTSize;
        }
        
        // 二、如果当前节点参与
        // 左子树一定需要是搜素二叉树，右子树也一定要是搜索二叉树
        int p3 = -1;
        // 左子树是否是搜索二叉树
        boolean leftBST = leftInfo == null ? true : (leftInfo.maxBSTSize == leftInfo.size); 
        // 右子树是否是搜索二叉树
        boolean rightBST = rightInfo == null ? true : (rightInfo.maxBSTSize == rightInfo.size);
        // 只有当左右子树都是搜索二叉树的情况下，才能进来修改p3的值
        if(leftBST && rightBST) {
            // 还要查看 (左子树的最大值 < x.value) 以及 (右子树的最小值 > x.value)
            boolean leftMaxLessThanX = leftInfo == null ? true : (leftInfo.max < x.value);
            boolean rightMinMoreThanX = rightInfo == null ? true : (rightInfo.min > x.value);
            
            if (leftMaxLessThanX && rightMinMoreThanX) {
                int leftSize = leftInfo == null ? 0 : leftInfo.size;
                int rightSize = rightInfo == null ? 0 : rightInfo.size;
                p3 = leftSize + rightSize + 1;
            }
        }

        // System.out.println(p1 + ", " + p2 + ", " + p3);
        // 最后求取p1、p2、p3的最大值
        maxBSTSize = Math.max(Math.max(p1, p2), p3);
        
        return new Info(maxBSTSize, max, min, size);
    }
    
    /** main程序 */
    public static int findMaxSizeBSTInBT(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxBSTSize;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(5);
        head.left.left = new Node(2);
        head.left.left.left = new Node(1);
        head.left.left.right = new Node(3);
        
        head.right = new Node(8);
        head.right.left = new Node(7);
        head.right.right = new Node(9);

        System.out.println(findMaxSizeBSTInBT(head));
    }
}
