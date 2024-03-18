package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2022Lists.D12_24.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/12/24 11:09
 */
public class MainLinkedNode {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 以空格作为分隔符
        String[] strs = reader.readLine().split(" ");

        // 创建链表并赋值
        LinkNode head = new LinkNode(0);
        LinkNode index = head;
        for (int i = 0; i < strs.length; i++) {
            int tempVal = Integer.parseInt(strs[i]);
            index.next = new LinkNode(tempVal);
            index = index.next;
        }

        index.next = null;
        // head才是最终的头结点的值
        head = head.next;

        System.out.println(head.toString());
    }


    static class LinkNode {
        int val;
        LinkNode next = null;

        public LinkNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "LinkNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
