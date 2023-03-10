package com.zmr.LearningFiles.MyAlgorithmTests.MyBTExamples.TraversalBTExamples;

import com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyHeapExamples.Heap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/10 21:07
 * @description 序列化二叉树
 */
public class SerializeBT {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node(int val) {
            this.value = val;
        }
    }

    /** ======================序列化========================= */
    /** 先序遍历方式序列化二叉树 */
    public Queue<String> preSerialize(Node root) {
        Queue<String> ans = new LinkedList<>();
        // 调用序列化处理方法（递归处理）
        pres(root, ans);
        return ans;
    }
    
    public static void pres(Node root, Queue<String> ans) {
        if (root == null) {
            ans.add(null);
        } else {
            ans.add(Integer.toString(root.value));
            pres(root.left, ans);
            pres(root.right, ans);
        }
    }
    
    
    /** 后序遍历方式序列化二叉树 */
    public Queue<String> posSerialize(Node root) {
        Queue<String> ans = new LinkedList<>();
        poss(root, ans);
        return ans;
    }
    
    public static void poss(Node root, Queue<String> ans) {
        if (root == null) {
            ans.add(null);
        } else {
            poss(root.left, ans);
            poss(root.right, ans);
            ans.add(Integer.toString(root.value));
        }
    } 
    
    
    /** 中序遍历方式序列化二叉树 */
    // 中序序列化之后存在歧义
    /**         __2
     *        /
     *       1
     *       
     *       和
     *       
     *       1__
     *          \
     *           2
     * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
     *
     */
    
    
    /** ======================反序列化========================= */
    /** 先序遍历反序列化 */
    public static Node buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.size() == 0) {
            return null;
        }
        return preb(preList);
    } 
    
    public static Node preb(Queue<String> preList) {
        String value = preList.poll();
        if (value == null) {
            return null;
        }
        Node root = new Node(Integer.valueOf(value));
        root.left = preb(preList);
        root.right = preb(preList);
        return root;
    }
    
    
    /** 后续遍历反序列化(可以实际上绘制一下图，理解更加透彻) */
    public static Node buildByPosQueue(Queue<String> posList) {
        if (posList == null || posList.size() == 0) {
            return null;
        }
        // 为了让处理程序posb使用时的顺序为 "头右左" 的顺序，需要提前使用一个栈处理一下顺序
        Stack<String> stack = new Stack();
        while (!posList.isEmpty()) {
            stack.push(posList.poll());
        }
        return posb(stack);
    }
    
    public static Node posb(Stack<String> posStack) {
        String value = posStack.pop();
        if (value == null) {
            return null;
        }
        // 头右左 ----> 左右头
        Node root = new Node(Integer.valueOf(value));
        root.right = posb(posStack);
        root.left = posb(posStack);
        return root;
    }
    
    
    
    
    /** ====================层级序列化&反序列化==================== */
    /** 层级序列化 */
    public static Queue<String> levelSerial(Node root) {
        Queue<String> ans = new LinkedList<>();
        if (root == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(root.value));
            // 声明一个专门用来存储Node节点的序列
            Queue<Node> queue = new LinkedList<Node>();
            // 将当前节点添加到队列中，如果当前节点有左子节点，则加入左子结点
            // 如果当前节点有右子节点，则加入右子节点
            queue.add(root);
            while (!queue.isEmpty()) {
                // 节点出队列
                root = queue.poll();
                if (root.left != null) {
                    // 如果左子节点不为null：既要入ans队列，也要入节点队列queue
                    ans.add(String.valueOf(root.left.value));
                    queue.add(root.left);
                } else {
                    // 否则说明当前节点的左子节点为null，则直接将null添加到ans即可
                    ans.add(null);
                }
                
                // 同左节点的处理方法
                if (root.right != null) {
                    ans.add(String.valueOf(root.right.value));
                    queue.add(root.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }
    
    /** 辅助方法 */
    public static Node generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
    
    /** 层级反序列化 */
    public static Node buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        
        Node root = generateNode(levelList.poll());
        // 新建辅助队列
        Queue<Node> queue = new LinkedList<Node>();
        if (root != null) {
            queue.add(root);
        }
        
        while (!queue.isEmpty()) {
            // 先建好初始的node，方便连接
            Node node = null;
            // 当前抵达的节点
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            
            // 如果节点的左孩子不为空，则添加进队列
            if (node.left != null) {
                queue.add(node.left);
            }
            // 如果节点的右孩子不为空，则添加进队列
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
