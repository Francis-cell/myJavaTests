package com.zmr.LearningFiles.MyAlgorithmTests.OneWeekPlaning.Search.DFS;

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
        if (n == 0) {
            return null;
        }
        List<String> ans = new ArrayList<>();
        // 用于递归尝试的一个临时数组
        int[] INTS = new int[n * 2];
        // 当前正在执行填入的元素下标
        int currentIndex = 0;
        // 左括号的数量
        int numLeft = 0;
        // 右括号的数量
        int numRight = 0;
        dfs(ans, n, numLeft, numRight, INTS, currentIndex);
        return ans;
    }

    public static void dfs(List<String> ans, int n, int numLeft, int numRight, int[] INTS, int currentIndex) {
        // 结束条件
        if (numLeft < numRight || numLeft > n || numRight == n || currentIndex == INTS.length) {
            String str = convertArrToString(INTS);

            // 如果没存在，则添加
            if (!ans.contains(str)) {
                ans.add(str);
            }
            return;
        }

        // 最开始只能是左括号
        if (numLeft == 0) {
            INTS[currentIndex] = 1;
            currentIndex++;
            numLeft++;
            dfs(ans, n, numLeft, numRight, INTS, currentIndex);
        } else {
            for (String str : STRINGS) {
                // 右括号已经到达数量极限，则直接结束
                if (numRight == n) {
                    break;
                }
                // 左括号已经到达极限，只能再添加右括号
                else if (numLeft == n) {
                    INTS[currentIndex] = 2;
                    numRight++;
                    currentIndex++;
                }
                // 其他条件，则左括号或者右括号都可以往里面添加
                else {
                    // 计数增加
                    if ("(".equals(str)) {
                        INTS[currentIndex] = 1;
                        numLeft++;
                    } else {
                        INTS[currentIndex] = 2;
                        numRight++;
                    }
                    currentIndex++;
                }
                dfs(ans, n, numLeft, numRight, INTS, currentIndex);
            }
        }
    }

    /**
     * 将整型数组转换为字符串
     * @param arr
     * @return
     */
    private static String convertArrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                sb.append("(");
            } else {
                sb.append(")");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(2);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
