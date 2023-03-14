package com.zmr.LearningFiles.MyAlgorithmTests.MyAndLookupExamples;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/13 21:26
 * @description 并查集
 */
public class MyUnionFind {
    
    /** 辅助类(主要是因为要将每个节点封装成一个结构，方便使用) */
    public static class Node<V> {
        V value;
        
        public Node(V v) {
            value = v;
        }
    }
    
    public static class UnionFind<V> {
        /** 声明nodes节点的map，用来存储 Map<node, 代表节点> */
        public HashMap<V, Node<V>> nodes;
        /** 声明parent的map，用来存储 Map<node, parent> 每个节点的父节点--代替指针(优化点) */
        public HashMap<Node<V>, Node<V>> parents;
        /** 声明代表节点的size的map，用来存储 Map<node, Integer> */
        public HashMap<Node<V>, Integer> sizeMap;
        
        /** 构造方法--初始化 */
        public UnionFind(List<V> values) {
            // 初始化上面三个hashMap
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            
            for (V cur : values) {
                // 获取列表中所有的节点
                Node<V> node = new Node<>(cur);
                // 分别放到3个hashMap中去
                // 最初的时候，每个节点的代表节点是它自己本身
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }
        
        /** 
         * (关键辅助方法)给一个节点，一直往上找，一直找到无法继续，把代表节点返回 
         * 
         * 遍历一条链，将链上所有遇上的节点都存放到一个Stack中，
         * 直到一直找到代表节点(node.parent = node)，那么将栈中存储的所有
         * 节点的父亲节点更新成代表节点(后续便会降低时间复杂度为O(1)，第一次为O(N))
         */
        public Node<V> findAncestor(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            // 说明当前节点不是自己的父亲节点，即当前节点不是当前集合的"代表节点"
            while (cur != parents.get(cur)) {
                // 入栈
                path.push(cur);
                // 将cur的父亲节点赋值给当前的cur
                cur = parents.get(cur);
            }
            
            // 出栈，并将栈中所有的节点在parents中的记录更新
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            
            return cur;
        }
        
        /** 获取一个set的大小(节点数量) */
        public int sets() {
            return sizeMap.size();
        }
        
        /** 1、关键方法：isSameSet() --- 判断两个node是否在同一个set中 */
        public boolean isSameSet(V a, V b) {
            // 如果 a所在集合的代表节点 == b所在的集合的代表节点，则true，否则返回false
            return findAncestor(nodes.get(a)) == findAncestor(nodes.get(b)); 
        }
        
        /** 2、合并两个node节点所在的集合 */
        public void union(V a, V b) {
            // 首先找到a、b对应节点所在集合的代表节点
            Node<V> aHead = findAncestor(nodes.get(a));
            Node<V> bHead = findAncestor(nodes.get(b));
            // 如果aHead == bHead，那么可以什么都不做，因为本身就在同一个集合中
            
            if (aHead != bHead) {
                // 小的set挂到大的set上
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                // 分别找到大的set的代表节点和小的set的代表节点
                Node<V> big = aSetSize > bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                
                // 将小的set挂到大的set的代表节点上
                parents.put(small, big);
                // 将小的set直接合并到大的set上
                sizeMap.put(big, aSetSize + bSetSize);
                // 直接删除小的set对应的sizeMap记录
                sizeMap.remove(small);
            }
        }
    }
}
