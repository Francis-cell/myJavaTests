package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

import java.util.Stack;

/**
 * @ClassName UnRecursizeTraversalBT
 * @Description 非递归遍历二叉树
 **/
public class UnRecursizeTraversalBT {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node(int val) {
            this.value = val;
        }
    }
    
    /** 
     * 先序遍历
     * 1、栈顶出来记作cur(同时打印刚刚出栈的元素)
     * 2、有右压入右，有左压入左，先右后左
     */
    public static void pre(Node head) {
        System.out.println("非递归--先序遍历...");
        if (head != null) {
            // 新建一个栈
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            // 如果栈没有空，则可以出栈
            while (!stack.isEmpty()) {
                // 当前head节点转换成栈刚刚弹出的元素
                head = stack.pop();
                // 打印刚刚出栈的元素
                System.out.print(head.value + " ");
                // 有右压入右；有左压入左；先右后左
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
    
    /** 
     * 后序遍历 
     * 1、栈顶出来记作cur(将出来的元素压入另外一个栈中)
     * 2、有左压入左，有右压入右，先左后右
     * 3、辅助栈中元素出栈
     */
    public static void pos(Node head) {
        System.out.println("非递归-后续遍历(方式1)");
        if (head != null) {
            // 栈s1和先序遍历中使用的栈一样
            Stack<Node> s1 = new Stack<>();
            // s2是辅助栈
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                // 头右左 --颠倒之后--> 左右头
                head = s1.pop();
                // 元素入s2栈
                s2.push(head);
                // 有左压入左，有右压入右，先左后右
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            
            // 将辅助栈s2中的元素弹出，即为“左右头”顺序
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }
    
    
    /** 
     * 中序遍历 
     * 1、当前节点为cur，访问以cur为根节点的树的整个左边界，这些边界值
     * 进栈，直到遇到null为止，跳转第2步
     * 2、栈中节点弹出，打印，节点的右孩子为cur，回到第1步执行
     * 3、栈为空、cur指向为null [停止条件]
     */
    public static void in(Node cur) {
        System.out.println("非递归-中序遍历");
        if (cur != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || cur != null) {
                // 说明当前cur没有到树中叶子节点的子节点
                // 将以cur为根节点的整棵树的左边界上的节点都存放到栈中
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    // 否则说明到了叶子节点的子节点位置了
                    cur = stack.pop();
                    System.out.print(cur.value + " ");
                    // 转移到当前节点cur的右子树
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }
    
    
}
