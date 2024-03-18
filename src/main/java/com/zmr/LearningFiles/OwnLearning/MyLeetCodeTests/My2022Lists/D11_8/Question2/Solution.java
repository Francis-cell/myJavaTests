package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2022Lists.D11_8.Question2;

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

    /**
     * k个一组反转链表
     * @param head
     * @param k
     */
    public ListNode reverseList(ListNode head, int k) {
        // 特殊处理k=1的情况
        if (k == 1) {
            return head;
        }

        // 大致思路：
        // 1、新建两个链表firstList(需要添加一个虚拟节点，用于连接节点使用)和secondList(用于放置颠倒之后的元素)
        // 2、如果secondList中能放置的节点的数量等于k的时候，则将secondList直接串联到firstList的末尾
        //    如果secondList中放置的节点到最后也无法等于k的时候，则从secondList中从最后一个节点开始拆下来，连接到firstList末尾上

        // 1、新建两个新的链表，用来处理
        // 新建一个带虚拟节点的链表firstList，用于存放最终的结果，并返回
        ListNode firstList = new ListNode(-1);
        // 新建一个节点，用来存储firstList初始节点的位置，用于返回最终结果
        ListNode lastList = firstList;
        // 新建一个值为null的链表，专门用来存放从原本链表(head)上拆解下来的节点，连接的时候就是满足顺序的
        ListNode secondList = null;

        // 定义一个计数器
        int countNode = 0;

        // 2、当head节点不为空，则将节点连接到secondList的前面去
        while (head!=null) {
            while (head!=null && countNode != k) {
                // 保存head的下一个节点
                ListNode nextNode = head.next;
                // 将head节点获取下来，然后拼接到secondList的前面
                head.next = secondList;
                // 将secondList节点换成最新的head节点
                secondList = head;
                // head节点向后移动
                head = nextNode;
                // 计数器+1
                countNode++;
            }

            // 将secondList连接到firstList的末尾上
            // 如果countNode的值等于k，则直接链接firstList和secondList
            if (countNode == k) {
                firstList.next = secondList;
                // 同时更新firstList节点的位置到原本的firstList的末尾节点
                for (int i = 0; i < k; i++) {
                    firstList = firstList.next;
                }
                // 重置计数
                countNode = 0;
                // 重置secondList
                secondList = null;
            }
            // 否则将secondList从最后一个节点开始向前拆解，并拼接到firstList上
            else {
                // 新建一个临时链表节点
                ListNode tempList = null;
                while (secondList!=null) {
                    // 保存secondList的下一个节点
                    ListNode tempNextNode = secondList.next;
                    secondList.next = tempList;
                    tempList = secondList;
                    secondList = tempNextNode;
                }
                // 重置secondList
                secondList = null;

                firstList.next = tempList;
            }
        }
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
        int k = 1;
        ListNode listNode = solution.reverseList(listNode1, k);
        System.out.println(listNode);
    }
}
