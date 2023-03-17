package com.zmr.LearningFiles.MyAlgorithmTests.MyAndLookupExamples.myselfAndLookupTests;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName MySecondUnionFind
 * @Description 并查集--HashMap实现
 **/
public class MySecondUnionFind {
    /** 辅助类 */
    public static class Node<V> {
        V value;
        
        public Node(V v) {
            value = v;
        }
    }
    
    /** 并查集实现类 */
    public static class UnionFind<V> {
        /** nodes对应的HashMap--(node-v, 代表节点) */
        public HashMap<V, Node<V>> nodes;
        /** parent对应的HashMap--(node, parent) */
        public HashMap<Node<V>, Node<V>> parents;
        /** 代表节点size对应的HashMap--(代表节点, size) */
        public HashMap<Node<V>, Integer> sizeMap;
        
        /** 构造方法-初始化 */
        public UnionFind(List<V> values) {
            // 初始化上面三个HashMap
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            
            // 将values列表中所有的节点都声明成一个能代表自身的集合
            // 这里的cur实际上是某个节点的值，而不是具体的节点
            for (V cur : values) {
                // 将List中每个值都转换成对应的node节点
                Node<V> node = new Node<>(cur);
                // 分别放到3个HashMap中
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }
        
        /** 
         * 关键辅助方法(给一个节点，一直往上找，直到找到最前面的祖先节点) 
         * 将沿途的节点的父亲节点都更新成找到的那个祖先节点
         */
        public Node<V> findAncestor(Node<V> cur) {
            // 声明一个栈用来辅助操作(记录沿途的节点--路径)
            Stack<Node<V>> path = new Stack<>();
            // 如果当前节点的父节点不是自己，说明当前节点不是它所在集合的代表节点
            while (cur != parents.get(cur)) {
                // 沿途节点入栈
                path.push(cur);
                // 将cur的父亲节点赋值给cur
                cur = parents.get(cur);
            }
            
            // 直到找到当前集合的代表节点，将path中存储的所有节点的父亲直接挂为代表节点
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            
            return cur;
        }
        
        /** 1、isSameSet(), 查看两个node节点是否在同一个集合中 */
        public boolean isSameSet(V a, V b) {
            return findAncestor(nodes.get(a)) == findAncestor(nodes.get(b));
        }
        
        /** 2、union(), 合并两个节点a和b所在的集合 */
        public void union(V a, V b) {
            // 首先找打a和b所在集合的代表节点
            Node<V> aHead = findAncestor(nodes.get(a));
            Node<V> bHead = findAncestor(nodes.get(b));
            
            if (aHead != bHead) {
                // 将小的set挂到大的set上
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                
                // 分别找到大的set的代表节点和小的set的代表节点
                Node<V> big = aSize >= bSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                
                // 将小的set挂到大的set上
                parents.put(small, big);
                // 将小的set的size直接合并到大的set上
                // 直接更新大的set的size的值
                sizeMap.put(big, aSize + bSize);
                // 直接删除小的set对应的sizeMap的记录
                sizeMap.remove(small);
            }
        }
        
        /** 获取形成的集合的数量 */
        public int sets() {
            return sizeMap.size();
        }
    }
}
