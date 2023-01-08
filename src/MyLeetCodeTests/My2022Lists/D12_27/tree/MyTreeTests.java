package MyLeetCodeTests.My2022Lists.D12_27.tree;

/**
 * @ClassName MyTreeTests
 * @Description Java Tree使用
 * @Author zhumengren
 * @Date 2022/12/27 18:50
 * @Version 1.0
 **/
public class MyTreeTests {
    /** 辅助类 */
    static class TreeNode {
        int val;
        // 左子结点
        TreeNode left;
        // 右子节点
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        // 构建指向
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        // 插入一个新节点
        TreeNode n6 = new TreeNode(6);
        // 在n1和n2之间插入一个新节点
        n1.left = n6;
        n6.left = n2;

        // 删除刚刚插入的n6节点
        n1.left = n2;
    }
}
