package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyQueueExamples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 使用两个队列实现栈结构
 * @date 2023/2/2 18:56
 */
public class TowQueueImplementStack {
    public static class TwoQueueStack<T> {
        // 声明两个队列，分别作为存放数据、弹出数据的结构
        public Queue<T> queue;
        // 辅助队列
        public Queue<T> help;
        
        public TwoQueueStack() {
            queue = new LinkedList<T>();
            help = new LinkedList<T>();
        }
        
        /** 元素入栈 */
        public void push(T value) {
            // offer方法：将指定的元素链接到链表的末尾位置上
            queue.offer(value);
        }
        
        /** 元素出栈 */
        public T poll() {
            // 推出元素的要求是，队列中只剩一个元素的时候推出元素
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            
            // 将队列queue中最后一个元素弹出，作为出栈的元素
            T ans = queue.poll();
            // 交换queue和help指向的链表的地址
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            
            return ans;
        }
        
        /** 访问栈顶元素 */
        public T peek() {
            // 推出元素的要求是，队列中只剩一个元素的时候推出元素
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            // 将队列queue中最后一个元素弹出，作为栈顶的元素
            T ans = queue.poll();
            help.offer(ans);
            // 交换queue和help指向的链表的地址
            Queue<T> temp = queue;
            queue = help;
            help = temp;

            return ans;
        }
        
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    /** 测试方法--对数器 */
    public static void main(String[] args) {
        System.out.println("测试开始！！！");
        // 声明自己的栈结构
        TwoQueueStack<Integer> myStack = new TwoQueueStack<>();
        // 声明原本的栈结构“
        Stack<Integer> test = new Stack<>();
        
        int testTime = 100000;
        int max = 10000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("出错了！--栈空判断");
                }
                // push数据
                int num = (int)(Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                // 如果生成的随机数<0.25，则执行push操作
                if (Math.random() < 0.25) {
                    int num = (int)(Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } 
                // 如果 0.25 < 生成的随机数 < 0.5，则测试peek操作
                else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("出错了！--访问栈顶元素");
                    }
                }
                // 如果 0.5 < 生成的随机数 < 0.75，则测试pop操作
                else if (Math.random() < 0.75) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("出错了！--栈顶元素出栈");
                    }
                }
                // 其余随机数，测试 栈空判断 操作
                else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("出错了！--栈空判断2");
                    }
                }
            }
        }
        System.out.println("测试结束！！！");
    }
}
