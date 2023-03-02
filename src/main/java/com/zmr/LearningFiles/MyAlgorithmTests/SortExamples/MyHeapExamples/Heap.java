package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyHeapExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/2/16 23:28
 * @description 堆
 */
public class Heap {
    /** 最大堆 */
    public static class MaxHeap {
        // 存储堆的数组
        private int[] heap;
        // 初始化时堆空间的大小
        private final int limit;
        // 当前堆使用的数组的空间大小
        private int heapSize;
        
        public MaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            // 初始化时，当前堆占用的数组空间为0
            heapSize = 0;
        }
        
        /** 判断堆是否为空 */
        public boolean isEmpty() {
            return heapSize == 0;
        }
        
        /** 判断堆是否是满的 */
        public boolean isFull() {
            return heapSize == limit;
        }
        
        /** 堆中推入数据的方法 */
        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("堆满了！");
            }
            // 将当前的value插入到heap中的最后一个位置，原本堆的最后一个下标为heapSize - 1，所以下一个插入元素的下标为heapSize
            heap[heapSize] = value;
            // 插入数据
            heapInsert(heap, heapSize++);
        }
        
        /** 
         * 大根堆中，删掉最大的元素，其余的元素仍然保持大根堆形式 
         * 
         * 说明：
         * 1、将大根堆中index = 0位置元素的值存储起来(作为最终结果)
         * 2、将大根堆index = 0位置元素和大根堆中最后一个元素进行交换
         * 3、调用heapify()方法进行下沉操作，将根重新调整成大根堆
         */
        public int pop() {
            // 当前大根堆index=0位置上的元素的值是整个堆中最大的值
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapfiy(heap, 0, heapSize);
            return ans;
        }
        
        
        /** 数据交换swap方法 */
        public static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        
        /** 
         * 堆中插入数据heapInsert()方法 
         * 
         * 说明：
         * 堆中新插入的元素，初始位置在index上(依次向上移动，和父节点判断大小关系)
         * 停止条件：1、移动到arr[0]位置；2、插入元素的值 <= 父节点的值，则结束操作；
         */
        public static void heapInsert(int[] arr, int index) {
            // 这种条件同时处理了上面的两种结束的情况
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                // 当前的index的值和原本它的父节点的位置进行交换
                index = (index - 1) / 2;
            }
        }
        
        
        /** 
         * 堆中元素在堆中下沉heapify()方法
         * 
         * 说明：
         * 从当前节点index位置向下看
         * 从左右子节点中找到较大的那个，和这个值进行比较，如果小于那个值，则下沉
         * 停止条件：1、较大的孩子的值都不大于当前的值；2、没有孩子节点了；
         */
        public static void heapfiy(int[] arr, int index, int heapSize) {
            // 先找到左孩子节点（如果左孩子都小于heapSize堆数组范围，则右孩子必然也不在里面了）
            int left = index * 2 + 1;
            // 有左孩子
            while (left < heapSize) {
                // 把较大的孩子的下标交给largest变量
                // left + 1 < heapSize: 说明右孩子也在堆的有效范围内
                // arr[left + 1] > arr[left]: 说明堆中当前index的右孩子的值 > 左孩子的值
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                int maxIndex = arr[largest] > arr[index] ? largest : index;
                if (maxIndex == index) {
                    break;
                }
                // index和较大孩子进行互换
                swap(arr, index, maxIndex);
                index = largest;
                // 继续向下排查
                left = index * 2 + 1;
            }
        }
    }
}
