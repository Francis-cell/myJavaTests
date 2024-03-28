package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.graphDemos.GraphGenerate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 图中节点定义 </p>
 */
public class Node<T> {
    /** 节点的值 */
    public T value;

    /** 节点的入度 */
    public int in;

    /** 节点的出度 */
    public int out;

    /** 从节点出去后节点的列表 */
    public List<Node> nexts;

    /** 从节点出去后边的列表 */
    public List<Edge> edges;

    public Node(T value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
