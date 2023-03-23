package com.zmr.LearningFiles.MyAlgorithmTests.ViolentRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/18 18:06
 * @description 打印一个字符串的全部排列(含去重和不去重版本)
 */
public class PrintAllPermutations {
    /** ===================第一种递归实现(不是很好的递归设计)====================== */
    public static List<String> permutation1(String s) {
        // 为递归函数准备需要的数据
        
        // ans
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        
        
        // rest
        char[] str = s.toCharArray();
        ArrayList<Character> rest = new ArrayList<>();
        for (char ch : str) {
            rest.add(ch);
        }
        
        // path
        String path = "";
        
        f(rest, path, ans);
        return ans;
    }

    /**
     * 第一种递归函数设计
     * @param rest 剩余还没被选择的字符的数组
     * @param path 到当前字符，已经走过的路径（这条路径是确定的，因此不可改变）
     * @param ans 已经形成的ans结果集
     */
    public static void f(ArrayList<Character> rest, String path, List<String> ans) {
        // base case
        if (rest.isEmpty()) {
            ans.add(path);
        } else {
            // 获取剩余字符的数量
            int N = rest.size();
            for (int i = 0; i < N; i++) {
                // 当前字符
                char cur = rest.get(i);
                // 当前字符被选中为已有path的下一个节点
                rest.remove(i);
                // 递归
                f (rest, path + cur, ans);
                // TODO--恢复现场(这一步是为了递归生成结果的正确性)
                rest.add(i, cur);
            }
        }
    }



    /** ===================第二种递归实现(比较好的递归设计)====================== */
    public static List<String> permutation2(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        
        char[] str = s.toCharArray();
        g1(str, 0, ans);
        return ans;
    }


    /**
     * 第二种递归函数设计
     * @param str 当前要处理的字符串转成的字符数组
     * @param index 当前处理时的元素起始下标
     * @param ans 生成的元素全排列结果集
     *            
     *            
     *  示例：              0?              1?                 2?                   "XXX"代表元素被选定
     * | 1 |              ["a", b, c]     ["a", "b", c]       ["a", "b", "c"]      abc(返回到1?)
     * | 2 |                              ["a", "c", b]       ["a", "c", "b"]      acb(返回到0?)
     * | 3 |              
     * | 4 |              ["b", a, c]     ["b", "a", c]       ["b", "a", "c"]      bac(返回到1?)
     * | 5 |  [a, b, c]                   ["b", "c", a]       ["b", "c", "a"]      bca(返回到0?)  
     * | 6 |          
     * | 7 |              ["c", a, b]     ["c", "b", a]       ["c", "b", "a"]      cba(返回到1?)
     * | 8 |                              ["c", "a", b]       ["c", "a", "b"]      cab(返回到0?)
     */ 
    public static void g1(char[] str, int index, List<String> ans) {
        // base case
        if (index == str.length) {
            // 如果当前的index抵达了str的末尾位置，那么将str转成字符串返回即可
            ans.add(String.valueOf(str));
        } else { 
            // 这里的循环，是最外层的循环，决定第i个字符是谁的循环
            for (int i = index; i < str.length; i++) {
                // 将index位置的元素和当前位置的元素交换位置
                swap(str, index, i);
                // 递归
                g1(str, index + 1, ans);
                // 恢复现场
                swap(str, index, i);
            }
        }
    }


    /** ===================第三种递归实现--第二种基础上实现(去重)====================== */
    public static List<String> permutation3(String s) {
        ArrayList<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        
        char[] str = s.toCharArray();
        g2(str, 0, ans);
        return ans;
    }
    
    /** 第三种递归函数的设计 */
    public static void g2(char[] str, int index, List<String> ans) {
        // base case
        if (index == str.length) {
            ans.add(String.valueOf(str));
        } else {
            boolean[] visited = new boolean[256];
            for (int i = index; i < str.length; i++) {
                // 如果这个元素还没被拜访过(比如第一位为a, 则后面的a将不会被交换上来，故而实现了去重操作)
                if (!visited[str[i]]) {
                    // 设置为拜访过
                    visited[str[i]] = true;
                    // 交换元素
                    swap(str, index, i);
                    g2(str, index + 1, ans);
                    // 恢复现场
                    swap(str, index, i);
                }
            }
        }
    }
    
    
    /** 辅助方法swap() */
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
    
    
    
    public static void main(String[] args) {
        String str = "acc";
        List<String> ans1 = permutation1(str);
        for (String str1 : ans1) {
            System.out.println(str1);
        }

        System.out.println("========================");
        List<String> ans2 = permutation2(str);
        for (String str2 : ans2) {
            System.out.println(str2);
        }

        System.out.println("========================");
        List<String> ans3 = permutation3(str);
        for (String str3 : ans3) {
            System.out.println(str3);
        }
    }
}
