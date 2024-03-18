package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2022Lists.D11_20.Solution02;

import java.util.*;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/20 13:36
 */
public class Solution {
    /** 自定义TreeNode类 */
    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public int[] inorderTraversal (TreeNode root) {
        // 存放遍历结果的列表
        List<Integer> lastList = new ArrayList<>();
        // 临时使用的栈结构
        Stack<TreeNode> tempStack = new Stack<>();
        // 如果是空树，则直接返回空数组
        if (root == null) {
            return new int[0];
        }
        // 当树节点不为空，或者栈中有节点时
        while (root != null || !tempStack.isEmpty()) {
            // 首先找到最左侧节点--确保了左子树节点都已经放到最终列表中了
            while (root != null) {
                tempStack.push(root);
                root = root.left;
            }
            // 已经抵达最左侧节点，开始出栈
            TreeNode tempNode = tempStack.pop();
            // 将刚出栈的值放到最终的遍历结果的列表中
            lastList.add(tempNode.val);
            // 切换到刚刚出栈节点的右子树节点
            root = tempNode.right;
        }
        // 返回结果
        int[] lastResult = new int[lastList.size()];
        for (int i = 0; i < lastList.size(); i++) {
            lastResult[i] = lastList.get(i);
        }
        return lastResult;
    }

    public static void main(String[] args) {
        TreeNode firstNode = new TreeNode(1);
        TreeNode secondNode = new TreeNode(2);
        TreeNode thirdNode = new TreeNode(3);
        TreeNode fourthNode = new TreeNode(4);
        TreeNode fifthNode = new TreeNode(5);
        TreeNode sixthNode = new TreeNode(6);
        TreeNode seventhNode = new TreeNode(7);
        TreeNode eighthNode = new TreeNode(8);

        // 连接树节点
        fifthNode.left = thirdNode;
        fifthNode.right = seventhNode;
        thirdNode.left = secondNode;
        thirdNode.right = fourthNode;
        secondNode.left = firstNode;
        secondNode.right = null;
        firstNode.left = null;
        firstNode.right = null;
        fourthNode.left = null;
        fourthNode.right = null;
        seventhNode.left = sixthNode;
        seventhNode.right = eighthNode;
        sixthNode.left = null;
        sixthNode.right = null;
        eighthNode.left = null;
        eighthNode.right = null;

        Solution sol = new Solution();
        int[] val = sol.inorderTraversal(fifthNode);
        for (int i = 0; i < val.length; i++) {
            System.out.println(val[i]);
        }
    }
}
