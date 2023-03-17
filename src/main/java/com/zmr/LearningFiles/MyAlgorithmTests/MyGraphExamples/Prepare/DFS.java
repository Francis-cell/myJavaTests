package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare;

import java.util.HashSet;
import java.util.Stack;

/**
 * @ClassName DFS
 * @Description 图-深度优先遍历
 * 从node出发，进行深度优先遍历
 **/
public class DFS {
    /** 
     * 使用栈-集合-迭代实现(不使用系统栈实现) 
     * 
     * 1、栈中元素出栈
     * 2、当前走到的节点的nexts数组中的节点是否遍历完全
     *    ①、如果遍历完全，则元素彻底出栈
     *    ②、如果没有遍历完全，将当前节点重新压回栈中，将nexts中没有入栈的元素压入栈
     *    同时将这个新的节点记录到set中
     * 
     * 3、首次压栈的时候就打印
     */
    public static void dfs(Node start) {
        if (start == null) {
            return;
        }
        // 新建一个栈，用来存储当前正在走的路径情况
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        // 将当前开始的节点压入栈和set中去
        stack.add(start);
        set.add(start);
        // 打印当前节点
        System.out.print(start.value + ", ");
        while (!stack.isEmpty()) {
            // 元素出栈
            Node cur = stack.pop();
            // 遍历当前元素的nexts数组
            for (Node next : cur.nexts) {
                // 如果nexts数组中的Node节点在set中如果没有存在，则将
                // 这个元素压入栈中，同时由于这里的元素是首次入栈，打印元素
                if (!set.contains(next)) {
                    // 将当前元素重新压回栈中
                    stack.push(cur);
                    // 将没有在set中出现的next节点压入栈中
                    stack.push(next);
                    // 将next存入到set中
                    set.add(next);
                    System.out.print(next.value + ", ");
                    // 以cur.next作为当前节点，继续向下寻找元素
                    break;
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
        dfs(graph.nodes.get(1));
        System.out.println();
        dfs(graph.nodes.get(2));
    }
}
