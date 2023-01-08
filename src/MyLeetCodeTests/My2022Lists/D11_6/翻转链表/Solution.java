package MyLeetCodeTests.My2022Lists.D11_6.翻转链表;

import java.util.Stack;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/6 11:21
 */
public class Solution {
    /**先声明一个ListNode类(单向链表)*/
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // 将链表中的所有元素全部放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }

        // 出栈
        ListNode node = stack.pop();
        ListNode dummy = node;
        // 栈中节点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }

        // 最后一个节点是原本链表的第一个节点
        node.next = null;
        return dummy;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        first.next = second;
        second.next = third;

        Solution solution = new Solution();
        ListNode listNode = solution.ReverseList(first);
        System.out.println(listNode);
    }
}
