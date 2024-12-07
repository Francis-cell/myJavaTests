package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.ArrayUtils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
    public List<Integer> findAnagramsCrude(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || "".equals(s) || "".equals(p)) {
            return ans;
        }
        return null;
    }

    /**
     * <p> 检查两个字符串是否是异构的 </p>
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
        Arrays.sort(charArrayStr1, new ComparatorInner());
        Arrays.sort(charArrayStr2, new ComparatorInner());

        for (int i = 0; i < charArrayStr1.length; i++) {
            if (charArrayStr1[i] != charArrayStr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p> Character 比较器 </p>
     */
    public static class ComparatorInner implements Comparator<Character> {
        @Override
        public int compare(Character o1, Character o2) {
            return o1 - o2;
        }
    }

    public static void main(String[] args) {
        // [0,6]
        String s1 = "cbaebabacd";
        String p1 = "abc";

        // [0,1,2]
        String s2 = "abab";
        String p2 = "ab";
    }
}
