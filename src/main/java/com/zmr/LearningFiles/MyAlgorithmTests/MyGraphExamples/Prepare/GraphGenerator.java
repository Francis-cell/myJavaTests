package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare;

/**
 * @ClassName GraphGenerator
 * @Description 图-适配器方法
 * 这里适配的是[权值, from节点的值, to节点的值]这种结构存储的图
 **/
public class GraphGenerator {
    public static Graph createGraph(int[][] matrix) {
        // 新建一个自定义的图对象
        Graph graph = new Graph();
        // 获取到存储结构matrix中的每一行的数据，往自己的图结构中转换
        for (int i = 0; i < matrix.length; i++) {
            // 权值
            int weight = matrix[i][0];
            // 边来源点
            int from = matrix[i][1];
            // 边指向点
            int to = matrix[i][2];
            
            // 如果自定义图结构中没有from节点和to节点，那么放入
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            
            // 获取from和to之间的边
            // 1、获取from所在的节点
            Node fromNode = graph.nodes.get(from);
            // 2、获取to所在的节点
            Node toNode = graph.nodes.get(to);
            // 3、新建一条边
            Edge newEdge = new Edge(weight, fromNode, toNode);
            
            // 4、更新fromNode节点的nexts结构
            fromNode.nexts.add(toNode);
            // 5、from节点的出度++
            fromNode.out++;
            // 6、from节点为出发点的边增加一条
            fromNode.edges.add(newEdge);
            // 7、to节点的入度++
            toNode.in++;
            // 8、整张图中添加一条新的边
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
