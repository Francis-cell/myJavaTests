package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.SortExamples.MyHeapExamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/2/20 21:22
 * @description 手写堆实现 (注意：如果要支持基础类型，则需要给基础类型包一层实现)
 */
public class HeapGreater<T> {
    /** 替代原本的堆存储结构[数组]；使用ArrayList存储堆内数据 */
    private ArrayList<T> heap;
    /** 反向索引表(实际上就是一个hashMap，存储了对应堆数据的索引) 
     * 原本堆heap中存储的数据：[a, b, c]
     * 反向索引表中存储的数据：{ a: 0, b: 1, c: 2 }
     */
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    /** 比较器，比较的内容为传入的T类型的对象 */
    private Comparator<? super T> comp;
    
    /** 构造方法 */
    public HeapGreater(Comparator<? super T> c) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        // 比较器初始化
        comp = c;
    }
    
    
    /** 判断堆中是否为空的 */
    public boolean isEmpty() {
        return heapSize == 0;
    }
    
    /** 返回堆的大小 */
    public int size() {
        return heapSize;
    }
    
    /** 查看堆中是否存在一个元素(需要借助反向索引表，Java的PriorityQueue()没有实现) */
    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }
    
    /** 返回堆顶元素，不删除方式返回 */
    public T peek() {
        return heap.get(0);
    }
    
    /** 堆中添加新元素 */
    public void push(T obj) 
    {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        // 插入数据heapInsert()
        heapInsert(heapSize++);
    }
    
    /** 弹出堆顶的元素 */
    public T pop() {
        T ans  = heap.get(0);
        
        // 交换堆结构中最后一个叶子节点和根节点的位置
        swap(0, heapSize - 1);
        // 移除反向索引表中ans的记录
        indexMap.remove(ans);
        // 删除堆结构中最后一个叶子节点位置的元素
        heap.remove(--heapSize);
        // 元素下沉
        heapify(0);
        
        return ans;
    }
    
    /** 删除堆中的某个元素 */
    public void remove(T obj) {
        // 获取到堆结构中最后一个叶子节点所在的元素，用作替换当前要删除的元素的节点
        T replace = heap.get(heapSize - 1);
        // 获取到要删除的元素在堆中的index值(通过反向索引表indexMap可以轻松获得)
        int index = indexMap.get(obj);
        // 在反向索引表中移除要删除的元素
        indexMap.remove(obj);
        // 将堆中最后一个元素直接删除
        heap.remove(--heapSize);
        // 如果删除的元素是堆中最后的叶子节点，则上面操作已经完成
        if (obj != replace) {
            // 将原本堆最后的元素放到被删除元素的位置上
            heap.set(index, replace);
            // 将替换上去的元素维护到反向索引表中
            indexMap.put(replace, index);
            // 执行上浮和下沉操作
            resign(replace);
        }
    }
    
    /** 获取堆中所有元素 */
    public List<T> getAllElements() {
        List<T> ans = new ArrayList<>();
        for (T c : heap) {
            ans.add(c);
        }
        return ans;
    }
    
    
    /** 堆中元素调整 */
    public void resign(T obj) {
        // 下面的这两个方法必然会执行其中的一个，因为元素不是上浮就是下沉
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }
    
    
    /** 交换方法swap实现 */
    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        // 将o1和o2在堆上的位置进行交换
        heap.set(i, o2);
        heap.set(j, o1);
        // 将o1和o2在反向索引表中的位置进行交换
        indexMap.put(o1, j);
        indexMap.put(o2, i);
    }
    
    /** heapInsert实现 */
    private void heapInsert(int index) {
        // 使用比较器比较堆中Index位置和它的父节点的位置元素的大小，如果小则进行交换
        while (comp.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    
    /** heapify实现 */
    private void heapify(int index) {
        // 左子节点
        int left = index * 2 + 1;
        while (left < heapSize) {
            int best = left + 1 < heapSize && comp.compare(heap.get(left), heap.get(left + 1)) > 0 ? left + 1 : left;  
            int minIndex = comp.compare(heap.get(index), heap.get(best)) < 0 ? index : best;
            if (minIndex == index) {
                break;
            }
            swap(minIndex, index);
            index = minIndex;
            // 继续向下查找
            left = index * 2 + 1;
        }
    }
}
