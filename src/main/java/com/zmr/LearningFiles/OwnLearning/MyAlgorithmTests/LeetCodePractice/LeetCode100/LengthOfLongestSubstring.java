package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.TestTools.GenerateDataUtils.GenerateDataUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p> 无重复字符的最长子串 </p>
 * <pre>
 *      0 <= s.length <= 5 * 104
 *      s 由英文字母、数字、符号和空格组成
 * </pre>
 */
public class LengthOfLongestSubstring {
    /**
     * <p> 暴力解 -- ERROR </p>
     * <pre>
     *     没有考虑到如下场景：
     *     在当前遍历的子字符串中，即使出现了重复字符，这个子字符串可能仍然比之前找到的最长子字符串要长；
     *     因此，你应该在内层循环结束后更新maxCount，而不是在遇到重复字符时立即更新；
     * </pre>
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringCrudeError(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        // 从每一个位置出发，一直向后遍历字符，直到出现重复字符，结束计数
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmpCount = 1;
            HashSet<Character> tmpSet = new HashSet<>();
            tmpSet.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                // 遍历到的字符
                Character currentCharacter = s.charAt(j);
                // 检查字符是否已经存在了
                if (!tmpSet.contains(currentCharacter)) {
                    tmpCount++;
                    tmpSet.add(currentCharacter);
                } else {
                    if (maxCount < tmpCount) {
                        maxCount = tmpCount;
                    }
                    break;
                }
            }
        }
        return maxCount;
    }

    /**
     * <p> 暴力解 </p>
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringCrude(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmpCount = 0;
            HashSet<Character> tmpSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                Character currentCharacter = s.charAt(j);
                if (!tmpSet.contains(currentCharacter)) {
                    tmpCount++;
                    tmpSet.add(currentCharacter);
                } else {
                    break;
                }
            }
            maxCount = Math.max(maxCount, tmpCount);
        }
        return maxCount;
    }


    /**
     * <p> 滑动窗口 + 哈希表 解法 </p>
     * <p> 时间复杂度 O(N)、空间复杂度 O(1) </p>
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 存储某个字符最大的下标
        Map<Character, Integer> dic = new HashMap<>();
        // i 为左指针
        // res 为最终的结果
        int i = -1, res = 0, len = s.length();
        for (int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j))) {
                // 如果 dic 中包含了当前指针指向的元素，则更新左指针的值
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            // 更新 hash 表记录
            dic.put(s.charAt(j), j);
            // 更新结果: j - i 为当前找到的不重复的字符串长度
            res = Math.max(res, j - i);
        }
        return res;
    }

    /**
     * <p> 暴力递归实现 </p>
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringRecursiveCrude(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // return processError(s, 0, 0, new HashSet<>());

        // 从每个位置开始，尝试找到最长子串
        return process(s, 0);
    }

    /**
     * <p> 暴力递归实现 - 递归核心方法 </p>
     * <pre>
     *     问题分析说明:
     *     1. 递归返回值未正确比较：
     *        a. 在你的实现中，maxLen = process(...) 会直接覆盖之前的 maxLen，而没有将所有可能的分支长度进行比较。
     *        b. 即使当前路径中止后，返回值没有正确反映其他路径的最大长度。
     *     2. 未对所有可能的子串分支进行全面递归：
     *        当前递归只处理从当前字符开始的分支，但未尝试从字符串的其他起始位置递归。
     * </pre>
     * @param s
     * @param start
     * @param currentLength
     * @param currentSet
     * @return
     */
    private static int processError(String s, int start, int currentLength, Set<Character> currentSet) {
        // 递归终止条件
        if (start >= s.length()) {
            return currentLength;
        }

        int maxLen = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!currentSet.contains(c)) {
                currentSet.add(c);
                // 递归调用，从下一个字符开始，并增加当前长度
                maxLen = processError(s, i + 1, currentLength + 1, currentSet);
                // 回溯，移除当前字符，以便于下一次迭代
                currentSet.remove(c);
            } else {
                // 一旦遇到重复字符，立即停止当前分支的递归
                break;
            }
        }
        // 返回当前递归分支的最大长度
        return Math.max(currentLength, maxLen);
    }


    /**
     * 暴力递归核心逻辑：从指定起点开始，计算最长子串
     * <p> 逆着计算从某个位置开始的长度 </p>
     * @param s 输入字符串
     * @param start 起点位置
     * @return 从起点开始的最长子串长度
     */
    private static int process(String s, int start) {
        if (start >= s.length()) {
            return 0;
        }

        Set<Character> currentSet = new HashSet<>();
        int maxLen = 0;

        // 逐步构建子串
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!currentSet.contains(c)) {
                currentSet.add(c);
                maxLen = Math.max(maxLen, i - start + 1);
            } else {
                // 遇到重复字符，停止当前子串的扩展
                break;
            }
        }

        // 比较当前子串长度与后续递归子串的长度
        return Math.max(maxLen, process(s, start + 1));
    }


    /**
     * <p> 暴力递归 + Map 缓存实现 </p>
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringRecursiveWithMap(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // 缓存存储：起点 -> 最长子串长度
        Map<Integer, Integer> memo = new HashMap<>();

        // 从每个位置开始，尝试找到最长子串
        return processWithMap(s, 0, memo);
    }

    /**
     * 递归核心逻辑：从指定起点开始，计算最长子串，并使用缓存
     *
     * @param s 输入字符串
     * @param start 起点位置
     * @param memo 缓存存储
     * @return 从起点开始的最长子串长度
     */
    private static int processWithMap(String s, int start, Map<Integer, Integer> memo) {
        // 如果已缓存，直接返回结果
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        // 递归终止条件
        if (start >= s.length()) {
            return 0;
        }

        Set<Character> currentSet = new HashSet<>();
        int maxLen = 0;

        // 构建从当前起点开始的子串
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!currentSet.contains(c)) {
                currentSet.add(c);
                maxLen = Math.max(maxLen, i - start + 1);
            } else {
                // 遇到重复字符，停止扩展
                break;
            }
        }

        // 递归计算后续子串的长度
        int result = Math.max(maxLen, processWithMap(s, start + 1, memo));

        // 缓存结果
        memo.put(start, result);

        return result;
    }


    /**
     * <p> 暴力递归 + Map 缓存实现 </p>
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringRecursiveWithArr(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // 定义一个 dp 数组，用于存储以每个位置开始的最长子串长度
        int[] dp = new int[s.length()];
        // -1 表示尚未计算
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        // 从每个位置开始，尝试找到最长子串
        return processWithArr(s, 0, dp);
    }

    /**
     * 递归核心逻辑：从指定起点开始，计算最长子串，并使用缓存
     *
     * @param s 输入字符串
     * @param start 起点位置
     * @return 从起点开始的最长子串长度
     */
    private static int processWithArr(String s, int start, int[] dp) {
        // 递归终止条件
        if (start >= s.length()) {
            return 0;
        }

        // 如果 dp[start] 已经计算过，直接返回结果
        if (dp[start] != -1) {
            return dp[start];
        }

        Set<Character> currentSet = new HashSet<>();
        int maxLen = 0;

        // 构建从当前起点开始的子串
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!currentSet.contains(c)) {
                currentSet.add(c);
                maxLen = Math.max(maxLen, i - start + 1);
            } else {
                // 遇到重复字符，停止扩展
                break;
            }
        }

        // 递归计算后续子串的长度
        int result = Math.max(maxLen, processWithArr(s, start + 1, dp));

        // 缓存结果
        dp[start] = result;
        return result;
    }

    /**
     * <p> 滑动窗口模板解法 </p>
     * <pre>
     * {@code
     *      // 外层循环扩展右边界，内层循环扩展左边界
     *      for (int l = 0, r = 0 ; r < n ; r++) {
     *          // 当前考虑的元素
     *          // 区间[left,right]不符合题意
     *          while (l <= r && check()) {
     *              // 扩展左边界
     *          }
     *          // 区间[left,right]符合题意，统计相关信息
     *      }
     * }
     * </pre>
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringTemplate(String s) {
        // 滑动窗口
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();
        // 结果
        int res = 0;
        // 每一轮右端点都扩一个 (像虫子一样向右爬行)
        for (int left = 0, right = 0; right < s.length(); right++) {
            // right指向的元素，也是当前要考虑的元素
            char ch = ss[right];
            // set中有ch，则缩短左边界，同时从set集合出元素 (右侧元素发现存在了,则要移动虫子的尾部,一直移动到新元素在虫子身上不存在)
            while (set.contains(ch)) {
                set.remove(ss[left]);
                left++;
            }

            // 虫子移动完毕,将当前元素值添加进新的虫身
            set.add(ss[right]);
            // 计算当前不重复子串的长度 (比较前一次虫子的长度和当前的虫子的长度,更新最大值)
            res = Math.max(res, right - left + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        // // 3
        // String s1 = "abcabcbb";
        // // 1
        // String s2 = "bbbbb";
        // // 3
        // String s3 = "pwwkew";
        // String s4 = "e";
        //
        // // System.out.println(lengthOfLongestSubstringCrude(s1));
        // // System.out.println(lengthOfLongestSubstringCrude(s2));
        // // System.out.println(lengthOfLongestSubstringCrude(s3));
        // System.out.println(lengthOfLongestSubstringCrude(s4));
        //
        // System.out.println(lengthOfLongestSubstring(s1));
        // System.out.println(lengthOfLongestSubstring(s2));
        // System.out.println(lengthOfLongestSubstring(s3));

        // 对撞测试
        int maxLength = 50000;
        int testTime = 10000;

        // int maxLength = 1000;
        // int testTime = 10000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            // 随机字符串
            String str = GenerateDataUtils.generateRandomString(maxLength, "lower");

            // int ans1 = lengthOfLongestSubstringCrude(str);
            // int ans1 = lengthOfLongestSubstringCrude(str);
            // 暴力递归
            // int ans1 = lengthOfLongestSubstringRecursiveCrude(str);
            // 暴力递归 -- 增加缓存优化
            // int ans1 = lengthOfLongestSubstringRecursiveWithMap(str);
            // 缓存优化后 -- 改为数组存储
            // int ans1 = lengthOfLongestSubstringRecursiveWithArr(str);
            // 滑动窗口模板解法
            int ans1 = lengthOfLongestSubstringTemplate(str);
            int ans2 = lengthOfLongestSubstring(str);
            if (ans1 != ans2) {
                System.out.println("测试失败!");
                System.out.println("随机的字符串为: " + str);
                System.out.println("ans1: " + ans1);
                System.out.println("ans2: " + ans2);
                return;
            }
        }
        System.out.println("测试结束！");
    }
}
