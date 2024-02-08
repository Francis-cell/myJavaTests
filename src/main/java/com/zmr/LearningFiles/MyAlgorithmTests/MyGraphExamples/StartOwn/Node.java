package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.StartOwn;

import com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare.Edge;

import java.util.ArrayList;

public class Node {
    /** 点的值 */
    public int value;

    /** 点的入度 */
    public int in;

    /** 点的出度 */
    public int out;

    /** 当前点指向的节点列表 */
    public ArrayList<Node> nexts;

    /** 点-指向节点时的边 */
    public ArrayList<Edge> edges;


}
