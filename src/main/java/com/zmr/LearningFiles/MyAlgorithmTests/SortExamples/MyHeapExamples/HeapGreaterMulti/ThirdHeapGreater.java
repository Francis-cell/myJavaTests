package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyHeapExamples.HeapGreaterMulti;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName ThirdHeapGreater
 * @Description 手写堆第3遍
 **/
public class ThirdHeapGreater<T> {
    /** 对于基本数据类型的包装 */
    static class InnerClass<T> {
        private T value;
        
        public InnerClass(T obj) {
            value = obj;
        }
    }
    
    /** 定义堆 */
    private ArrayList<InnerClass> heap;
    /** 反向索引表 */
    private HashMap<InnerClass, Integer> indexMap;
    private int heapSize;
    private Comparator<? super InnerClass> comp;
    
    /** 构造方法 */
    public ThirdHeapGreater(Comparator<? super InnerClass> c) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        comp = c;
    }
    
    /** 判断堆是否为空 */
    public boolean isEmpty() {
        return heapSize == 0;
    }
    
    /** 返回堆的大小 */
    public int size() {
        return heapSize;
    }
    
    /** 查看堆中是否存在一个元素(需要借助反向索引表) */
    public boolean contains(InnerClass obj) {
        return indexMap.containsKey(obj);
    }
    
    /** 返回堆顶元素，不删除 */
    public InnerClass peek() {
        return heap.get(0);
    }
    
    /** 堆中插入新元素 */
    public void push(InnerClass obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        // 执行上浮操作
        heapInsert(heapSize);
        heapSize++;
    }
    
    /** 弹出堆顶元素 */
    public InnerClass pop() {
        InnerClass ans = heap.get(0);
        
        // 交换堆中最后一个元素和堆顶元素的位置
        swap(0, heapSize - 1);
        // 维护反向索引表和堆结构中的数值
        indexMap.remove(ans);
        heap.remove(--heapSize);
        // 元素下沉
        heapify(0);
        
        return ans;
    }
    
    /** 删除堆中的某个元素 */
    public void remove(InnerClass obj) {
        // 获取堆中最后一个元素，用于替换当前要删除的元素
        InnerClass replace = heap.get(heapSize - 1);
        // 获取要删除的元素在堆中的index值(通过反向索引表)
        int index = indexMap.get(obj);
        // 维护反向索引表和堆结构
        indexMap.remove(obj);
        heap.remove(--heapSize);
        // 如果要删除的元素是堆中最后一个元素，则直接结束，否则仍然要执行下面的步骤
        if (obj != replace) {
            // 将原本堆被删除元素的位置上设置成原本堆最后的元素
            heap.set(index, replace);
            // 维护反向索引表
            indexMap.put(replace, index);
            // 执行上浮和下沉操作
            resign(replace);
        }
    }
    
    /** 获取堆中所有元素 */
    public List<InnerClass> getAllElements() {
        List<InnerClass> ans = new ArrayList<>();
        for (InnerClass i : heap) {
            ans.add(i);
        }
        return ans;
    }
    
    /** 堆中元素调整 */
    public void resign(InnerClass obj) {
        // 下面两个方法必然会走一个，因为元素必然是走上浮
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }
    
    /** 关键交换swap()方法 */
    private void swap(int i, int j) {
        InnerClass i1 = heap.get(i);
        InnerClass j1 = heap.get(j);
        // 将i1和j1在堆上的位置进行交换
        heap.set(i, j1);
        heap.set(j, i1);
        // 维护到反向索引表中
        indexMap.put(j1, i);
        indexMap.put(i1, j);
    }
    
    /** 关键方法heapInsert()方法 */
    private void heapInsert(int index) {
        // 查看当前元素和父元素的大小关系，如果小于父元素，则进行交换
        // 停止条件：1、当前元素小于等于父元素；2、到达根节点位置
        while (comp.compare(heap.get(index), heap.get((index - 1) >> 1)) < 0) {
            swap(index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }
    
    /** 关键方法heapify()方法 */
    private void heapify(int index) {
        // 左子节点
        int left = index * 2 + 1;
        while (left < heapSize) {
            int best = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(index)) < 0 ? left + 1 : left;
            int minIndex = comp.compare(heap.get(index), heap.get(best)) < 0 ? index : best;
            if (minIndex == best) {
                break;
            }
            
            // 交换元素的位置，并继续向下找
            swap(minIndex, index);
            index = minIndex;
            left = index * 2 + 1;
        }
    }
    
}
