package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/12 17:03
 * @description 给定一棵二叉树的头结点head，和另外两个节点a，b；找到a和b的最低公共祖先
 */
public class FindMinAncestor {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node() {};
        public Node(int value) {
            this.value = value;
        }
    }
    
    /** 对数器方法 */
    public static Node findMinAncestorWithHashSet(Node head, Node a, Node b) {
        if (head == null) {
            return null;
        }
        
        // key的父节点是value
        HashMap<Node, Node> parentMap = new HashMap<>();
        // 放入头结点
        parentMap.put(head, null);
        fillParentMap(head, parentMap);

        // 新建一个hashSet用来存储到A的路径
        HashSet<Node> aSet = new HashSet<>();
        Node cur = a;
        aSet.add(cur);
        while (parentMap.get(cur) != null) {
            // 获取到当前节点的父节点
            cur = parentMap.get(cur);
            // 添加到set表中
            aSet.add(cur);
        }
        
        cur = b;
        while (!aSet.contains(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }
    
    /** 前序遍历填充hashMap */
    public static void fillParentMap(Node head, HashMap<Node, Node> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }
        
        if (head.right != null) {
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
    }
    
    /** 递归解法 */
    public static class Info {
        public boolean findA;
        public boolean findB;
        public Node ans;
        
        public Info (boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }
    
    public static Node findMinAncestor(Node head, Node a, Node b) {
        return process(head, a, b).ans;
    }
    
    public static Info process(Node x, Node a, Node b) {
        if (x == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);

        boolean findA = (x == a) || leftInfo.findA || rightInfo.findA;
        boolean findB = (x == b) || leftInfo.findB || rightInfo.findB;
        
        Node ans = null;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        } else if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        } else {
            // 如果找到了A，且找到了B，则最小祖先节点必然是当前节点
            if (findA && findB) {
                ans = x;
            }
        }
        
        return new Info(findA, findB, ans);
    }

    /** 随机生成二叉树 */
    public static Node generateRandomBT(int maxLevel, int maxValue) {
        return generateBT(1, maxLevel, maxValue);
    }
    
    public static Node generateBT(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int)(Math.random() * maxValue));
        head.left = generateBT(level + 1, maxLevel, maxValue);
        head.right = generateBT(level + 1, maxLevel, maxValue);
        return head;
    }
    
    /** 获取一棵树中的某个节点 */
    public static Node pickRandomOne(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> arr = new ArrayList<>();
        fillPreList(head, arr);
        
        // 随机生成一个下标index
        int randomIndex = (int) (Math.random() * arr.size());
        return arr.get(randomIndex);
    }
    
    /** 先序变量添加节点到一个ArrayList中去 */
    public static void fillPreList(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPreList(head.left, arr);
        fillPreList(head.right, arr);
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机生成二叉树
            Node head = generateRandomBT(maxLevel, maxValue);
            // 随机生成a,b节点
            Node a = pickRandomOne(head);
            Node b = pickRandomOne(head);
            if (findMinAncestorWithHashSet(head, a, b) != findMinAncestor(head, a, b)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
