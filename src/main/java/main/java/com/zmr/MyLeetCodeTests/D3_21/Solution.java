package main.java.com.zmr.MyLeetCodeTests.D3_21;

import java.util.Stack;

class Solution {
    //public static int longestValidParentheses(String s) {
    //    if (s == "" || s == null) {
    //        return 0;
    //    }
    //    // 初始计数为0
    //    int count = 0;
    //    char[] str = s.toCharArray();
    //    return process(0, count, str, false);
    //}
    //
    //public static int process(int cur, int count, char[] str, boolean flag) {
    //    // base case
    //    if (cur == str.length) {
    //        return 0;
    //    }
    //
    //    if (str[cur] == '(') {
    //        flag = true;
    //    } else if (str[cur] == ')' && flag) {
    //        count++;
    //        flag = false;
    //    }
    //    count += process(cur + 1, count, str, flag);
    //    return count;
    //}


    //public static int longestValidParentheses(String s) {
    //    if (s == "" || s == null) {
    //        return 0;
    //    }
    //    // 初始计数为0
    //    int count = 0;
    //    char[] str = s.toCharArray();
    //    //return process(0, count, str, false);
    //}


    ///***
    // * @Description 暴力递归递归流程
    // * @param str 需要进行处理的字符串
    // * @param index 要处理的str子串的开始位置 【当前位置】 可以取到
    // * @param end 要处理的str子串的结束位置 可以取到
    // * @return int 处理的str子串中最大的有效括号的长度
    // */
    //public static int process(char[] str, int index, int end) {
    //    //// base case
    //    //// 如果当前只有字符串子串中只有一个字符，那么它很显然无法形成有效的括号对，故而直接返回0
    //    //if (index == end) {
    //    //    return 0;
    //    //}
    //    //
    //    //// 1、舍弃当前位置的字符
    //    //int p1 = process(str, index + 1, end);
    //    //// 2、保留当前位置的字符
    //    //int p2 = 0;
    //    //if (str.toString().substring(index))
    //}


    /** 括号有效性检查 */
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return false;
        }

        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Character> help = new Stack<>();
        // 所有的char元素先全部入栈
        for (char cha : str) {
            stack.push(cha);
        }

        while (!stack.isEmpty()) {
            // stack中的元素出栈
            char cur = stack.pop();

            if (cur - ')' == 0) {
                help.push(cur);
            } else {
                if (help.isEmpty()) {
                    return false;
                } else if (!isPair(cur, help.pop())) {
                    return false;
                }
            }
        }

        if (!help.isEmpty()) {
            return false;
        }

        return true;
    }

    /***
     * @Description 判断一对char类型的括号是否匹配
     * @param a
     * @param b
     * @return boolean
     */
    public static boolean isPair(char a, char b) {
        if (a - '(' == 0 && b - ')' == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    /** 暴力破解法 */
    public static int longestValidParentheses01(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return 0;
        }

        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (isValid(str.substring(i, j + 1))) {
                    count = Math.max(count, (j - i + 1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //String s = "()";
        //String s = "()))()";
        String s = "()))())()()()()())()()()()()(((()())))()(";
        System.out.println(longestValidParentheses01(s));
        System.out.println(isValid(s));
    }
}