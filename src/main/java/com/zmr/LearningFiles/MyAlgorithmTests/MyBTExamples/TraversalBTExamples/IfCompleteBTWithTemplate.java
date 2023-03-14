package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/12 15:14
 * @description 判断一棵树是否是完全二叉树【使用套路求解】
 * 1、左树是完全二叉树、右树是满二叉树、左树height = 右树height + 1、整棵树是完全二叉树
 * 2、左树是满二叉树、右树是满二叉树、左树height = 右树height + 1、整棵树是完全二叉树
 * 3、左树是满二叉树、右树是完全二叉树、左树heigth = 右树height、整棵树是完全二叉树
 * 4、左树是满二叉树、右树是满二叉树、左树height = 右树height、整棵树是满二叉树
 * 
 * 需要获取的信息有
 * 1、height
 * 2、size
 */
public class IfCompleteBTWithTemplate {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node() {}
        public Node(int val) {
            this.value = val;
        }
    }
    
    /** Info类 */
    public static class Info {
        public int height;
        public int size;
        public boolean ifComplete;
        public boolean ifFull;
        
        public Info(int h, int s, boolean ic, boolean ifs) {
            height = h;
            size = s;
            ifComplete = ic;
            ifFull = ifs;
        }
    }
    
    public static boolean IfCompleteBt(Node head) {
        return process(head).ifComplete;
    }
    
    /** process方法 */
    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0, true, true);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int size = leftInfo.size + rightInfo.size + 1;

        // 判断是否是满二叉树
        boolean ifFull = false;
        // 判断是否是完全二叉树
        boolean ifComplete = false;
        // 1、左完全二叉树、右满二叉树、左height = 右height + 1
        if (leftInfo.ifComplete && rightInfo.ifFull 
                && leftInfo.height == rightInfo.height + 1) {
            ifComplete = true;
        }
        // 2、左满二叉树、右满二叉树、左height = 右height + 1
        if (leftInfo.ifFull && rightInfo.ifFull 
                && leftInfo.height == rightInfo.height + 1) {
            ifComplete = true;
        }
        // 3、左满二叉树、右完全二叉树、左height = 右height
        if (leftInfo.ifFull && rightInfo.ifComplete 
                && leftInfo.height == rightInfo.height) {
            ifComplete = true;
        }
        // 4、左满二叉树、右满二叉树、左height = 右height
        if (leftInfo.ifFull && rightInfo.ifFull 
                && leftInfo.height == rightInfo.height) {
            ifComplete = true;
            ifFull = true;
        }

        //System.out.println("x: " + x.value + " 4个值: " + height + ", " + size + ", " + 
        //        ifComplete + ", " + ifFull);
        
        return new Info(height, size, ifComplete, ifFull);
    }
    
    /** 对数器 */
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

    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                // 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
                    (leaf && (l != null || r != null))
                            ||
                            (l == null && r != null)

            ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
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

            //System.out.print(cur.value + " ");

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

    /** 随机产生二叉树--辅助方法 */
    public static Node generateBT(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int)(Math.random() * maxValue));
        head.left = generateBT(level + 1, maxLevel, maxValue);
        head.right = generateBT(level + 1, maxLevel, maxValue);
        return head;
    }
    
    public static Node generateRandomBT(int maxLevel, int maxValue) {
        return generateBT(1, maxLevel, maxValue);
    }
    
    /** 打印二叉树 */
    /** 打印二叉树主方法 */
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    /** 中序打印二叉树 */
    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        // 递归打印右子树
        printInOrder(head.right, height + 1, "v", len);
        // 拼接要打印在控制台的字符串
        String val = to + head.value + to;
        // 每个字符串实际上由三部分组成：①、左侧空白；②、val值；③、右侧空白；
        // val值
        int lenM = val.length();
        // 左侧空白长度
        int lenL = (len - lenM) / 2;
        // 右侧空白长度
        int lenR = len - lenM - lenL;

        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);

        // 递归打印左子树
        printInOrder(head.left, height + 1, "^", len);
    }

    /** 生成指定数量的空格字符串，用来拼接回原本的字符串 */
    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        //Node head = new Node(1);
        //head.left = new Node(2);
        //head.right = new Node(3);
        //head.left.left = new Node(4);
        //head.left.right = new Node(5);
        //head.right.left = new Node(6);
        //head.right.right = new Node(7);
        //head.left.left.left = new Node(8);
        ////head.left.left.right = new Node(9);
        //head.left.right.left = new Node(10);
        ////head.left.right.right = new Node(11);
        ////head.right.left.left = new Node(12);
        //
        
        //Node head = new Node(11);
        //head.right = new Node(94);
        //head.right.left = new Node(31);
        //head.right.right = new Node(62);
        //head.right.left.right = new Node(58);
        //head.right.left.right.left= new Node(13);
        //head.right.left.right.right= new Node(19);
        //
        //
        //
        //System.out.println(IfCompleteBt(head));
        //System.out.println(isCBT1(head));
        //System.out.println(isCBT(head));
        
        
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机产生二叉树
            Node head = generateRandomBT(maxLevel, maxValue);
            if (IfCompleteBT(head) != IfCompleteBt(head)) {
                System.out.println("出错了！");
                //printTree(head);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
