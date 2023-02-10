package main.java.com.zmr.MyLeetCodeTests.My2022Lists.D11_6.翻转链表选中部分;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/6 16:55
 */
public class Solutions {
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
    private static ListNode ReverseList(ListNode head) {
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


    public ListNode reverseBetween (ListNode head, int m, int n) {
        // 设置虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 走left-1步到left的前一个节点
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }

        // 走right-1步到right的前一个节点
        ListNode rightNode = pre;
        for (int i = 0; i < n-m+1; i++) {
            rightNode = rightNode.next;
        }

        // 截取出子链表
        ListNode reverseNode = pre.next;
        ListNode rightCur = rightNode.next;

        // 切断连接
        pre.next = null;
        rightNode.next = null;


        // 翻转需要调整的链表
        Solutions.ReverseList(reverseNode);

        // 拼接原来的链表
        pre.next = rightNode;
        reverseNode.next = rightCur;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(3);
        //ListNode second = new ListNode(1);
        //ListNode third = new ListNode(3);
        //ListNode fourth = new ListNode(4);
        //ListNode fifth = new ListNode(1);
        //ListNode sixth = new ListNode(4);
        //ListNode seventh = new ListNode(-1);
        //first.next = second;
        //second.next = third;
        //third.next = fourth;
        //fourth.next = fifth;
        //fifth.next = sixth;
        //sixth.next = seventh;

        first.next = null;

        int m = 1;
        int n = 1;

        Solutions solution = new Solutions();
        System.out.println(solution.reverseBetween(first, m, n));
    }
}
