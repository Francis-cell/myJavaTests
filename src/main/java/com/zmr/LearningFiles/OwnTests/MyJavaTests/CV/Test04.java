package com.zmr.LearningFiles.OwnTests.MyJavaTests.CV;

/**
 * @Author franciszmr
 * @Date 2024/4/6 19:57
 * @Version 1.0
 * @Description TODO
 **/
public class Test04 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head==null) {
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                return true;
            }
        }
        return false;
    }
}
