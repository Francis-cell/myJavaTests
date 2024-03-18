package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2022Lists.ListNodeTests;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/12/25 11:57
 */
public class MyListNodeTests {
    /** 链表辅助类(单向链表) */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /** 链表辅助类(双向链表) */
    class ListNodeSecond {
        int val;
        ListNode next;
        ListNode prev;
        ListNodeSecond (int val) {
            this.val = val;
        }
    }

    /** 链表中插入节点: 在链表中n0节点之后插入一个节点P */
    void insert(ListNode n0, ListNode P) {
        // 保存n0原本的下一个节点n1
        ListNode n1 = n0.next;
        // n0的next为P
        n0.next = P;
        // P的next为n1
        P.next = n1;
    }

    /** 删除链表中的元素: 删除链表中n0之后的首个节点P */
    void remove(ListNode n0) {
        if (n0.next == null) {
            return;
        }
        // 要删除的节点P
        ListNode P = n0.next;
        // 要删除节点之后的节点n1
        ListNode n1 = P.next;
        // 删除节点P
        n0.next = n1;
    }

    /** 访问链表中索引为index的节点 */
    ListNode access (ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }
        return head;
    }

    /** 在链表中查找首个值为target的节点的下标 */
    int find(ListNode head, int target) {
        int index = 0;
        while (head!= null) {
            if (head.val == target) {
                return index;
            }
            head = head.next;
            index++;
        }
        return  -1;
    }


    public static void main(String[] args) {

    }
}
