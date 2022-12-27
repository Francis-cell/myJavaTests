package MyLeetCodeTests.D12_25.ListNodeTests;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 自定义栈类
 * @date 2022/12/25 15:06
 */
public class MyStack {
    /** 辅助类-链表元素节点 */
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 基于链表的实现
     * 优点：受益于链表的离散存储，链表的扩容更加灵活，删除的元素也会被系统自动回收
     * 缺点：无法像数组一样高效的随机访问；链表节点需要存储指针，导致单个元素占用空间更大
     */
    class LinkedListStack {
        // 声明栈顶节点元素
        private ListNode stackPeek;
        // 声明栈的长度
        private int stackSize = 0;

        public LinkedListStack() {
            stackPeek = null;
        }

        /** 获取栈的长度 */
        public int size() {
            return stackSize;
        }

        /** 判断栈是否为空 */
        public boolean isEmpty() {
            if (stackSize == 0) {
                return true;
            }
            return false;
        }

        /** 入栈 */
        public void push(int val) {
            // 新建一个节点node，将这个node节点插入到列表的头部
            ListNode node = new ListNode(val);
            node.next = stackPeek;
            stackPeek = node;
            // 栈容量增加
            stackSize++;
        }

        /** 出栈 */
        public int pop() {
            // 访问栈顶元素
            int tempVal = peek();
            // 将栈顶元素向后移动一位
            stackPeek = stackPeek.next;
            // 将栈的空间-1
            stackSize--;
            return tempVal;
        }

        /** 访问栈顶元素 */
        public int peek() {
            if (stackSize == 0) {
                throw new EmptyStackException();
            }
            return stackPeek.val;
        }
    }

    /**
     * 基于数组的实现
     * 优点：支持随机访问
     * 缺点：造成空间浪费，因为列表的容量 >= 元素数量
     */
    class ArrayStack {
        /** 声明一个动态扩容的数组ArrayList */
        private ArrayList<Integer> stack;

        public ArrayStack() {
            // 初始化列表（动态数组）
            stack = new ArrayList<Integer>();
        }

        /** 获取栈的长度 */
        public int size() {
            return stack.size();
        }

        /** 判断栈中是否为空 */
        public boolean isEmpty() {
            if (size() == 0) {
                return true;
            }
            return false;
        }

        /** 入栈 */
        public void push(int val) {
            stack.add(val);
        }

        /** 出栈 */
        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return stack.remove(size()-1);
        }

        /** 访问栈顶元素 */
        public int peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return stack.get(size() - 1);
        }
    }
}
