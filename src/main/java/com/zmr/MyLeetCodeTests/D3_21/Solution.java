package com.zmr.MyLeetCodeTests.D3_21;

class Solution {
    public static int longestValidParentheses(String s) {
        if (s == "" || s == null) {
            return 0;
        }
        // 初始计数为0
        int count = 0;
        char[] str = s.toCharArray();
        return process(0, count, str, false);
    }
    
    public static int process(int cur, int count, char[] str, boolean flag) {
        // base case
        if (cur == str.length) {
            return 0;
        }

        if (str[cur] == '(') {
            flag = true;
        } else if (str[cur] == ')' && flag) {
            count++;
            flag = false;
        }
        count += process(cur + 1, count, str, flag);
        return count;
    }

    public static void main(String[] args) {
        String s = "()))()";
        System.out.println(longestValidParentheses(s));
    }
}