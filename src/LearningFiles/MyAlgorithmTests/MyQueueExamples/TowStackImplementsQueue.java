package LearningFiles.MyAlgorithmTests.MyQueueExamples;

import java.util.Stack;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 双栈结构实现队列
 * @date 2023/2/1 22:08
 */
public class TowStackImplementsQueue {
    /** 双栈实现链表 */
    public static class TowStackQueue {
        // 声明一个push栈一个pop栈
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public TowStackQueue() {
            pushStack = new Stack<Integer>();
            popStack = new Stack<Integer>();
        }

        /** pushStack向popStack中转移数据 */
        private void pushToPop() {
            if (popStack.isEmpty()) {
                while (!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }


        /** 实现的队列的add操作 */
        public void add(int val) {
            pushStack.push(val);
            // 入pushStack栈的同时检查popStack栈中是否为空，如果为空，可以转移数据，节省时间
            pushToPop();
        }

        /** 实现队列的poll操作 */
        public int poll() {
            if (popStack.empty() && pushStack.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            // 检查popStack栈中是否支持入栈操作
            pushToPop();
            // 同时返回pushStack的栈顶元素作为返回值(弹出)
            return pushStack.pop();
        }

        /** 实现队列的peek操作 */
        public int peek() {
            if (popStack.empty() && pushStack.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            // 检查popStack栈中是否支持入栈操作
            pushToPop();
            // 同时返回pushStack的栈顶元素作为返回值(弹出)
            return pushStack.peek();
        }
    }
}
