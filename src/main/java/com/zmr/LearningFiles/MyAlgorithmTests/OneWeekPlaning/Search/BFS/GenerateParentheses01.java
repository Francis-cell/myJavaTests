package com.zmr.LearningFiles.MyAlgorithmTests.OneWeekPlaning.Search.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p> 广度优先-自实现 </p>
 * https://leetcode.cn/problems/generate-parentheses/solutions/
 */
public class GenerateParentheses01 {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left == 0 && current.right == 0) {
                ans.add(current.str);
            } else {
                // 左括号有剩余
                if (current.left > 0) {
                    queue.offer(new Node(current.str + "(", current.left - 1, current.right));
                }
                // 右括号数量小于左括号数量，可以添加右括号
                if (current.right > current.left) {
                    queue.offer(new Node(current.str + ")", current.left, current.right - 1));
                }
            }
        }
        return ans;
    }

    static class Node {
        /** 当前节点位置的 str 的值 */
        String str;
        /** 当前节点剩余的 “(” 的数量 */
        int left;
        /** 当前节点剩余的 “)” 的数量 */
        int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    public static void printList(List<String> list) {
        for (String str : list) {
            System.out.printf(str + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printList(generateParenthesis(3));
    }
}
