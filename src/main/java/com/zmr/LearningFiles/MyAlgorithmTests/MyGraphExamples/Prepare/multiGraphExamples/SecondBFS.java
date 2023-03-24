package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare.multiGraphExamples;

import com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare.Graph;
import com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare.GraphGenerator;
import com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName SecondBFS
 * @Description BFS
 **/
public class SecondBFS {
    /**
     * bfs
     */
    public static void bfs(Node start) {
        if (start == null) {
            return;
        }
        // 层序遍历 + set实现
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        // 将当前节点添加到set中
        set.add(start);

        while (!queue.isEmpty()) {
            // 获取当前节点
            Node cur = queue.poll();
            // 打印
            System.out.print(cur.value + ", ");
            // 遍历当前节点cur的nexts数组
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个图
        // 图连接
        // 这里没有权值，所以所有边的weight默认设置为1
        int[][] matrix = new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 1, 2},
                new int[]{1, 2, 3},
                new int[]{1, 2, 4},
                new int[]{1, 3, 4},
                new int[]{1, 4, 5},
                new int[]{1, 6, 5},
                new int[]{1, 1, 7}
        };

        Graph graph = GraphGenerator.createGraph(matrix);
        bfs(graph.nodes.get(1));
        System.out.println();
        bfs(graph.nodes.get(6));
    }
}
