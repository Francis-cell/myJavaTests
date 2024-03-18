package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.SortExamples.MyHeapExamples.HeapGreaterMulti;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName FourthHeapGreater
 * @Description 手写堆实现【小根堆】 (注意：如果要支持基础类型，则需要给基础类型包一层实现)
 **/
public class ForthHeapGreater<T> {
    /** 替代原本的Array存储结构，使用ArrayList进行数据的存储 */
    private ArrayList<T> heap;
    /** 反向索引表 */
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    /** 比较器，比较的内容为传入的T类型的对象 */
    private Comparator<? super T> comp;
    
    /** 构造方法 */
    public ForthHeapGreater(Comparator<? super T> c) {
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
    
    /** 查看堆中是否有某个元素，需要借助反向索引表实现 */
    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }
    
    /** 返回堆顶元素 */
    public T peek() {
        return heap.get(0);
    }
    
    /** 堆中元素调整方法 */
    public void resign(T obj) {
        // 下面这两个方法必然会执行一个，因为元素不是上浮就是下沉
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }
     
    /** 堆中添加新元素 */
    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        // 插入数据执行上浮操作
        heapInsert(heapSize++);
    }
    
    /** 弹出堆顶元素 */
    public T pop() {
        // 首先保留堆顶元素的值
        T ans = heap.get(0);
        
        // 交换堆结构中最后一个叶子节点和当前根节点位置的元素
        swap(0, heapSize - 1);
        // 移除反向索引表中维护的ans的记录
        indexMap.remove(ans);
        // 删除堆结构中最后一个叶子节点位置的元素
        heap.remove(--heapSize);
        // 根节点元素执行下沉操作
        heapify(0);
        
        return ans;
    }
    
    /** 删除堆中的某个元素 */
    public void remove(T obj) {
        // 获取到堆结构中最后一个元素节点所在的位置，用于替换当前要删除的元素
        T replace = heap.get(heapSize - 1);
        // 获取到要删除的元素在堆中的位置，借助反向索引表实现
        int index = indexMap.get(obj);
        // 在反向索引表中删除要移除的元素
        indexMap.remove(obj);
        // 将堆中最后一个元素直接删除
        heap.remove(--heapSize);
        // 如果删除的元素是堆中最后的叶子节点，则上面的操作已经完成
        if (obj != replace) {
            // 将原本堆最后的元素放到被删除的元素的位置上
            heap.set(index, replace);
            // 将替换上去的元素维护到反向索引表
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
    
    /** 交换方法swap的实现 */
    private void swap(int i, int j) {
        // 首先获取堆中两个位置i和j的元素
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        // 将o1和o2在堆上的位置进行交换
        heap.set(i, o2);
        heap.set(j, o1);
        // 维护反向索引表
        indexMap.put(o1, j);
        indexMap.put(o2, i);
    }
    
    /** heapInsert实现 */
    private void heapInsert(int index) {
        // 比较元素在堆中和父元素的关系(如果当前的元素的值小于它的父元素的值)
        while (comp.compare(heap.get(index), heap.get((index - 1) >> 1)) < 0) {
            swap(index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }
    
    /** heapify实现 */
    private void heapify(int index) {
        // 左子节点
        int left = (index << 1) | 1;
        // 说明当前的left还在堆中存在
        while (left < heapSize) {
            // 比较左右节点中比较小的那个节点，将它的下标获取出来
            int best = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(left)) < 0 ? left + 1 : left; 
            // 和当前节点的值进行比较，获取较小的那个index的值
            int minIndex = comp.compare(heap.get(index), heap.get(best));
            if (minIndex == index) {
                break;
            }
            swap(minIndex, index);
            index = minIndex;
            // 继续向下查找
            left = index << 1 | 1;
        }
    }
}
 