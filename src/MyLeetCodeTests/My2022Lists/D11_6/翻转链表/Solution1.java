package MyLeetCodeTests.My2022Lists.D11_6.翻转链表;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/6 11:52
 */
public class Solution1 {
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

    // 双链表解法
    public ListNode ReverseList(ListNode head) {
        // 新建一个空的链表
        ListNode newHead = null;
        while (head != null) {
            // 保留将要断开节点的next，用作下一次的head的值
            ListNode tempNode = head.next;
            // 将head与原本的链表断开，然后连接到新链表的最前方
            head.next = newHead;

            newHead = head;
            head = tempNode;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        first.next = second;
        second.next = third;

        Solution1 solution = new Solution1();
        ListNode listNode = solution.ReverseList(first);
        System.out.println(listNode);
    }
}
