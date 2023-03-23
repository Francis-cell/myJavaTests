package com.zmr.LearningFiles.MyAlgorithmTests.MyGraphExamples.Prepare;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/17 22:48
 * @description 最小生成树算法-Prim算法(无向图)
 * 1、将所有的边从小到大排序
 * 2、点-->边-->点-->...逐渐推进寻找最小生成树路径
 * 
 * 最小生成树算法之Prim
 * ①、可以从任意节点出发来寻找最小生成树
 * ②、某个点加入到被选取的点中后，解锁这个点出发的所有新的边
 * ③、在所有解锁的边中选最小的边，然后看看这个边会不会形成环
 * ④、如果会，不要当前边，继续考察剩下解锁的边中最小的边，重复3)
 * ⑤、如果不会，要当前边，将该边的指向点加入到被选取的点中，重复2)
 * ⑥、当所有点都被选取，最小生成树就得到了
 */
public class Prim {
    /** 同样Prim也是贪心方式实现的，需要一个比较器参与 */
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
    
    /** Prim算法实现 */
    public static Set<Edge> primMST(Graph graph) {
        // 1、解锁的边进入到小根堆中去
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new EdgeComparator());
        
        // 2、当前被解锁出来的点有哪些
        HashSet<Node> nodeSet = new HashSet<>();
        
        // 3、依次挑选的边放到result中，最终结果
        Set<Edge> result = new HashSet<>();
        
        // 4、随便挑选一个节点
        for (Node node : graph.nodes.values()) {
            // node是开始点
            // 如果当前解锁的点集中包含当前的这个点，说明之前已经有边链接过了
            if (!nodeSet.contains(node)) {
                nodeSet.add(node);
                // 由这个节点node解锁的边，添加到小根堆中去
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                
                // 如果小根堆中没有空，继续执行
                while (!priorityQueue.isEmpty()) {
                    // 弹出其中一条边
                    Edge cur = priorityQueue.poll();
                    // 找到cur的终止node(这个节点可能是一个新的点)
                    Node toNode = cur.to;
                    
                    // 如果nodeSet中不包含当前的toNode，说明这个点就是一个新的节点
                    if (!nodeSet.contains(toNode)) {
                        // 更新nodeSet和result，并且将这个新的节点toNode的所有边添加进小根堆中去
                        nodeSet.add(toNode);
                        result.add(cur);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
            // TODO--如果要防止”森林“的出现，这里的break就要注释掉
            //break;
        }
        return result;
    }
}
