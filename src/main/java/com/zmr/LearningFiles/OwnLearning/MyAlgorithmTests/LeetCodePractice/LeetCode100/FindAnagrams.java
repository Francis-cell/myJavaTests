package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.DataStructUtils.ArrayUtils.ArrayUtils;
import com.zmr.MyUtils.TestTools.CompareUtils.ComparatorUtils.ComparatorUtils;
import com.zmr.MyUtils.DataStructUtils.ListUtils.ListUtils;
import com.zmr.MyUtils.TestTools.GenerateDataUtils.GenerateDataUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> 找到字符串所有字母异位词 </p>
 * <pre>
 *     1 <= s.length, p.length <= 3 * 104
 *      s 和 p 仅包含小写字母
 * </pre>
 */
public class FindAnagrams {
    /**
     * <p> 暴力解 </p>
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagramsCrude(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || "".equals(s) || "".equals(p)) {
            return ans;
        }

        // 获取到 p 的长度
        int pLength = p.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; ;) {
                j += pLength;
                if (j > s.length()) {
                    break;
                }
                // 没有越界的字符串
                String compareStr = s.substring(i, j);
                boolean checkRes = check(compareStr, p);
                if (checkRes) {
                    ans.add(i);
                    break;
                }
            }
        }

        return ans;
    }

    /**
     * <p> 滑动窗口解 </p>
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || "".equals(s) || "".equals(p)) {
            return ans;
        }

        // 滑动窗口解法（r 不取到，为开区间）
        for (int l = 0, r = 0; r <= s.length(); r++) {
            // 当前考虑的元素
            // 区间[left,right]不符合题意
            while (l <= r && (r - l) == p.length()) {
                if (check(s.substring(l, r), p)) {
                    ans.add(l);
                }
                // 虫身向右移动，因为此刻虫身已经达到极限
                l++;
            }
        }
        return ans;
    }


    /**
     * <p> 检查两个字符串是否是异构的 </p>
     * <p> 使用示例： </p>
     * <pre>
     *     {@code
     *         // 传入两个 String
     *         String str1 = "abc";
     *         String str2 = "acb";
     *         String str3 = "cba";
     *         String str4 = "dba";
     *         // true
     *         System.out.println(check(str1, str2));
     *         // true
     *         System.out.println(check(str3, str2));
     *         // false
     *         System.out.println(check(str1, str4));
     *     }
     * </pre>
     * @param str1 第一个检查字符
     * @param str2 第二个检查字符
     * @return
     */
    public static boolean check(String str1, String str2) {
        if (str1 == null && str2 != null || str1 != null && str2 == null) {
            return false;
        }
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        // 两者长度相等
        Character[] charArrayStr1 = ArrayUtils.strToCharacterArr(str1);
        Character[] charArrayStr2 = ArrayUtils.strToCharacterArr(str2);
        // Char 数组排序
        Arrays.sort(charArrayStr1, new ComparatorUtils.ArrayComparator());
        Arrays.sort(charArrayStr2, new ComparatorUtils.ArrayComparator());

        for (int i = 0; i < charArrayStr1.length; i++) {
            if (charArrayStr1[i] != charArrayStr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // // [0,6]
        // String s1 = "cbaebabacd";
        // String p1 = "abc";
        //
        // // [0,1,2]
        // String s2 = "abab";
        // String p2 = "ab";
        //
        // List<Integer> ans1 = findAnagramsCrude(s1, p1);
        // List<Integer> ans2 = findAnagramsCrude(s2, p2);
        // PrintUtils.printSampleList(ans1);
        // PrintUtils.printSampleList(ans2);
        //
        // List<Integer> ans3 = findAnagrams(s1, p1);
        // List<Integer> ans4 = findAnagrams(s2, p2);
        // PrintUtils.printSampleList(ans3);
        // PrintUtils.printSampleList(ans4);


        int maxLength = 1000;
        int pMaxLength = 100;
        int testTimes = 10000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机字符串
            String str = GenerateDataUtils.generateRandomString(maxLength, "lower");
            String pStr = GenerateDataUtils.generateRandomString(pMaxLength, "lower");

            List<Integer> ans1 = findAnagramsCrude(str, pStr);
            List<Integer> ans2 = findAnagrams(str, pStr);

            if (!ListUtils.isEqualListWithSort(ans1, ans2)) {
                System.out.println("测试错误！");
                System.out.println("str: " +  str);
                System.out.println("pStr: " +  pStr);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
