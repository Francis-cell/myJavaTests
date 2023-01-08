package MyLeetCodeTests.My2022Lists.D12_27.tree;

/**
 * @ClassName MyBinarySearchTreeTests
 * @Description 二叉搜索树使用
 * @Author zhumengren
 * @Date 2022/12/27 19:46
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

    /** 删除节点 */
    TreeNode remove(int num, TreeNode root) {
        // 如果树为空，则直接返回
        if (root == null) {
            return null;
        }
        // 1、查看有没有要删除的节点
        // cur为当前节点的位置; pre为当前cur节点的父节点
        TreeNode cur = root, pre = null;
        while (cur != null) {
            // 找到了需要删除的节点，跳出循环
            if (cur.val == num) {
                break;
            }
            // 将cur的位置交给父节点pre
            pre = cur;
            // 待删除的节点在root的左子树
            if (num < cur.val) {
                cur = cur.left;
            }
            // 待删除的节点在root的右子树
            else {
                cur = cur.right;
            }
        }

        // 没有待删除节点，则直接返回
        if (cur == null) {
            return null;
        }
        // 2、根据要删除节点的子节点的情况决定处理逻辑
        // ①、要删除的节点没有子节点-->直接删除要删除的节点
        // ②、要删除的节点有一个子节点-->删除要删除的节点；将删除的节点替换为它的子节点
        // 情况①和情况②可以一块儿处理
        if (cur.left == null || cur.right == null) {
            // 当子节点数量等于0 or 1时，child = null or 该子节点
            TreeNode child = cur.left == null ? cur.right : cur.left;
            // 删除节点cur(需要判断cur是其父节点pre的左子结点 还是右子节点)
            if (pre.left == cur) {
                pre.left = child;
            } else {
                pre.right = child;
            }
        }

        // ③、要删除的节点有两个子节点-->
        //                           * 找到待删除的节点，当为中序遍历时它的下一个节点，记作nex
        //                           * 在树中递归删除节点nex
        //                           * 使用nex的值替换原本要删除的节点的值
        else {
            // 获取中序遍历中cur的下一个节点
            TreeNode nex = min(cur.right);
            int next = nex.val;
            // 递归删除nex
            remove(next, cur);
            // 将nex的值赋值给cur
            cur.val = next;
        }

        // 最终返回删除的节点
        return cur;
    }

    /** 获取最小节点 */
    TreeNode min(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 循环访问左子结点，直到叶节点为最小节点时跳出
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
