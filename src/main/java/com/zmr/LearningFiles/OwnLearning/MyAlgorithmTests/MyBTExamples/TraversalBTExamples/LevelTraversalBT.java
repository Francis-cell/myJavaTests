package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/10 20:55
 * @description 层序遍历二叉树
 * 1、队列出一个节点，打印
 * 2、节点有左入左，有右入右，先左后右
 */
public class LevelTraversalBT {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node(int val) {
            value = val;
        }
    }
    
    /** 层序遍历 */
    public static void levelTraversalBT(Node root) {
        if (root == null) {
            return;
        }
        
        // 新建一个序列
        Queue<Node> queue = new LinkedList<>();
        // 先将树的根节点放到树中
        queue.add(root);
        
        while (!queue.isEmpty()) {
            // 出队并打印
            Node cur = queue.poll();
            System.out.print(cur.value + ", ");
            
            // 节点如果有左孩子则入左孩子，有右孩子则入右孩子
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        
        root.left.left = new Node(4);
        root.right.right = new Node(7);

        levelTraversalBT(root);
    }
}
