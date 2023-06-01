package com.zmr.NewBrushUpPlan;

import java.util.Arrays;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/6/1 22:49
 * @description https://leetcode.cn/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseWordInString {
    /**
     * 反转字符串中的单词
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if ("".equals(s)) {
            return "";
        }
        
        // 将原本的字符串进行拆分
        return reverseStrArr(s.split(" "));
    }

    /**
     * 反转字符串数组，头尾不能为空格，如果多个空格则转换为单个空格
     * @param strArr
     */
    private static String reverseStrArr(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        
        // 直接遍历数组，如果发现""，则直接跳过
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (!"".equals(strArr[i])) {
                sb.append(strArr[i]);
                sb.append(" ");
            }
        }
        
        // 最后删除一个字符即可
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
