package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.MyLinkedListExamples.basicExamples;

/**
 * @ClassName LinkedListMid
 * @Description 找到链表中点位置
 **/
public class LinkedListMid {
    /** 辅助类 */
    public static class Node {
        public int value;
        public Node next;
        
        public Node (int val) {
            value = val;
        }
    }
    
    
    /** 1、奇数个节点，返回中点位置(使用快慢指针的方式即可) */
    public static Node middleInOddNumLinkedList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 说明链表至少有3个节点
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    /** 2、偶数个节点，返回“上中点”位置(使用快慢指针的方式实现) */
    public static Node firstMiddleInEvenNumLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // 说明这个链表至少有2个节点
        // 1、首先让快指针先走1步
        Node slow = head;
        Node fast = head.next;
        // 2、之后让快指针恢复到2格每步；慢指针恢复到1格每步
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    /** 3、偶数个节点，返回“下中点”位置(使用快慢指针的方式实现) */
    public static Node secondMiddleInEvenNumLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 说明这个链表至少有2个节点
        // 1、首先让快指针和慢指针一样
        Node slow = head.next;
        // 目的是为了能让快指针走到链表的结尾位置，方便结束
        Node fast = head.next;
        // 2、之后fast指针的速度恢复到2个节点每步的速度
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    /** 4、奇数个节点，返回"中点"位置的前一个节点 */
    public static Node midPreInOddNumLinkedList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 1、快指针先走1步
        // 2、慢指针在第二次再开始走
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    /** 5、偶数个节点，返回"上中点"位置的前一个节点 */
    public static Node firstMidPreInEvenNumLinkedList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 1、快指针第一次先走3格，慢指针不动
        // 2、快指针恢复到2格的速度，慢指针开始移动
        Node slow = head;
        Node fast = head.next.next.next;
        while (fast.next != null || fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    /** 6、偶数个节点，返回"下中点"位置的前一个节点 */
    public static Node secondMinPreInEvenNumLinkedList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 1、快指针第一次先走1格，慢指针不动
        // 2、快指针恢复到2格的速度，慢指针开始移动
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null || fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
