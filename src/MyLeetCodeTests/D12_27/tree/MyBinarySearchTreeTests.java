package MyLeetCodeTests.D12_27.tree;

/**
 * @ClassName MyBinarySearchTreeTests
 * @Description 二叉搜索树使用
 * @Author zhumengren
 * @Date 2022/12/27 19:46
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyBinarySearchTreeTests {
    /** 辅助TreeNode类 */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /** 二叉搜索树搜索 */
    TreeNode search(int num, TreeNode root) {
        // 当前搜索时搜索到的树节点位置(默认是从根节点开始的)
        TreeNode cur = root;
        // 循环查找，找到在查找的节点之后直接跳出
        while (cur != null) {
            // 目标节点在root的左子树
            if (cur.val > num) {
                cur = cur.left;
            }
            // 目标节点在root的右子树
            else if (cur.val < num) {
                cur = cur.right;
            }
            // 找到目标节点，返回
            else {
                break;
            }
        }
        // 返回目标节点(如果没有查找到，那么cur将会是一个null值；如果查找到之后将会返回对应的节点)
        return cur;
    }

    /** 插入节点 */
    TreeNode insert(int num, TreeNode root) {
        // 如果树为空，则直接返回
        if (root == null) {
            return null;
        }
        // 声明当前目标节点位置为root，父节点为null
        TreeNode cur = root, pre = null;
        // 1、循环查找，越过叶子节点后跳出
        while (cur != null) {
            // 找到节点在树中已经存在，则直接返回
            if (cur.val == num) {
                return null;
            }
            // 存储当前节点为父节点
            pre = cur;
            // 插入位置在root的左子树
            if (cur.val > num) {
                cur = cur.left;
            }
            // 插入位置在root的右子树
            else {
                cur = cur.right;
            }
        }

        // 2、插入节点操作
        TreeNode node = new TreeNode(num);
        if (pre.val < num) {
            // 插入数据到右子树
            pre.right = node;
        } else {
            // 插入数据到左子树
            pre.left = node;
        }
        return node;
    }
}
