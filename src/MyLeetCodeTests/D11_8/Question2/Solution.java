package MyLeetCodeTests.D11_8.Question2;

/**
 * @ClassName Solution
 * @Description K个一组翻转链表
 * @Author zhumengren
 * @Date 2022/11/8 13:12
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


    ///**
    // * k个一组反转链表
    // * @param head
    // * @param k
    // */
    //public ListNode reverseList(ListNode head, int k) {
    //    // TODO
    //}


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
        int k = 3;
        ListNode listNode = solution.reverseList(listNode1, k);
        System.out.println(listNode);
    }
}
