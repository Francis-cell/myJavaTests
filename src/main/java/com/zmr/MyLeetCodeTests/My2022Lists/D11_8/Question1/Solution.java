package main.java.com.zmr.MyLeetCodeTests.My2022Lists.D11_8.Question1;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhumengren
 * @Date 2022/11/8 9:09
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class Solution {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
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

    /***
     * 描述.md：颠倒链表偶数位和奇数位的元素，不使用交换值的方式实现
     * @param head
     */
    public ListNode reverseList(ListNode head) {
        // 使用新建链表的方式实现
        // 1、创建新链表(创建一个虚拟节点)
        ListNode newList = new ListNode(-1);
        ListNode lastList = newList;
        // 2、遍历并拆解原本的链表
        while (head!=null) {
            // 第一个节点
            ListNode firstNode = head;
            head = head.next;
            // 断开第一个节点的后续连接
            firstNode.next = null;
            // 第二个节点
            ListNode secondNode = null;
            if (head!=null) {
                secondNode = head;
                head = head.next;
                // 断开第二个节点的后续连接
                secondNode.next = null;
            }

            // 执行新链表的拼接
            if (secondNode!=null) {
                // 当第二个节点不为null，说明第一个节点也必不为null
                newList.next = secondNode;
                newList = newList.next;
                newList.next = firstNode;
                newList = newList.next;
            } else {
                // 如果第一个节点不为null，而第二个节点为null，则说明第一个节点就是最后一个节点了
                newList.next = firstNode;
                newList = newList.next;
                newList.next = null;
                return lastList.next;
            }
        }
        // 第一个节点为null，说明已经到了最后一个节点，可以结束节点了
        newList.next = null;
        return lastList.next;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = null;

        Solution solution = new Solution();
        ListNode listNode = solution.reverseList(listNode1);
        System.out.println(listNode);
    }
}
