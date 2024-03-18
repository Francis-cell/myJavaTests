package com.zmr.LearningFiles.OneWeekPlaning.Search.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成：
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * 思考自己写的算法出现问题的原因：
 * 1、StringBuilder 在递归过程中无法还原
 */
public class GenerateParentheses {
    private static final String[] STRINGS = new String[] {"(", ")"};

    /**
     * 左右括号的数量满足以下条件
     * n >= numLeft >= numRight
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        dfs("", n, n, ans);
        return ans;
    }

    /**
     *
     * @param curStr 当前递归的结果
     * @param numLeft 左括号还有多少个可以使用
     * @param numRight 右括号还有多少个可以使用
     * @param ans 结果集
     */
    public static void dfs(String curStr, int numLeft, int numRight, List<String> ans) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯，
        // 在递归终止的时候，直接将他们添加到结果集即可
        if (numLeft == 0 && numRight == 0) {
            ans.add(curStr);
            return;
        }

        // 剪枝
        if (numLeft > numRight) {
            return;
        }

        if (numLeft > 0) {
            dfs(curStr + "(", numLeft - 1, numRight, ans);
        }

        if (numRight > 0) {
            dfs(curStr + ")", numLeft, numRight - 1, ans);
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(2);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
