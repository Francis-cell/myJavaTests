package MyLeetCodeTests.D12_27.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName OrderTreeTests
 * @Description 遍历树测试
 * @Author zhumengren
 * @Date 2022/12/27 19:14
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class OrderTreeTests {
    ArrayList list = new ArrayList<Integer>();

    /** 辅助类TreeNode */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
        }
    }

    /** 层序遍历树(广度优先) */
    List<Integer> hairOrder(TreeNode root) {
        // 初始化队列，加入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点直接添加到队列中
        queue.add(root);
        // 初始化一个列表，用来存储遍历结果
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 队列出队
            TreeNode node = queue.poll();
            // 保存节点值
            list.add(node.val);
            if (node.left != null) {
                // 左子节点入队
                queue.offer(node.left);
            }
            if (node.right != null) {
                // 右子节点入队
                queue.offer(node.right);
            }
        }
        return list;
    }

    /** 深度优先遍历 */
    /** 1、前序遍历(深度优先) */
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问顺序：根节点->左子结点->右子节点
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /** 2、中序遍历(深度优先) */
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问顺序：左子结点->根节点->右子节点
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /** 3、后序遍历(深度优先) */
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问顺序：左子结点->右子节点->根节点
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }

    /** 主测试方法 */
    public static void main(String[] args) {

    }
}
