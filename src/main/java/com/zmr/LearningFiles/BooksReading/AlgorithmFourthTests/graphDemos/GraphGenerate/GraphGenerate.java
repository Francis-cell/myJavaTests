package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.graphDemos.GraphGenerate;


/**
 * <p> 初始化图 </p>
 */
public class GraphGenerate {
    /**
     * 创建一个 图
     * @param matrix
     * @return
     */
    public static Graph createGraph(Integer[][] matrix) {
        // 新建一个图
        Graph graph = new Graph();
        // 获取到存储结构 matrix 中的每一行的数据，向自己定义的图结构中转换
        for (int i = 0; i < matrix.length; i++) {
            // 权值
            int weight = matrix[i][0];
            // 边的来源
            int from = matrix[i][1];
            // 边的指向
            int to = matrix[i][2];

            // 如果自定义图结构中没有 from 节点和 to 节点，那么放入一个 from 和 to 节点
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            // 获取 from 到 to 之间的边
            // 1、获取 from 所在的节点
            Node fromNode = (Node) graph.nodes.get(from);
            // 2、获取 to 所在的节点
            Node toNode = (Node) graph.nodes.get(to);
            // 3、新建一条边
            Edge newEdge = new Edge(weight, fromNode, toNode);

            // 4、更新 fromNode 的 nexts 结构
            fromNode.nexts.add(toNode);
            // 5、更新 from 节点的出度
            fromNode.out++;
            // 6、更新 fromNode 的 edges 结构
            fromNode.edges.add(newEdge);
            // 7、更新 to 节点的入度
            toNode.in++;
            // 8、整张图中添加一条新的边
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
