package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.TraversalBTExamples.SecondTraversalBTExamples;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName IfCBT
 * @Description 判断一棵二叉树是否是完全二叉树
 * 1、
 **/
public class IfCBTSecond {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node() {};
        public Node (int value) {
            this.value = value;
        }
    }
    
    /** main方法 */
    public static boolean ifCBTATree(Node head) {
        return process(head).isComplete;
    }
    
    /** Info类 */
    public static class Info {
        public int height;
        public int size;
        public boolean isFull;
        public boolean isComplete;
        
        public Info(int h, int s, boolean isFull, boolean ic) {
            this.height = h;
            this.size = s;
            this.isFull = isFull;
            this.isComplete = ic;
        }
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
        // 当左右子树都是满二叉树，且左子树height = 右子树height的时候才是
        boolean isFull = false;
        if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height) {
            isFull = true;
        }
        boolean isComplete = false;
        // 1、左子树是完全二叉树、右子树是满二叉树；左子树height = 右子树height + 1
        if (leftInfo.isComplete && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isComplete = true;
        }
        // 2、左子树是满二叉树、右子树是满二叉树；左子树height = 右子树height + 1
        else if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isComplete = true;
        }
        // 3、左子树是满二叉树、右子树是完全二叉树；左子树height = 右子树height
        else if (leftInfo.isFull && rightInfo.isComplete && leftInfo.height == rightInfo.height) {
            isComplete = true;
        }
        // 4、左子树是满二叉树、右子树是满二叉树；左子树height = 右子树height
        else if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height) {
            isComplete = true;
        }
        
        return new Info(height, size, isFull, isComplete);
    }

    /** 
     * 对数器方法 
     * 1、层序遍历(1、弹出节点-打印；2、有左先入左；有右先入右；先左后右)
     * 2、某个节点的左右孩子不双全，则剩下遍历的节点都没孩子节点
     */
    public static boolean ifCBTATreeForcible(Node head) {
        if (head == null) {
            return true;
        }
        // 层序遍历辅助结构
        Queue<Node> queue = new LinkedList<>();
        // 将头结点添加到队列中
        queue.add(head);
        // 声明一个是否有孩子的开关变量
        boolean hasChildren = true;
        
        while (!queue.isEmpty()) {
            // 获取当前节点
            Node cur = queue.poll();
            //System.out.print(cur.value + ", ");
            // 如果当前节点有右孩子，但是没有左孩子，则直接结束
            if (cur.right != null && cur.left == null) {
                return false;
            }
            
            // 需要查看一下这个开关
            if (!hasChildren) {
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
            
            // 判断当前节点的左右孩子是否双全，如果不双全，说明到了临界状态节点
            if (cur.left == null || cur.right == null) {
                // 从这里开始就要判断后面节点是否有孩子节点了，如果有孩子节点，则直接返回false
                hasChildren = false;
            }
            
            // 有左入左，有右入右，先左后右
            if (cur.left != null) {
                queue.add(cur.left);
            }
            
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return true;
    }
    
    /** 随机产生二叉树辅助方法 */
    public static Node generateBinaryTreeWithLevel(int level, int maxLevel, int maxValue) {
        // 如果当前level > maxLevel，则直接返回null
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue) + 1);
        head.left = generateBinaryTreeWithLevel(level + 1, maxLevel, maxValue);
        head.right = generateBinaryTreeWithLevel(level + 1, maxLevel, maxValue);
        return head;
    }
    
    
    /** 随机产生二叉树 */
    public static Node generateRandomBT(int maxLevel, int maxValue) {
        return generateBinaryTreeWithLevel(1, maxLevel, maxValue);
    }

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
        //head.left.left.right = new Node(9);
        //head.left.right.left = new Node(10);
        //head.left.right.right = new Node(11);
        //
        //System.out.println(ifCBTATreeForcible(head));
        //System.out.println(ifCBTATree(head));
        
        
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 100000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机产生二叉树，比较
            Node bt = generateRandomBT(maxLevel, maxValue);
            if (ifCBTATreeForcible(bt) != ifCBTATree(bt)) {
                System.out.println("出错了！");
                printTree(bt);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
