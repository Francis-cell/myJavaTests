package com.zmr.LearningFiles.OwnTests.MyJavaTests.CV;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author franciszmr
 * @Date 2024/4/6 19:44
 * @Version 1.0
 * @Description TODO
 **/
public class Test03 {
    /** 辅助类二叉树 */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public static int[][] threeOrders (TreeNode root) {
        int[][] ans = new int[3][];
        preOrder(root);
        inOrder(root);
        postOrder(root);
        ans[0] = preResult.stream().mapToInt(Integer::intValue).toArray();
        ans[1] = inResult.stream().mapToInt(Integer::intValue).toArray();
        ans[2] = postResult.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }

    private static List<Integer> preResult = new ArrayList<>();
    private static List<Integer> inResult = new ArrayList<>();
    private static List<Integer> postResult = new ArrayList<>();

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        // 根-左-右
        preResult.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        // 左-根-右
        inOrder(root.left);
        inResult.add(root.val);
        inOrder(root.right);
    }

    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        // 左-右-根
        postOrder(root.left);
        postOrder(root.right);
        postResult.add(root.val);
    }

    private static void printArr(int[][] arr) {
        for (int[] arrInner : arr) {
            for (int i : arrInner) {
                System.out.printf(i + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        b.left = a;
        b.right = c;

        int[][] ints = threeOrders(b);

        printArr(ints);
    }
}
