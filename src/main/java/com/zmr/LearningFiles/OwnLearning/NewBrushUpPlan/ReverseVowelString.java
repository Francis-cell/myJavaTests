package com.zmr.LearningFiles.OwnLearning.NewBrushUpPlan;

import java.util.Arrays;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/6/1 22:14
 * @description https://leetcode.cn/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseVowelString {

    /** 声明元音字符数组 */
    static String[] vowelsStrArrays = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
    
    /**
     * 思路：双指针求解
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        // 拆分成char数组
        String[] tmpStrArr = s.split("");
        
        // 声明两个指针(一个在开始，一个在末尾，如果发现是元音字符，则进行交换)
        int a = 0;
        int b = s.length() - 1;

        for (int i = a; i < b;) {
            // 如果tmpArr[a]位置的元素不是元音字符，那么向下移动一格
            if (!isVowelsStr(tmpStrArr[a])) {
                a++;
                i = a;
            } else {
                // 开始移动指针b
                if (!isVowelsStr(tmpStrArr[b])) {
                    b--;
                } else {
                    // 说明此时a和b都找到了元音字符，那么执行交换操作
                    swapStrInStringArray(tmpStrArr, a, b);
                    // 同时a向后移动一格，b向左移动一格
                    a++;
                    b--;
                    i = a;
                }
            }
        }
        
        
        // 最终将形成的结果转换成字符串
        return String.join("", tmpStrArr);
    }

    /**
     * 判断一个str是否属于元音字符串
     * @param str
     * @return
     */
    private static Boolean isVowelsStr(String str) {
        return Arrays.asList(vowelsStrArrays).contains(str);
    }

    /**
     * 交换strArr中a下标和b下标位置的元素
     * @param strArr
     */
    private static void swapStrInStringArray (String[] strArr, int a, int b) {
        String tmpStr = strArr[a];
        strArr[a] = strArr[b];
        strArr[b] = tmpStr;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
}
