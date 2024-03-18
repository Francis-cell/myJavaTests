package com.zmr.LearningFiles.OwnLearning.NewBrushUpPlan;

import java.util.Random;

/**
 * @ClassName IsSubsequence
 * @Description https://leetcode.cn/problems/is-subsequence/
 * @Version 1.0
 **/
public class IsSubsequence {
    /***
     * @Description 对数器暴力解
     * @param s
     * @param t
     * @return boolean
     */
    public static boolean isSubsequence(String s, String t) {
        if ("".equals(s)) {
            return true;
        }
        
        // 使用双指针的策略进行实现
        for (int i = 0; i < s.length(); ) {
            for (int j = 0; j < t.length(); ) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
                
                // 如果i越界了，那么就代表s在t中被完全匹配到了
                if (i == s.length()) {
                    return true;
                }
                
                // 如果j越界了，但是i还没有越界，那么就代表匹配不到了
                if (j == t.length() && i < s.length()) {
                    return false;
                }
            } 
        }
        
        return false;
    }


    /***
     * @Description 高效解
     * @param s
     * @param t
     * @return boolean
     */    
    public static boolean isSubsequence01(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /***
     * @Description 快慢指针的解法
     * @param s
     * @param t
     * @return boolean
     */
    public static boolean isSubsequence02(String s, String t) {
        if ("".equals(s)) {
            return true;
        }
        
        int fast = 0, slow = 0;
        while (fast < t.length()) {
            if (t.charAt(fast) == s.charAt(slow)) {
                slow++;
            }
            fast++;
            if (slow == s.length()) {
                return true;
            }

            if (fast == t.length()) {
                return false;
            }
        }
        
        return slow == s.length();
    }
    
    /**
     * @Description 随机生成指定长度的字符串，要求这个字符串中的字符都是小写的
     * @param length
     * @return java.lang.String
     */
    public static String generateRandomString(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // 随机生成小写字母
            int randChar = rand.nextInt(26) + 'a';
            sb.append((char) randChar);
        }
        
        return sb.toString();
    }
    
    
    /**
     * @Description 随机生成一个整型数组，数组中有两个参数，第一个参数是较短的数组的长度，第二个参数是较长的数组的长度
     * @return int[]
     */
    public static int[] initLengthArr() {
        int[] ans = new int[2];
        
        Random rand = new Random();
        
        // 随机生成两个数字，其中s1在 0 - 100 之间，s2在 0 - 10^4 之间
        int a = rand.nextInt(100);
        
        int b = rand.nextInt(10000);
        
        if (a > b) {
            ans = initLengthArr();
        }
        
        ans[0] = a;
        ans[1] = b;
        
        return ans;
    }
    

    public static void main(String[] args) {
        //String s = "aa", t = "aabgdc";
        //System.out.println(isSubsequence02(s, t));
        
        int testTimes = 10000;

        System.out.println("开始测试！");
        for (int i = 0; i < testTimes; i++) {
            // 随机生成两个字符串的长度
            int[] intLengthes = initLengthArr();
            // 使用生成的数组的长度生成字符串信息
            String a = generateRandomString(intLengthes[0]);
            String b = generateRandomString(intLengthes[1]);

            //System.out.println("a: " + a + " b: " + b);
            // 处理比较
            if (isSubsequence(a, b) != isSubsequence01(a, b) || isSubsequence02(a, b) != isSubsequence01(a, b)) {
                System.out.println("出错了！");
                break;
            }
        }

        System.out.println("测试结束！");
    }
}
