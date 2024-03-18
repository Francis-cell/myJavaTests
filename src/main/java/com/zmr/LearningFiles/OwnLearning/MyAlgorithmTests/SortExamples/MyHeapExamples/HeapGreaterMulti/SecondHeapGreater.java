package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.SortExamples.MyHeapExamples.HeapGreaterMulti;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName SecondHeapGreater
 * @Description 手写堆(第二次写) [注意：如果要支持基础类型，需要在外面包一层]
 * @Version 1.0
 **/
public class SecondHeapGreater<T> {
    private ArrayList<T> heap;
    /** 建立反向索引表 */
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    /** 比较器，比较的内容为T类型的对象 */
    private Comparator<? super T> comp;
    
    public SecondHeapGreater(Comparator<? super T> c) {
        heap = new ArrayList<>();
        heapSize = 0;
        indexMap = new HashMap<>();
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
    
    /** 查看堆中是否存在一个元素 */
    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }
    
    /** 添加新元素 */
    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        // 插入数据heapInsert()
        heapInsert(heapSize++);
    }
    
    /** 返回堆顶元素，不删除 */
    public T peek() {
        return heap.get(0);
    }
    
    /** 弹出堆顶元素 */
    public T pop() {
        T ans = heap.get(0);
        
        // 交换堆最后元素和堆顶元素位置
        swap(0, heapSize - 1);
        // 移除反向索引表删除的元素的记录
        indexMap.remove(ans);
        // 删除堆中最后一个元素
        heap.remove(--heapSize);
        // 元素下沉
        heapify(0);
        
        return ans;
    }
    
    /** 删除堆中某个元素 */
    public void remove(T obj) {
        // 先获取到堆中最后一个元素的值
        T replace = heap.get(heapSize - 1);
        // 获取要删除的元素在堆结构中的下标index（借助反向索引表）
        int index = indexMap.get(obj);
        // 在反向索引表中删除要删除的元素的记录
        indexMap.remove(obj);
        // 将堆中最后一个元素直接进行删除
        heap.remove(--heapSize);
        // 如果删除的元素是堆中最后的元素，则上面的操作已经足够了
        if (obj != replace) {
            // 将原本堆最后的元素放到将要被删除的位置上
            heap.set(index, replace);
            // 将替换上去的元素维护到反向索引表
            indexMap.put(replace, index);
            // 执行上浮或者下沉操作
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
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }
    
    /** 交换方法swap()方法实现 */
    private void swap(int i, int j) {
        // 首先获取i和j两个位置元素的对象
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        // 将o1和o2在堆上的位置进行互换
        heap.set(i, o2);
        heap.set(j, o1);
        // 将o1和o2在反向索引表中的位置进行维护
        indexMap.put(o1, j);
        indexMap.put(o2, i);
    }
    
    /** 关键方法heapInsert()方法实现 */
    private void heapInsert(int index) {
        // 判断当前元素和父节点元素的大小关系，如果小于父元素，则交换
        // 停止条件：1、当前元素不比父元素大；2、当前元素到了堆顶heap.get(0)位置
        while(comp.compare(heap.get(index), heap.get((index -1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    
    /** 关键方法heapify()方法 */
    private void heapify(int index) {
        // 找到当前节点的左子节点
        int left = index * 2 + 1;
        while (left < heapSize) {
            int best = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(index)) < 0 ? left + 1 : left;
            int minIndex = comp.compare(heap.get(best), heap.get(index)) < 0 ? best : index;
            if (minIndex == index) {
                break;
            }
            // 交换最小值和当前index位置的元素
            swap(minIndex, index);
            index = minIndex;
            // 继续向下查找
            index = index * 2 + 1;
        }
    }
}
