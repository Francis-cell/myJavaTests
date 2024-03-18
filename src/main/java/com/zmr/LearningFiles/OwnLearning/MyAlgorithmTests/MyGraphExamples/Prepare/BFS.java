package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyGraphExamples.Prepare;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BFS
 * @Description 图-宽度优先遍历
 * 从node出发，进行宽度优先遍历
 **/
public class BFS {
    /** 
     * 使用 二叉树--层序遍历 + Set去重 的方式实现
     * queue中元素出队，元素打印
     */
    public static void bfs(Node start) {
        if (start == null) {
            return;
        }
        // 用于层序遍历的queue结构
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        // 将开始的头节点添加到set集合中
        set.add(start);
        
        while (!queue.isEmpty()) {
            // 获取当前节点
            Node cur = queue.poll();
            System.out.print(cur.value + ", ");
            // 遍历当前节点cur的nexts数组
            for (Node next : cur.nexts) {
                // 如果set中没有包含nexts数组中的某个Node节点
                if (!set.contains(next)) {
                    // set中添加，queue中也添加
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个图
        
        // 构建图中需要的节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        
        // 图连接
        // 这里没有权值，所以所有边的weight默认设置为1
        int[][] matrix = new int[][] {
                new int[] {1, 1, 1},
                new int[] {1, 1, 2},
                new int[] {1, 2, 3},
                new int[] {1, 2, 4},
                new int[] {1, 3, 4},
                new int[] {1, 4, 5},
                new int[] {1, 6, 5},
                new int[] {1, 1, 7}
        };

        Graph graph = GraphGenerator.createGraph(matrix);
        bfs(graph.nodes.get(1));
        System.out.println();
        bfs(graph.nodes.get(6));
    }
}
