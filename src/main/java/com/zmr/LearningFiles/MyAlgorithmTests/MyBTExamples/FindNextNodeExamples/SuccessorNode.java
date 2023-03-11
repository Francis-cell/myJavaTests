package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.FindNextNodeExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 15:54
 * @description 在二叉树中寻找后继节点（中序遍历下一个节点就是后继节点）
 * Node的定义和正常的树中Node的定义略有不同
 */
public class SuccessorNode {
    
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        
        public Node (int data) {
            this.value = data;
        }
    }

    /**
     * 
     * 说明：无需看左孩子，因为找的后继节点，必然在右孩子上找
     * 1、如果x有右子树，那么右子树最左侧节点就是后继节点
     * 2、如果x为当前树的最右侧节点，则看它的父亲节点是否是爷爷节点的左子树；
     * 否则一直往上找，如果找到一个祖先节点是它的父亲节点的左孩子，那么这个祖先
     * 节点的父亲节点就是当前x节点的后继节点；如果没有找到这样的祖先节点，则说明
     * 当前节点是中序遍历的最后一个节点
     */
    public static Node getSuccessorNode (Node node) {
        if (node == null) {
            return node;
        }
        // 第一种情况
        if (node.right != null) {
            return getLeftMost(node.right);
        } 
        // 第二种情况
        else {
            Node parent = node.parent;
            // 当前节点的父亲节点不为null，并且node是父亲节点的右孩子
            while (node.parent != null && parent.right == node) {
                // 将当前节点赋值给parent
                node = parent;
                // 将当前节点的爷爷节点赋值成新的parent节点
                parent = node.parent;
            }
            // 这里有两种情况：
            // 1、父亲节点一直到null，说明当前节点x是中序遍历过程中最后的一个节点，那么它的后继节点就是null
            // 2、找到了某个祖先节点是它的父亲节点的左孩子节点，那么返回这个祖先节点的父亲节点
            return parent;
        }
    }
    
    /** 找到一棵树的最左侧节点 */
    public static Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }
}
    
