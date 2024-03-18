package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/11 11:41
 * @description 通过层级遍历，每层都获取结束点
 */
public class TreeMaxWidth {
    
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node(int val) {
            value = val;
        }
    }
    
    /** 
     * 通过容器(Map)的方式实现 
     * 这里的map的作用：
     * 某层的时候，节点的数量
     * 
     * levelMap: 记录层节点数量信息的map
     * curLevel: 当前正在统计哪一层的宽度
     * curLevelNodes: 当前层curLevel层，宽度目前是多少
     * max: 最大层的节点个数
     */
    public static int maxWidthUseMap(Node head) {
        if(head == null) {
            return 0;
        }
        // 层序遍历需要使用的queue队列
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        
        // key在哪一层,value, 借助HashMap进行存储
        HashMap<Node, Integer> levelMap = new HashMap<>();
        // levelMap放置的是某层的节点：例如这里是第一层有一个head节点
        // 如果它的左孩子为a，右孩子为b，
        // 那么使用levelMap.put(a, 2)和 levelMap.put(b, 3)
        levelMap.put(head, 1);
        
        // 当前正在统计哪一层的宽度
        int curLevel = 1;
        // 当前层curLevel层，宽度目前是多少
        int curLevelNodes = 0;
        // 最大层的节点个数
        int max = 0;
        
        while (!queue.isEmpty()) {
            // 出列
            Node cur = queue.poll();
            // 获取当前节点的父节点的孩子节点有多少个（根节点没有父节点，这里值为1）
            int curNodeLevel = levelMap.get(cur);
            
            // 如果有左孩子，当前节点的左孩子的curNodeLevel的值+1
            if (cur.left != null) {
                // 将左孩子加入到下一层的levelMap中
                levelMap.put(cur.left, curNodeLevel + 1);
                // 队列中放入当前孩子的左孩子
                queue.add(cur.left);
            }
            
            // 右孩子同理
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            
            // 将levelMap中值和当前正在统计层的节点进行数量累加
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } 
            // 否则说明到了下一层了
            else {
                max = Math.max(max, curLevelNodes);
                // 开始统计下一层节点数量
                curLevel++;
                // 节点统计重置为1，
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }
    
    /** 
     * 通过有限几个变量的方式实现 
     * 1、curEnd: 当前层最右侧节点是谁
     * 2、nextEnd: 下一层最右侧节点是谁
     * 3、max: 当前每层最大的节点数量
     * 4、curLevelNodes: 当前层的节点数量
     */
    public static int maxWithNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        
        // 层级遍历辅助队列
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        
        // 当前层最右侧节点是谁
        Node curEnd = head;
        // 下一层最右侧节点是谁
        Node nextEnd = null;
        
        int max = 0;
        // 当前层的节点数量
        int curLevelNodes = 0;
        
        while (!queue.isEmpty()) {
            // 当前节点出队
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                // 下一层最右侧节点设置为当前节点的左孩子节点
                nextEnd = cur.left;
            }
            
            if (cur.right != null) {
                queue.add(cur.right);
                // 下一层最右侧节点设置为当前节点的右孩子节点
                nextEnd = cur.right;
            }
            
            // 当前层节点数量++
            curLevelNodes++;
            
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                // 重置curLevelNodes，因为当前行结束了
                curLevelNodes = 0;
                // 到下一层了,更换curEnd为原本的nextEnd的值
                curEnd = nextEnd;
            }
        }
        return max;
    }
    
    /** 对数器 */
    /** 随机产生二叉树 */
    public static Node generateRandomBT(int maxLevel, int maxValue) {
        return generateBT(1, maxLevel, maxValue);
    }
    
    /** 
     * 牛！！！
     * 生成二叉树辅助方法(
     * 1、level: 当前正在生成的二叉树层
     * 2、maxLevel: 要生成的二叉树的最大层数
     * 3、maxValue: 当前要生成的二叉树中最大的节点的值
     * )
     * 
     * 说明：当Math.random()的值小于0.5的时候，则产生null节点，否则产生的是有左右孩子的节点
     * */
    public static Node generateBT(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generateBT(level + 1, maxLevel, maxValue);
        head.right = generateBT(level + 1, maxLevel, maxValue);
        return head;
    }
    
    /** test */
    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBT(maxLevel, maxValue);
            if (maxWidthUseMap(head) != maxWithNoMap(head)) {
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束！");
    }
}
