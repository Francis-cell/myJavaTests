package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare;

import java.util.ArrayList;

/**
 * @ClassName Node
 * @Description 图--点定义
 **/
public class Node {
    /** 点的值 */
    public int value;
    /** 点的入度 */
    public int in;
    /** 点的出度 */
    public int out;
    /** 点的指向节点列表 */
    public ArrayList<Node> nexts;
    /** 点--指向节点时-边*/
    public ArrayList<Edge> edges;
    
    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<Edge>();
    }
}
