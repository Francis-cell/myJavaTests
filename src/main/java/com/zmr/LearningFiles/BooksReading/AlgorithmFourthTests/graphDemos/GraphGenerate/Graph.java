package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.graphDemos.GraphGenerate;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <p> 图定义 </p>
 */
public class Graph<T> {
    /** 图上的点 */
    public HashMap<T, Node> nodes;

    /** 图上的边 */
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
