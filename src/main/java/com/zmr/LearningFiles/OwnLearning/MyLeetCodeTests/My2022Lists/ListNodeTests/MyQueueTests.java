package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2022Lists.ListNodeTests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description Java已有的队列使用
 * @date 2022/12/25 15:38
 */
public class MyQueueTests {
    public static void main(String[] args) {
        // 初始化队列
        Queue<Integer> queue = new LinkedList<>();

        // 元素入队
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // 访问首元素
        int peek = queue.peek();

        // 元素出队
        int poll = queue.poll();

        // 获取队列的长度
        int size = queue.size();

        // 判断队列是否为空
        boolean isEmpty = queue.isEmpty();

        System.out.println("queue的值为：" + Arrays.toString(queue.toArray()));
        System.out.println("首元素:" + peek);
        System.out.println("出队元素:" + poll);
        System.out.println("队列的长度：" + size);
        System.out.println("队列是否为空：" + isEmpty);
    }
}
