package com.zmr.LearningFiles.MyAlgorithmTests.ViolentRecursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/18 15:09
 * @description 打印一个字符串中的所有子序列
 * 1、打印时不去重
 * 2、打印时去重(使用set进行存储)
 */
public class PrintAllSubSqueneces {
    
    /** 1、获取一个字符串中所有的子序列（没有去重） */
    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        // 初始时没有任何的路径，所以path的值为""
        String path = "";
        List<String> ans = new ArrayList<>();
        process01(str, 0, ans, path);
        return ans;
    }

    /**
     * 核心方法--递归
     * @param str 要处理的str转换出来的字符数组
     * @param index 当前来到的位置，即当前位置的字符为str[index]
     * @param ans 所有生成的子序列存放的结构
     * @param path 之前的路径已经决定下来了，存储在path中
     *             str[0 ... index-1]已经走过了
     *             但是str[index...]还能决定，对应能够产生的结果都存储到ans中
     */
    public static void process01(char[] str, int index, List<String> ans, String path) {
        // base case
        // 到末尾位置了
        if (index == str.length) {
            ans.add(path);
            return;
        }
        
        // 1、如果没有要index位置的字符(path位置取值就是之前的路径的值)
        process01(str, index + 1, ans, path);
        // 2、如果要了index位置的字符(path位置的取值就是之前的路径的值 + index位置的值)
        process01(str, index + 1, ans, path + String.valueOf(str[index]));
    }


    /** 2、获取一个字符串中所有的子序列（去重） */
    public static List<String> subsNoRepeat(String s) {
        char[] str = s.toCharArray();
        String path = "";
        // 创建一个集合
        HashSet<String> set = new HashSet<>();
        process02(str, 0, set, path);
        List<String> ans = new ArrayList<>();
        for (String cur : set) {
            ans.add(cur);
        }
        return ans;
    }
    
    /** 对应的递归 */
    public static void process02(char[] str, int index, HashSet<String> ans, String path) {
        // base case
        if (index == str.length) {
            ans.add(path);
            return;
        }
        
        // 不要当前位置字符的情况
        String no = path;
        process02(str, index + 1, ans, no);
        
        // 要当前位置字符的情况
        String yes = String.valueOf(str[index]) + path;
        process02(str, index + 1, ans, yes);
    }

    public static void main(String[] args) {
        String testStr = "abccc";
        List<String> ans1 = subs(testStr);
        List<String> ans2 = subsNoRepeat(testStr);

        System.out.println("=======不去重======");
        for (String str : ans1) {
            System.out.println(str);
        }
        
        
        System.out.println("=======去重=======");
        for (String str : ans2) {
            System.out.println(str);
        }
    }
}
