package com.zmr.LearningFiles.MyAlgorithmTests.MyLinkedListExamples.hardExamples;

import java.util.HashSet;

/**
 * @ClassName FindFirstIntersectNode
 * @Description 两链表（可能有环、可能无环），找两个链表第一个相交的点
 * 三种情况：
 * 1、链表1和链表2均无环，则调用下面的noLoop()方法
 * 2、链表1有环，链表2无环，则两者必然不相交
 * 3、链表1和链表2均有环，则调用下面的bothLoop()方法
 **/
public class FindFirstIntersectNode {
    /** 辅助内部类 */
    static class Node {
        private int value;
        private Node next;
        
        public Node (int val) {
            this.value = val;
        }
    }
    
    /** 容器解法 HashSet */
    public static Node getFirstIntersectNodeByContainer(Node head1, Node head2) {
        // 创建一个容器，遍历第一个链表
        HashSet<Node> firstHashSet = new HashSet<>();
        while (head1 != null) {
            firstHashSet.add(head1);
            head1 = head1.next;
        }
        
        // 遍历第二个链表，如果链表中有节点的值在firstHashSet中，则返回那个节点
        while (head2 != null) {
            if (firstHashSet.contains(head2)) {
               return head2; 
            }
            head2 = head2.next;
        }
        return null;
    }
    
    
    /** 非容器解法（空间复杂度O(1)） */
    
    /** 辅助方法，寻找一个链表的入环节点（如果有入环节点，返回入环节点，反之返回null） */
    public static Node getLoopNode (Node head) {
        // 这里保证传入的链表不为空，且快慢指针可以使用
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // 定义快慢指针(刚开始的时候，快指针一次走2格，慢指针一次走1格)
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            // 说明无环，没有环的情况下直接返回null即可
            if(fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // 快慢指针首次相遇
        // 快指针回到head初始位置，且快指针步长修改为1
        // 慢指针位置不动，步长不动
        fast = head;
        // 当快慢指针再次相遇，那个节点就是链表的入环节点
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    /** 
     * 当两个链表都无环的情况下处理
     * 1、当end1 == end2，说明两者有相交点(此时长链表先走多出的那些节点，然后和短链表一块儿走，
     * 两者首次相遇的节点就是两个链表的相交节点)
     * 2、当end1 != end2，则两者必然不会相交
     */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 声明两个指针，分别指向链表1和链表2的头节点
        Node cur1 = head1;
        Node cur2 = head2;
        // 这里的n比较巧妙，遍历链表1的过程中n++，遍历链表2的过程中n--
        // 如果最后n为正值，则链表1为长链表；如果最后n为负值，则链表2为长链表
        // 最后对n取绝对值，就是长链表比短链表长出来的长度
        int n = 0;
        // 遍历链表1
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        // 遍历链表2
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        // 这里巧妙的利用了cur1和cur2最终为链表1和链表2的最终节点，可以判断出两个链表的end节点是否相同
        if (cur1 != cur2) {
            return null;
        }
        
        // 谁长，谁的头变成cur1
        cur1 = n > 0 ? head1 : head2;
        // 谁短，谁的头变成cur2
        cur2 = cur1 == head1 ? head2 : head1;
        // 长联表比短链表长出的长度
        n = Math.abs(n);
        
        // 先将长链表长出的长度走完
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        
        // 然后两个链表同时开始走，直到相遇，则返回相遇时的那个节点
        // 即为两链表相交节点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        
        return cur1;
    }
    
    
    /** 
     * 当两个链表都有环的情况下
     * 1、两个链表相交，相交于无环部分，但是相交后有环出现
     * 2、两者不相交，且都有环存在
     * 3、两者相交与环的部分
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        // 声明两个指针，分别指向两个链表的头部节点
        Node cur1 = null;
        Node cur2 = null;
        // 这种情况就是上面的第一种情况，两链表相交，且相交于非环部分
        if (loop1 == loop2) {
            // 解法类似noLoop()部分的解法
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            // 将noLoop()中的null(最终节点)换成这里的loop1入环节点
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            // 长链表
            cur1 = n > 0 ? head1 : head2;
            // 短链表
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            // 先把长链表多出来的部分去掉
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            
            // 然后长链表和短链表头指针都移动，直到相遇
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            
            return cur1;
        }
        // 否则就是两个链表的入环节点不一样
        else {
            // 让链表1在环中旋转，直到回到loop1位置的时候，如果没有遇到loop2，则说明两者不相交
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    // 或者返回loop2也可以
                    return loop1; 
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
    
    /** 获取相交节点的主要方法 */
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 先获取链表1和链表2的入环节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        
        // 两个链表都是无环链表
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        // 两个链表都是有环链表
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
