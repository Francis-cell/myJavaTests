package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyGraphExamples.Prepare;

import java.util.*;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/17 22:02
 * @description 最小生成树算法Kruskal算法(无向图)【边特别多的情况下效果不好，考虑Prim算法】
 * 1、将所有的点拆成单个集合
 * 2、从小到大遍历所有的边，如果没有形成环，保留边，否则继续遍历，直至边遍历完
 * 
 * 最小生成树算法之Kruskal（流程）:
 * ①、总是从权值最小的边开始考虑，依次考察权值依次变大的边
 * ②、当前的边要么进入最小生成树的集合，要么丢弃
 * ③、如果当前的边进入最小生成树的集合中不会形成环，就要当前边
 * ④、如果当前的边进入最小生成树的集合中会形成环，就不要当前边
 * ⑤、考察完所有边之后，最小生成树的集合也得到了
 * 
 * 结合并查集实现
 */
public class Kruskal {
    /** 并查集实现(Node直接使用图中的Node即可) */
    public static class UnionFind {
        /** fatherMap: key 某个节点 -->  value, key节点往上的节点 */
        private HashMap<Node, Node> fatherMap;
        /** sizeMap: key 某个代表节点 --> value, key所在集合的节点数量 */
        private HashMap<Node, Integer> sizeMap;
        
        /** 构造方法 */
        public UnionFind() {
            this.fatherMap = new HashMap<Node, Node>();
            this.sizeMap = new HashMap<Node, Integer>();
        }
        
        /** 使用一个集合对象初始化这个UnionFind */
        public void makeSets(Collection<Node> nodes) {
            // 首先清空fatherMap和sizeMap中原本的值
            fatherMap.clear();
            sizeMap.clear();
            // 将所有的接地啊添加进去
            for (Node node : nodes) {
                // 初始的时候所有节点的父节点都是自己本身
                // 同时自己也是自己的代表节点，且集合中元素数量为1
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }
        
        /** 辅助方法寻找祖先节点 */
        private Node findAncestor(Node n) {
            Stack<Node> path = new Stack<>();
            // 如果当前节点的父亲不是自己，那么说明它不是某个集合的代表节点，继续往上找
            while (n != fatherMap.get(n)) {
                path.add(n);
                n = fatherMap.get(n);
            }
            
            // 将path中的节点的父亲节点都更新成当前找到的代表节点
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), n);
            }
            return n;
        }
        
        /** 1、isSameSet方法： 判断两个节点是否在同一个集合中“ */
        public boolean isSameSet(Node a, Node b) {
            return findAncestor(a) == findAncestor(b);
        }
        
        /** 2、union()方法：将节点a和节点b所在的集合进行合并 */
        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            
            // 找到a和b所在集合的代表节点
            Node aHead = findAncestor(a);
            Node bHead = findAncestor(b);
            
            if (aHead != bHead) {
                // 将小的集合的代表节点更新成大的集合的代表节点
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                
                Node bigHead = aSize >= bSize ? aHead : bHead;
                Node smallHead = bigHead == aHead ? bHead : aHead;
                
                fatherMap.put(smallHead, bigHead);
                sizeMap.put(bigHead, aSize + bSize);
                sizeMap.remove(smallHead);
            }
        }
    }
    
    /** 说明--Kruskal实际上使用的是贪心方式实现的，所以这里使用比较器 */
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            // 按照权值从小到大排序
            return o1.weight - o2.weight;
        }
    }
    
    /** Kruskal实现 */
    public static Set<Edge> kruskalMST(Graph graph) {
        // 1、新建并查集对象
        UnionFind unionFind = new UnionFind();
        // 将graph中所有的节点都放到并查集中
        unionFind.makeSets(graph.nodes.values());
        
        // 所有的边需要从小到大的弹出，所以直接构建小根堆实现(里面直接传入比较器)
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new EdgeComparator());
        // 将所有的边添加进小根堆中去
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        
        // 新建HashSet, 用于存储最终的结果
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            // 当前正在进行处理的边
            Edge cur = priorityQueue.poll();
            // 如果当前边的开始节点和终止节点不在一个集合中，那么将边添加到结果集中，
            // 同时将当前边的起始节点和终止节点合并到一个集合中去
            if (!unionFind.isSameSet(cur.from, cur.to)) {
                result.add(cur);
                unionFind.union(cur.from, cur.to);
            }
        }
        return result;
    }
}
