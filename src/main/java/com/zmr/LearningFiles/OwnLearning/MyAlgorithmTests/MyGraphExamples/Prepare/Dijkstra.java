package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyGraphExamples.Prepare;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/18 12:09
 * @description 最小生成树-Dijkstra(贪心方式)
 * 
 * Dijkstra算法
 * ①、Dijkstra算法必须指定一个源点
 * ②、生成一个源点到各个点的最小距离表，一开始只有一条记录，即原点到自己的最小距离为0，源点到其他所有点的最小距离都为正无穷大
 * ③、从距离表中拿出没拿过记录里的最小记录，通过这个点发出的边，更新源点到各个点的最小距离表，不断重复这一步
 * ④、源点到所有的点记录如果都被拿过一遍，过程停止，最小距离表得到了
 * 
 * 说明：Dijkstra算法(不支持带环[走过环之后，路径是负数的图], 因为这样就成永动机了)的图
 */
public class Dijkstra {
    /** 1、Dijkstra算法的第一种实现(比较笨的方法) */
    public static HashMap<Node, Integer> dijkstra01(Node from) {
        // 创建distanceMap
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        // 以当前节点开始建立的表格，所以当前节点距离自己设置为0
        distanceMap.put(from, 0);
        
        // 已经被选中的节点(已经加入到最小生成树中的节点)
        HashSet<Node> selectedNodes = new HashSet<>();
        // 找到下一个经过最小边抵达的节点
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        
        while (minNode != null) {
            // 1、找到从 原始点 到 minNode(跳转点)的最小距离distance
            int distance = distanceMap.get(minNode);
            // 2、新加入一个节点，更新distanceMap
            // 解锁当前节点minNode所有的to中的节点
            // 同时如果这些节点之前已经更新到了distanceMap中则查看是否能更新最短距离
            // 反之直接更新进去
            for (Edge edge: minNode.edges) {
                Node toNode = edge.to;
                // 说明前面有节点没有抵达过这个节点当前节点
                if (!distanceMap.containsKey(toNode)) {
                    // 直接将距离更新进去即可
                    // (distance-->从起始点到上一个点距离, edge.weight-->代表上一个点到当前节点的距离)
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    // 说明之前distanceMap中已经存在了这个节点了，故而这里就要看能否更新这个距离值了
                    distanceMap.put(toNode, Math.min(distance + edge.weight, distanceMap.get(toNode)));
                }
            }
            
            // 3、将当前节点添加到已经被选中的节点中去
            selectedNodes.add(minNode);
            // 4、继续寻找下一个这样的节点
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }
    
    /** 
     * 辅助方法： 
     * 说明：在还没有被选中的node中找到最小的距离的节点
     * @param distanceMap 目前已经生成的距离列表
     * @param touchedNodes 已经被选中的节点们
     */
    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        // 遍历距离列表中所有的节点，如果节点没有加入到被选中节点的列表中
        // 且这个节点的边上有更小的边的值，则将minNode和minDistance进行更新
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            // 获取node
            Node node = entry.getKey();
            // 获取distance
            int distance = entry.getValue();
            
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
    
    
    /** 2、手写堆方式辅助实现 */
    public static HashMap<Node, Integer> dijkstra02(Node from, int size) {
        // 新建 node-distance 表格
        NodeHeap nodeHeap = new NodeHeap(size);
        // 将起始点维护表中去
        nodeHeap.addOrUpdateOrIgnore(from, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        
        // 堆中元素没有清除完(说明还有节点没有加入到最小生成树中)
        while (!nodeHeap.isEmpty()) {
            // 弹出堆顶元素--最小元素
            NodeRecord record = nodeHeap.pop();
            // 获取当前节点
            Node cur = record.node;
            // 获取从源节点到这个节点的距离
            int distance = record.distance;
            // 遍历当前节点的edges们，更新维护 node-distance 表格
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            
            result.put(cur, distance);
        }
        return result;
    }
    
    /** 辅助类 */
    public static class NodeRecord {
        public Node node;
        public int distance;
        
        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    
    /** 手写堆实现 */
    public static class NodeHeap {
        /** 堆存储结构 */
        private Node[] nodes;
        /** 反向索引表：(key, value) -- (node, 堆中node的位置) */
        private HashMap<Node, Integer> heapIndexMap;
        /** distance表：(key, value) -- (node, 从源节点到这个节点之间的距离) */
        private HashMap<Node, Integer> distanceMap;
        /** 堆上有多少节点 */
        private int size;
        
        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            size = 0;
        }
        
        /** 判断当前堆中是否没有存储节点 */
        public boolean isEmpty() {
            return size == 0;
        }
        
        /** swap()方法，交换index1和index2上的元素 */
        private void swap(int indexA, int indexB) {
            // 更新反向索引表
            heapIndexMap.put(nodes[indexA], indexB);
            heapIndexMap.put(nodes[indexB], indexA);
            
            // 临时存储indexA位置上的元素
            Node tmp = nodes[indexA];
            nodes[indexA] = nodes[indexB];
            nodes[indexB] = tmp;
        }
        
        
        /** heapInsert方法，往堆中插入一条数据 */
        private void heapInsert(int index) {
            // 当前元素的下标为index，则它的父节点的下标为 (index - 1) / 2
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                // 因为是小根堆的实现，所以如果当前位置元素的值 < 它的父元素的值，那么就进行交换
                swap(index, (index - 1) / 2);
                // 继续向上查看是否能进行交换
                index = (index - 1) / 2;
            }
        }
        
        /** heapify()方法 */
        private void heapify (int index, int size) {
            // 获取当前元素位置的左孩子下标
            int left = index * 2 + 1;
            while (left < size) {
                // 找到左右孩子中较小的孩子节点
                int small = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left]) 
                        ? left + 1 
                        : left;
                int smallIndex = distanceMap.get(nodes[small]) < distanceMap.get(nodes[index]) ? small : index;
                
                if (smallIndex == index) {
                    break;
                }
                
                // 交换最小的下标元素和当前的元素，然后继续向下交换
                swap(smallIndex, index);
                index = smallIndex;
                left = index * 2 + 1;
            }
        }
        
        
        /** 查看当前节点是否已经被结算过，或者目前还在堆中存在(借助反向索引表) */
        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }
        
        /** 查看当前的元素是否在堆中存在 */
        private boolean inHeap(Node node) {
            // 首先这个元素必须先在反向索引表中存在；反向索引表中记录的值不为-1
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }
        
        /** pop()方法，弹出最小元素 */
        public NodeRecord pop() {
            // 获取堆顶元素以及在反向索引表中的距离
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            // 交换堆顶和堆最后的元素
            swap(0, size - 1);
            // 更新反向索引表(将被弹出的元素放到原本堆的末尾，并将元素的值置为-1，表示已经弹出)
            heapIndexMap.put(nodes[size - 1], -1);
            // 清除掉被弹出元素在堆中的记录
            nodes[size - 1] = null;
            // 对堆顶元素执行heapify()元素下沉方法
            heapify(0, --size);
            return nodeRecord;
        }
        
        /** 
         * 关键方法--addOrUpdateOrIgnore()
         * 说明：有一个点叫node，现在发现了一个从源节点出发到达node的距离为distance
         * 判断要不要更新，如果需要更新的话，就更新
         * 
         * @param node 当前要进行操作的节点
         * @param distance 源节点到要更新的节点的距离            
         */
        public void addOrUpdateOrIgnore(Node node, int distance) {
            // 1、如果当前节点在堆中，则进行更新
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                // 元素上浮(因为元素的distance只有在变小的时候才会执行这个方法)
                heapInsert(heapIndexMap.get(node));
            }
            // 2、如果当前节点不在堆中，则插入节点
            // 如果没有被处理过，即经过isEntered()处理之后的值为false
            if (!isEntered(node)) {
                // 将当前元素插入到堆中
                nodes[size] = node;
                // 更新反向索引表
                heapIndexMap.put(node, size);
                // 更新距离表
                distanceMap.put(node, distance);
                // 将最后一个元素进执行上浮操作
                heapInsert(size++);
            }
        }
    }
}
