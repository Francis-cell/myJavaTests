package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.SerializeExamples;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/10 22:34
 * @description 将 N叉树 序列化为 二叉树，并且能够从 二叉树 反序列化为 N叉树
 * 说明
 */
public class EncodeNaryTreeToBinaryTree {
    /** 辅助类N叉树 */
    public static class Node {
        public int val;
        public List<Node> children;
        
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
        
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    /** 辅助类二叉树 */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
    /** 可以提交代码的类 */
    class Codec {
        /** 序列化-编码 */
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            // 多叉树的根节点，必然也是序列化后  二叉树的根节点
            TreeNode head = new TreeNode(root.val);
            head.left = en(root.children);
            return head;
        }
        
        /** 序列化-辅助方法(将N叉树的所有孩子节点都放到节点左孩子的右边界上) */
        private TreeNode en(List<Node> children) {
            // 要形成的子树，本身是没有第一个节点的，这里的head是第一个节点，初始化为null
            TreeNode head = null;
            // 当前节点
            TreeNode cur = null;
            for (Node child : children) {
                // 依次获取N叉树孩子列表中的每个值【后面同样要进行递归处理】
                TreeNode tNode = new TreeNode(child.val);
                
                // 将N叉树当前的节点转换成二叉树的节点
                // 1、只有某个节点的第一个孩子节点才会使用，因为那时候节点都没形成树结构
                if (head == null) {
                    head = tNode;
                } 
                // 2、否则则说明节点不是第一个孩子节点，所以直接连接到之前已经有的节点的右子树即可
                else {
                    cur.right = tNode;   
                }
                // 设置当前二叉树到达的节点
                cur = tNode;
                
                // TODO--递归使用
                // 递归当前抵达的节点的孩子节点(注意cur是二叉树节点，child才是N叉树节点)
                cur.left = en(child.children);
            }
            return head;
        }
        
        /** 反序列化-(将N叉树序列化出来的二叉树，反序列化为二叉树结构) */
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return new Node(root.val, de(root.left));
        }

        /** 反序列化-辅助方法(将N叉树序列化出来的二叉树的子节点，转换成为原本的子节点list形式) */
        private List<Node> de(TreeNode root) {
            List<Node> children = new ArrayList<>();
            while (root != null) {
                // 【递归】(递归处理当前节点的所有的孩子节点，因为节点的"左孩子"的右边界对应的是原本N叉树节点的孩子节点列表)
                // 获取二叉树中当前的节点
                Node cur = new Node(root.val, de(root.left));
                // 往上回溯,将当前节点(N叉树结构)添加回到children列表中
                children.add(cur);
                // 到当前节点在二叉树的右节点(对应的是N叉树中的兄弟节点)
                root = root.right;
            }
            return children;
        }
    }
}
