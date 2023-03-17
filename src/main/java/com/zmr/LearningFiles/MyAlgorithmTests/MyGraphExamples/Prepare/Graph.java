package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName Graph
 * @Description 图
 **/
public class Graph {
    /** 图上的点 */
    public HashMap<Integer, Node> nodes;
    /** 图上的边 */
    public HashSet<Edge> edges;
    
    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
