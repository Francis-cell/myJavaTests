package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare;

import java.util.*;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/17 21:23 
 * @description 拓扑排序实现
 */
public class GraphSort {
    /** 拓扑排序实现 */
    public static List<Node> sortedTopology(Graph graph) {
        // key 某个节点  value 剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 只有入度为0的节点，才能进入这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            // 初始化inMap，使用每个节点的入度进行初始化
            inMap.put(node, node.in);
            // 如果当前节点的入度为0，那么将这个节点添加到0入度的队列中去
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        
        // 拓扑排序之后的结果列表
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            // 获取当前的节点
            Node cur = zeroInQueue.poll();
            result.add(cur);
            // 消除当前节点之后，将cur的nexts数组中的元素的入度都减一
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                // 如果消除cur出度的影响之后，新出现了入度为0的节点，则将这些节点添加到inMap中去
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
