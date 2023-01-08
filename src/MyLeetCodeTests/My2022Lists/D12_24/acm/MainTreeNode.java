package MyLeetCodeTests.My2022Lists.D12_24.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 二叉树的输入
 * @date 2022/12/24 11:20
 */
public class MainTreeNode {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = reader.readLine().split(" ");

        // 使用数组按照层级存储二叉树的节点
        TreeNode[] tree = new TreeNode[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int tempInt = Integer.parseInt(strs[i]);
            if (tempInt == -1) {
                // -1代表null
                tree[i] = null;
            } else {
                tree[i] = new TreeNode(tempInt);
            }
        }
        
        // 将Tree数组转换成二叉树的形式进行存储
        // 根据”左孩子 = 节点下标 * 2 + 1“; ”右孩子 = 节点下标 * 2 + 2“的原则将数组转换成二叉树
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                tree[i].left = tree[2 * i + 1];
                tree[i].right = tree[2 * i + 2];
            }
        }

        // 返回树
        TreeNode root = tree[0];
        // 输入案例：0 1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1 -1
        System.out.println(root.toString());
    }

    /** 二叉树的辅助类 */
    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode (int val) {
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
}
