package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare.multiGraphExamples;

import com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare.Graph;
import com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare.GraphGenerator;
import com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * @ClassName SecondDFS
 * @Description DFS
 **/
public class SecondDFS {
    /** dfs */
    public static void dfs(Node start) {
        if (start == null) {
            return;
        }
        // 新建一个栈，用来存储当前正在走的路径
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        // 将当前节点添加进入stack和set中
        stack.push(start);
        set.add(start);
        // 打印当前节点
        System.out.print(start.value + ", ");
        while (!stack.isEmpty()) {
            // 元素出栈
            Node cur = stack.pop();
            // 遍历当前元素的nexts数组
            for (Node next : cur.nexts) {
                // 如果nexts数组中Node节点在set中没有存在，则将原本的元素压回栈中
                // 再将当前的next也压入栈中，因为是首次入栈，所以是一条新的路径，打印元素
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    // 更新set
                    set.add(next);
                    System.out.print(next.value + ", ");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
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
        dfs(graph.nodes.get(1));
        System.out.println();
        dfs(graph.nodes.get(2));
    }
}
