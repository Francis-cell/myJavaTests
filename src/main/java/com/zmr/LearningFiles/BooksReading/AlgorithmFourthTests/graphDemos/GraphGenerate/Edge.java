package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.graphDemos.GraphGenerate;

/**
 * <p> 图中边的定义 </p>
 */
public class Edge<T> {
    /** 边的权重值 */
    public T weight;

    /** 边上的来源点 */
    public Node from;

    /** 边上点的指向 */
    public Node to;

    public Edge(T weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
