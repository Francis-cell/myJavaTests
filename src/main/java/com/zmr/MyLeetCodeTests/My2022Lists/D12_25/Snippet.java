package main.java.com.zmr.MyLeetCodeTests.My2022Lists.D12_25;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Snippet {

    //public static void main(String[] args) {
    //    Scanner in = new Scanner(System.in);
    //    int num = in.nextInt();
    //    int[] nums = new int[num];
    //    for (int i = 0; i < num; i++) {
    //        nums[i] = in.nextInt();
    //    }
    //    // 使用处理方法
    //    Main main = new Main();
    //    main.solution(nums);
    //}

    void solution(int[] nums) {
        // 将nums插入到二叉树中，后面中序遍历；将会自动去重和排序
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insert(nums[i], root);
        }
        inOrder(root);
    }

    /** TreeNode辅助类 */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode (int val) {
            this.val = val;
        }
    }

    /** TreeNode插入节点 */
    TreeNode insert(int val, TreeNode root) {
        if (root == null) {
            return null;
        }
        // 声明当前节点为root，父节点为pre
        TreeNode cur = root, pre = null;
        // 循环查找，越过叶子节点之后跳出
        while(cur != null) {
            // 找到节点在树中已经存在，则直接返回
            if (cur.val == val) {
                return null;
            }
            // 存储当前节点为父节点
            pre = cur;
            // 插入位置在root的左子树
            if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        // 2、插入节点操作
        TreeNode node = new TreeNode(val);
        if (pre.val < val) {
            // 插入到右子树
            pre.right = node;
        } else {
            // 插入到左子树
            pre.left = node;
        }
        return node;
    }

    /**二叉树的中序遍历 */
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问顺序: 左子结点->根节点->右子节点
        inOrder(root.left);
        // strs.append(root.val);
        // strs.append(" ");
        System.out.println(root.val);
        inOrder(root.right);
    }
}