package main.java.com.zmr.MyLeetCodeTests.D3_24;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *
 * 1、左括号必须用相同类型的右括号闭合。
 * 2、左括号必须以正确的顺序闭合。
 * 3、每个右括号都有一个对应的相同类型的左括号。
 **/
public class Solution {
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
            
            if (cur - ')' == 0 || cur - ']' == 0 || cur - '}' == 0) {
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
        if (a - '(' == 0 && b - ')' == 0 || a - '[' == 0 && b - ']' == 0 || a - '{' == 0 && b - '}' == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //String str = "([])({[]})";
        //String str = "[()";
        String str = "({{{{}}}))";
        System.out.println(isValid(str));
    }
}
