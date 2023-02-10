package main.java.com.zmr.MyLeetCodeTests.My2022Lists.D11_20.Solution01;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/20 12:09
 */
public class Solution {
    // 存储中序遍历结果的ArrayList结构
    private static List tempArr = new ArrayList<Integer>();

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

    public static void dealMethod(List<Integer> tempArr, TreeNode root) {
        // 如果根节点的值为null，则直接返回
        if (root == null) {
            return;
        }
        // 先访问左子树
        dealMethod(tempArr, root.left);
        // 再访问根节点
        tempArr.add(root.val);
        // 再访问右子树
        dealMethod(tempArr, root.right);
    }



    /** 为啥1-null-null的时候，会连续保存两次1，没想明白！！！ */
    /** 为啥节点5回不去？？？ */
    public static void dealMethod01(TreeNode root) {
        // 如果根节点的左子树不为空，则将当前根节点转换成根节点的左子结点
        if (root.left != null) {
            root = root.left;
            // 递归调用当前方法
            dealMethod01(root);
        }
        // 添加当前节点的值
        tempArr.add(root.val);
        // 如果根节点的右子树不为空，则将当前根节点转换成根节点的右子结点
        if (root.right != null) {
            root = root.right;
            // 递归调用当前方法
            dealMethod01(root);
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal (TreeNode root) {
        dealMethod(tempArr, root);
        //dealMethod01(root);
        // 存储最终返回的int[]数组
        int[] lastInt = new int[tempArr.size()];
        // 将ArrayList转换成int类型的数组
        for (int i = 0; i < tempArr.size(); i++) {
            lastInt[i] = (int) tempArr.get(i);
        }
        return lastInt;
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
