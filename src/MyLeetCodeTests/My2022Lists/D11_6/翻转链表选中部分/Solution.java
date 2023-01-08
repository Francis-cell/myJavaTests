package MyLeetCodeTests.My2022Lists.D11_6.翻转链表选中部分;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */
/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/6 12:35
 */
public class Solution {
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
    public static ListNode ReverseList(ListNode head) {
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

    /**
     * @describtion: m为链表中靠前的一个值，n为链表中靠后的一个值，将中间的值进行翻转，其余不变
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head.next == null) {
            return head;
        }

        // 如果m和n不在head中存在，则直接返回原本的链表
        int flag = 0;
        while (head!=null && (head.val == m || head.val == n)) {
            flag++;
        }
        if (flag!=2) {
            return head;
        }

        // 将初始的链表分为3个部分；1：颠倒区域前方的链表、2：颠倒区域、3：颠倒区域后方的区域
        // 作为最终结果返回
        ListNode lastNode = head;
        // 第一部分的最后一个节点
        ListNode firstPartEnd = null;
        // 第二部分的第一个节点
        ListNode secondPartStart = null;
        // 第三部分的第一个节点
        ListNode thirdNodeStart = null;
        while (head!=null) {
            // 开始剪切链表
            if (head.val == m) {
                secondPartStart = head;
                firstPartEnd.next = null;
                // 第二部分的最后一个节点
                ListNode secondHead = head;
                while (secondHead != null) {
                    if (secondHead.val == n) {
                        thirdNodeStart = secondHead.next;
                        secondHead.next = null;
                        break;
                    }
                    secondHead = secondHead.next;
                }
                break;
            }
            firstPartEnd = head;
            head = head.next;
        }

        // 此时链表分为3个部分 lastNode-> firstPartEnd、secondPartStart->secondPartEnd、thirdNodeStart->...
        // 其中第二部分是我们要进行翻转的部分
        ListNode newSecondStart = Solution.ReverseList(secondPartStart);
        // 拼接第一部分
        firstPartEnd.next = newSecondStart;
        ListNode newSecondEnd;
        while (newSecondStart.next != null) {
            newSecondStart = newSecondStart.next;
        }
        newSecondEnd = newSecondStart;
        // 拼接第二部分
        newSecondEnd.next = thirdNodeStart;

        return lastNode;
    }

    public ListNode reverseBetween2 (ListNode head, int m, int n) {
        // 首先找到需要反转的链表节点
        if (m == n) {
            return head;
        }

        // 作为最终结果返回
        ListNode lastNode = head;
        // 第一部分的最后一个节点
        ListNode firstPartEnd = null;
        // 第二部分的第一个节点
        ListNode secondPartStart = null;
        // 第三部分的第一个节点
        ListNode thirdPartStart = null;
        // 代表步数的变量
        int indexStart = 1;
        while (head!=null) {
            if (m == indexStart) {
                secondPartStart = head;
                if (m != 1) {
                    firstPartEnd.next = null;
                }
                // 第二部分的最后一个节点
                ListNode secondHead = head;
                while (secondHead!=null) {
                    if (n == indexStart) {
                        thirdPartStart = secondHead.next;
                        secondHead.next = null;
                        break;
                    }
                    secondHead = secondHead.next;
                    indexStart++;
                }
                break;
            }
            firstPartEnd = head;
            head = head.next;
            indexStart++;
        }

        // 此时链表分为3个部分 lastNode-> firstPartEnd、secondPartStart->secondPartEnd、thirdNodeStart->...
        // 其中第二部分是我们要进行翻转的部分
        ListNode newSecondStart = Solution.ReverseList(secondPartStart);
        // 拼接第一部分
        if (lastNode != null) {
            head = lastNode;
            while (lastNode.next!=null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newSecondStart;
            while (lastNode.next!=null) {
                lastNode = lastNode.next;
            }
            lastNode.next = thirdPartStart;
        } else {
            lastNode = newSecondStart;
            head = lastNode;
            while (lastNode.next!=null) {
                lastNode = lastNode.next;
            }
            lastNode.next = thirdPartStart;
        }
        return head;
    }



    public static void main(String[] args) {
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(1);
        ListNode sixth = new ListNode(4);
        ListNode seventh = new ListNode(-1);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        seventh.next = null;

        int m = 3;
        int n = 7;

        Solution solution = new Solution();
        System.out.println(solution.reverseBetween2(first, m, n));
    }
}
