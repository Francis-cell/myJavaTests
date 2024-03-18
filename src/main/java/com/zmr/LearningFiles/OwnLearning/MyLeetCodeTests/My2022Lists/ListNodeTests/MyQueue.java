package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2022Lists.ListNodeTests;

import java.util.EmptyStackException;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 队列实现
 * @date 2022/12/25 15:51
 */
public class MyQueue {
    /** 辅助ListNode类 */
    class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }

    /**
     * 使用链表实现
     * 规定链表头为队列首部；链表尾为队列尾部
     * 且链表的头部只能删除元素；链表的尾部只能添加元素
     */
    class LinkedListQueue {
        // 声明头结点、尾节点
        private ListNode front, rear;
        // 队列长度初始化为0
        private int queueSize = 0;

        LinkedListQueue() {
            front = null;
            rear = null;
        }

        /** 获取队列的长度 */
        public int size() {
            return queueSize;
        }

        /** 判断队列元素是否为空 */
        public boolean isEmpty() {
            return size() == 0;
        }

        /** 访问队列的头部元素 */
        public int peek() {
            if (queueSize == 0) {
                throw new EmptyStackException();
            }
            return front.val;
        }

        /** 元素入队 */
        public void offer(int val) {
            // 新入队的元素是在队列的尾部的，直接连接到队列尾部即可
            ListNode node = new ListNode(val);
            if (front == null) {
                // 此时头结点和尾节点为同一个节点，即新插入的节点
                front = node;
                rear = node;
            } else {
                // 直接将新的节点连接在队列尾部即可
                rear.next = node;
                // 尾节点向后移动一位
                rear = rear.next;
            }
            // 队列的长度增加
            queueSize++;
        }

        /** 元素出队 */
        public int poll() {
            // 元素出队，必然是队列头部的元素
            int tempVal = peek();
            // 删除头结点
            front = front.next;
            queueSize--;
            return tempVal;
        }
    }

    /**
     * 基于数组的实现
     * 删除首部元素的时间复杂度为O(n)，故而使用两个指针front、rear分别记录队首和队尾的索引位置
     * rear - x - x - x - front
     * 入队时：front向后移动一位，出队时rear向后移动一位
     * 采用环形数组，解决元素到达尾部之后无法继续移动的问题
     * 需要做调整的方法：1、获取长度size();2、入队offer();3、出队poll();
     */
    class ArrayQueue {
        /** 用于存储队列元素的数组 */
        private int[] nums;
        /** 头指针，指向队首 */
        private int front = 0;
        /** 尾指针，指向队尾+1 */
        private int rear = 0;

        public ArrayQueue(int capacity) {
            // 初始化数组
            nums = new int[capacity];
        }

        /** 获取队列的容量 */
        public int capacity() {
            return nums.length;
        }

        /** 获取队列的长度 */
        public int size() {
            int capacity = capacity();
            // 由于数组被看成环形，可能rear < front，因此需要取余数
            return (capacity + rear - front) % capacity;
        }

        /** 判断队列是否为空 */
        public boolean isEmpty() {
            return rear - front == 0;
        }

        /** 访问队列的首元素 */
        public int peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return nums[front];
        }

        /** 入队 */
        public void offer(int val) {
            if (size() == capacity()) {
                System.out.println("队列已满！");
                return;
            }
            // 尾节点后添加val
            nums[rear] = val;
            // 尾指针向后移动一位，超过capacity的值之后调整到数组头部
            rear = (rear + 1) % capacity();
        }

        /** 出队 */
        public int poll() {
            // 出队出的是头部的元素
            int tempVal = peek();
            front = (front + 1) % capacity();
            return tempVal;
        }
    }
}
