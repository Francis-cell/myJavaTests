package com.zmr.LearningFiles.MyAlgorithmTests.OneWeekPlaning.Search.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p> 广度优先 </p>
 * https://leetcode.cn/problems/generate-parentheses/solutions/
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        if (n <= 0) {
            return ans;
        }

        // 用于层序遍历使用的 queue
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node("", 0, 0));

        while (!queue.isEmpty()) {
            // 获取到当前的节点
            Node node = queue.poll();
            // 如果左右括号都达到了目标值，则将当前字符串都加入到结果列表中
            if (node.left == n && node.right == n) {
                ans.add(node.str);
            } else {
                // 如果左括号少于最大数量
                if (node.left < n) {
                    queue.offer(new Node(node.str + "(", node.left + 1, node.right));
                }
                // 如果右括号小于左括号数量，则可以添加右括号
                if (node.right < node.left) {
                    queue.offer(new Node(node.str + ")", node.left, node.right + 1));
                }
            }
        }

        return ans;
    }

    static class Node {
        /** 当前节点位置时，已经形成的字符串状态 */
        String str;
        /** 当前节点位置时，已经有的左括号的数量 */
        int left;
        /** 当前节点位置时，已经有的右括号的数量 */
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
