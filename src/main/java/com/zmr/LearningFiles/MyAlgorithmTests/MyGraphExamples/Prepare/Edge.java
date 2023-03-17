package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare;

/**
 * @ClassName Edge
 * @Description 图-边
 **/
public class Edge {
    /** 边上的权值 */
    public int weight;
    /** 边上点的来源 */
    public Node from;
    /** 边上点的指向 */
    public Node to;
    
    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
