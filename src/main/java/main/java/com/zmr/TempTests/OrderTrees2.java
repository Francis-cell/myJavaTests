package main.java.com.zmr.TempTests;

import java.util.ArrayList;

/**
 * @ClassName OrderTrees
 * @Description 自定义二叉树
 * @Author zhumengren
 * @Date 2023/2/9 13:11
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class OrderTrees2<T> {
    ArrayList list = new ArrayList<Integer>();

    /** 声明辅助类 */
    static class TreeNode<T> {
        T val;
        TreeNode left;
        TreeNode right;

        TreeNode (T val) {
            this.val = val;
        }
    }

    /** 中序遍历 */
    void inOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }

    /** 插入数据 */
    TreeNode insertVal (TreeNode root, T tempVal) {
        // 当传入的根节点为空,则将传入的值设置为节点
        if (root == null) {
            return new TreeNode(tempVal);
        }

        // 大于根节点的值，向右子树插入数据
        // TODO--规则制定
        // 临时遍历a、b
        int a = 1;
        int b = 2;
        if (a > b) {
            root.right = insertVal(root.right, tempVal);
        } else {
            root.left = insertVal(root.left, tempVal);
        }

        return root;
    }

    public static void main(String[] args) {
        // 1、插入数据
        // 2、中序遍历
    }
}
