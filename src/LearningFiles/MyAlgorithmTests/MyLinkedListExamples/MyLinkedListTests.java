package LearningFiles.MyAlgorithmTests.MyLinkedListExamples;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyLinkedListTests
 * @Description 反转链表
 * @Author zhumengren
 * @Date 2023/2/1 12:19
 * @Version 1.0
 **/
public class MyLinkedListTests {
    /** 辅助类Node */
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


    /**
     * 反转链表定义方法
     * head
     * a    ->     b      ->       c       ->         null
     * c    ->     b      ->       a       ->         null
     * 使用两个辅助指针pre和next实现的链表反转方案
     */
    public static ListNode reverseLinkedList(ListNode head) {
        // 声明两个辅助的指针变量pre和next
        // TODO--说明：pre作为新链表的头节点的位置，next作为原本链表剩余的节点的头节点位置
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            // 1、记录head的next的节点，用于后面使用
            next = head.next;
            // 2、将链表从当前节点head拆开成为两个小的链表
            head.next = pre;
            // 3、新链表的头节点更换成head节点
            pre = head;
            // 4、将next赋值给老链表的头节点head
            head = next;
        }
        return pre;
    }

    /** 使用额外空间实现链表的翻转实现方案 */
    public static ListNode test(ListNode head) {
        if (head == null) {
            return null;
        }
        // 初始化一个列表存储链表中各个节点中的值
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // 将第一个节点的next赋值为null
        list.get(0).next = null;
        // 反转列表并进行链表的连接
        int N = list.size();
        for (int i = 1; i < N; i++) {
            // 链接
            list.get(i).next = list.get(i-1);
        }
        return list.get(N-1);
    }


    /** 生成随机链表 */
    public static ListNode generateRandomLinkedList(int len, int value) {
        // 随机产生一个链表的长度
        int size = (int) (Math.random() * len);
        if (size == 0) {
            return null;
        }
        size--;
        // 随机生成链表的头结点
        ListNode head = new ListNode((int) (Math.random() * (value - 1)));
        ListNode pre = head;
        // 生成这个随机链表中的剩余值
        while (size != 0) {
            // 随机生成一个节点
            ListNode cur = new ListNode((int) (Math.random() * (value - 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }


    /** 检查链表是否反转的程序 */
    public static boolean checkLinkedListReverse(List<Integer> origin, ListNode head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.val)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    /** 将链表中的数据获取出来放置到一个链表中去 */
    public static List<Integer> getLinkedListOriginOrder(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while(head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 10000;
        System.out.println("测试开始！！！");
        for (int i = 0; i < testTime; i++) {
            // 1、生成随机链表
            ListNode listNode1 = generateRandomLinkedList(len, value);
            // 2、使用新写的链表节点翻转方法
            ListNode listNode2 = reverseLinkedList(listNode1);
            //ListNode listNode2_back = reverseLinkedList(listNode1);
            //// 3、使用list列表形式写的链表翻转方法进行翻转
            //ListNode listNode3 = test(listNode1);
            //ListNode listNode3_back = test(listNode1);
            List<Integer> list1 = getLinkedListOriginOrder(listNode1);
            // 4、检查链表是否成功翻转
            if (checkLinkedListReverse(list1, listNode2)) {
                System.out.println("出错了！");
                return;
            }
            //while (listNode2 != null) {
            //    if (listNode2.val != listNode3.val) {
            //        System.out.println(listNode2.val);
            //        System.out.println(listNode3.val);
            //        System.out.println(listNode1);
            //        System.out.println(listNode2_back);
            //        System.out.println(listNode3_back);
            //        System.out.println("出错了！！！");
            //        return;
            //    }
            //    listNode2 = listNode2.next;
            //    listNode3 = listNode3.next;
            //}
        }
        System.out.println("测试结束！！！");
    }
}
