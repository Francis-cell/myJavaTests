package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyAndLookupExamples.myselfAndLookupTests;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName MyThirdUnionFind
 * @Description 并查集-第三次实现(集合的合并、查找)
 **/
public class MyThirdUnionFind {
    /** 辅助类 */
    public static class Node<V> {
        V value;
        
        public Node(V v) {
            value = v;
        }
    }
    
    /** 并查集实现类--HashMap */
    public static class UnionFindWithHashMap<V> {
        /** nodes--(node, 代表节点); 当前节点和代表节点的关系 */
        public HashMap<V, Node<V>> nodes;
        /** parents--(node, parent); 当前节点和它的父节点的关系 */
        public HashMap<Node<V>, Node<V>> parents;
        /** sizeMap--(代表节点, size); 当前节点是某个集合的代表节点，对应的size大小 */
        public HashMap<Node<V>, Integer> sizeMap;
        
        /** 构造方法 */
        public UnionFindWithHashMap (List<V> values) {
            // 初始化上面三个HashMap
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            
            // 将values类列表中所有的节点都声明成一个能代表自身的集合
            // 这里的cur是某个节点的值，需要封装一层变成Node才是节点
            for (V cur : values) {
                // 将List中的每个值都转换成对应的node节点
                Node<V> node = new Node<>(cur);
                // 更新nodes, parents, sizeMap
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }
        
        /** 辅助方法，给定一个节点，找到它的代表节点(另外更新沿途节点的直接父节点为代表节点) */
        public Node<V> findAncestor(Node<V> cur) {
            // 声明一个栈结构来进行辅助操作(记录沿途的节点--路径)
            Stack<Node<V>> path = new Stack<>();
            // 如果当前节点的parent不是自己，那么说明还没有找到代表节点
            while (cur != parents.get(cur)) {
                // 沿途节点入栈
                path.push(cur);
                cur = parents.get(cur);
            }
            
            // 将沿途的节点的父节点更新成找到的代表节点
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }
        
        /** 1、isSameSet()方法，查看两个节点是否在同一个集合中 */
        public boolean isSameSet(V a, V b) {
            return findAncestor(nodes.get(a)) == findAncestor(nodes.get(b));
        }
        
        /** 2、union()方法，合并两个节点a和b所在的集合 */
        public void union(V a, V b) {
            // 首先找到a和b两个节点所在集合的代表节点
            Node<V> aHead = findAncestor(nodes.get(a));
            Node<V> bHead = findAncestor(nodes.get(b));
            
            // 说明a和b在不同的集合中
            if (aHead != bHead) {
                // 将小的集合合并到大的集合上面
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                
                // 分别找到两个set中的代表节点
                Node<V> bigHead = aSize >= bSize ? aHead : bHead;
                Node<V> smallHead = bigHead == aHead ? bHead : aHead;
                
                // 将小的set挂到大的set上
                parents.put(smallHead, bigHead);
                // 更新大的size
                sizeMap.put(bigHead, aSize + bSize);
                // 删除小的set在sizeMap中的记录
                sizeMap.remove(smallHead);
            }
        }
        
        /** 获取当前节点们形成的集合数量 */
        public int sets() {
            return sizeMap.size();
        }
    }
    
    /** 并查集实现类--Array */
    public static class UnionFindWithArray {
        /** parents数组: parents[i] = k  -->  表示i的父亲是k */
        private int[] parents;
        /** size[]数组: size[i] = k  -->  表示i如果是代表节点，则表示i所在的集合的size为k */
        private int[] size;
        /** help[]数组: 用于代替HashMap实现方式中findAncestor中的栈，记录路径上的节点，方便更新新的parent节点 */
        private int[] help;
        /** 一共有多少个集合 */
        private int sets;
        
        /** 构造方法(传入节点的数量) */
        public UnionFindWithArray(int N) {
            parents = new int[N];
            size = new int[N];
            help = new int[N];
            // 形成的集合数量
            sets = N;
            for (int i = 0; i < N; i++) {
                // 当前节点对应的父节点就是它自己本身
                parents[i] = i;
                size[i] = 1;
            }
        }
        
        /** 辅助方法--findAncestor()方法 */
        private int findAncestor(int i) {
            // hi变量表示help[]数组中的下标
            int hi = 0;
            // 一直找，直到当前节点的parent就是它自己本身
            while (i != parents[i]) {
                // 入栈
                help[hi++] = i;
                // 往父节点继续寻找
                i = parents[i];
            }
            
            // 元素出栈，将里面存储的元素的父节点直接更新成当前发现的代表节点
            for (hi--; hi >= 0; hi--) {
                parents[help[hi]] = i;
            }
            
            return i;
        }
        
        /** 1、isSameSet(), 查看两个节点node是否在同一个集合中 */
        public boolean isSameSet(int a, int b) {
            return findAncestor(a) == findAncestor(b);
        }
        
        /** 2、union()方法，将节点a和节点b所在的集合进行合并 */
        public void union(int a, int b) {
            // 先找到a和b的代表节点
            int aHead = findAncestor(a);
            int bHead = findAncestor(b);
            
            if (aHead != bHead) {
                // 确定a所在集合的大小和b所在集合的大小
                int aSize = size[aHead];
                int bSize = size[bHead];
                
                // 将小的set的节点挂到大的set的代表节点上
                int bigHead = aSize >= bSize ? aHead : bHead;
                int smallHead = bigHead == aHead ? bHead : aHead;
                
                parents[smallHead] = bigHead;
                size[bigHead] = aSize + bSize;
                sets--;
            }
        }
        
        /** 获取当前节点们组成的集合数量 */
        public int sets() {
            return sets;
        }
    }
}
