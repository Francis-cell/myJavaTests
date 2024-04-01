package com.zmr.LearningFiles.OwnLearning.BasicJava.basicDataStruct.heapStruct;

import java.util.Arrays;

/**
 * @ClassName PriorityQueue
 * @Description 优先队列实现
 * @Author zhumengren
 * @Date 2022/10/16 16:22

 * @Version 1.0
 **/
public class PriorityQueue {
    private int[] array;
    private int size;

    public PriorityQueue() {
        // 初始化队列的长度为32
        array = new int[32];
    }

    /**
     * 扩容
     * */
    private void resize() {
        // 队列容量翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    /**
     * 上浮元素
     */
    public static void upHeap(int[] array) {
        // 首先获取最后一个元素的值
        int childIndex = array.length - 1;
        // 获取最后一个元素的父节点的下标的值
        int parentIndex = (childIndex - 1) / 2;
        // 然后比较childIndex下标和parentIndex下标元素的值
        while (array[childIndex] < array[parentIndex] && parentIndex >= 0) {
            // childIndex位置元素的值和parentIndex位置元素的值进行交换
            int temp = array[childIndex];
            array[childIndex] = array[parentIndex];
            array[parentIndex] = temp;

            // 重新获取childIndex和parentIndex的值
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }


    /**
     * 下沉元素
     * @param array 需要进行处理的数组
     * @param index 需要进行下沉处理的元素的下标
     */
    public static void downHeap(int[] array, int index) {
        // 存储当前节点的值
        int parentIndex = index;
        int temp = array[parentIndex];
        // 获取下沉元素的子节点的下标
        int childIndex = (parentIndex * 2) + 1;
        // 判断当前节点的左子节点和右子节点(如果右子节点存在)的大小关系
        while (childIndex < array.length) {
            // 如果存在右孩子，则定位到右孩子
            if (childIndex + 1 < array.length && array[childIndex + 1] < array[childIndex]) {
                childIndex ++;
            }
            if (temp <= array[childIndex]) {
                break;
            }
            // 否则进行交换操作
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }


    /**
     * 入队操作
     * @param key 插入二叉堆里面的元素的值
     */
    public void enterQueue(int key) {
        // 如果队列的长度超过了最大允许范围，则进行扩容操作
    }

    public static void main(String[] args) {
        int[] a = new int[] {2,7,3,8,1};
        //upHeap(a);
        //System.out.println(Arrays.toString(a));

        downHeap(a, 1);
        System.out.println(Arrays.toString(a));
    }
}
