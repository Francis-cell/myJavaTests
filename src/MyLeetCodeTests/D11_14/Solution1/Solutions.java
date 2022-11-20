package MyLeetCodeTests.D11_14.Solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solutions
 * @Description 二叉树的中序遍历
 * @Author zhumengren
 * @Date 2022/11/14 9:03
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class Solutions {
    /** 声明TreeNode实体类 */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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


    /** 声明一个双向链表-存储树结构 */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    /** 定义中序遍历的方法 */
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        // 递归左子树
        inorder(root.left, res);
        // 拼接根节点
        res.add(root.val);
        // 递归右子树
        inorder(root.right, res);
    }


    /** 方法调用 */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        TreeNode root = treeNode1;
        Solutions solutions = new Solutions();
        List<Integer> integers = solutions.inorderTraversal(root);
        System.out.println(integers);
    }

}
