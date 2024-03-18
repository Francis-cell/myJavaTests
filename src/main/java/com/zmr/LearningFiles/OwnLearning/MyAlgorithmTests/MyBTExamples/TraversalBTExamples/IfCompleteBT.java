package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 16:55
 * @description 判断一棵树是否是完全二叉树
 * 
 * 1、如果某个节点有右孩子，但是没有左孩子，直接结束
 * 2、如果某个节点孩子不双全，那么接下来遍历的所有节点都没有孩子
 */
public class IfCompleteBT {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node (int val) {
            value = val;
        }
    }
    
    /** 
     * 层序遍历一棵树 -- 自己的写法
     */
    public static boolean IfCompleteBT(Node head) {
        if (head == null || head.left == null && head.right == null) {
            return true;
        }
        // 开始层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        
        // 设置一个标志位
        boolean beginFlag = false;
        
        while (!queue.isEmpty()) {
            // 获取当前节点
            Node cur = queue.poll();

            System.out.print(cur.value + " ");
            
            // 1、如果当前节点有右孩子，但是没有左孩子，则直接结束
            if (cur.right != null && cur.left == null) {
                return false;
            }
            // 2、如果当前节点的左右孩子不双全，那么下一个节点开始，所有遍历的节点都没有孩子节点
            // 检查当前节点是否存在孩子节点，如果有孩子节点，则返回false
            if (beginFlag) {
                if (cur.left != null) {
                    return false;
                }
            }
            if (cur.right == null && !beginFlag) {
                beginFlag = true;
            }
            
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        
        return true;
    }

    /** 
     * 稍稍简化的写法
     */
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        // 申请一个开关变量
        boolean leaf = false;
        // 申请两个节点变量，分别用来存储左孩子和右孩子节点
        Node left;
        Node right;
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            left = cur.left;
            right = cur.right;
            
            // 判断当前节点是否不满足上面的条件
            // 1、已经出现了孩子没有双全的节点，且当前节点有左孩子或者右孩子，那么返回false
            // 2、当前节点有右孩子，但是没有左孩子，返回false
            if (leaf && (left != null || right != null) 
            || left == null && right != null) {
                return false;
            }
            
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            
            // 如果当前节点的左孩子或者右孩子为空，则将leaf开关打开
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.left.left.left = new Node(8);
        head.left.left.right = new Node(9);
        head.left.right.right = new Node(10);

        System.out.println(IfCompleteBT(head));
    }
}
