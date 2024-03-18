package com.zmr.LearningFiles.OwnLearning.NewBrushUpPlan;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/5/30 21:58
 * @description https://leetcode.cn/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 */
public class GreatestFactorStrings {
    /**
     * 使用辗转相除法进行求解
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        // 假设str1是M个x，str2是N个x，那么str1+str2一定等于str2+str1的
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * 求两个整数的最大公约数
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public static void main(String[] args) {
        String str1 = "ABCABCABC";
        String str2 = "ABCABC";
        System.out.println("最终的结果为：" + gcdOfStrings(str1, str2));
    }
}
