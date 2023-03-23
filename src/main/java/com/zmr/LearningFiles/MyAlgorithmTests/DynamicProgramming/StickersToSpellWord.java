package com.zmr.LearningFiles.MyAlgorithmTests.DynamicProgramming;

import java.util.HashMap;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/3/23 22:09
 * @description 贴纸转换成一个单词
 * 贴纸: 字符串数组； 单词: 可以被贴纸数组中的单词剪切出的字母组合出来的字符串
 * 贴纸数量无限
 * 
 * 题目描述：
 * 给定一个字符串str，给定一个字符串类型的数组arr，出现的字符都是小写英文
 * arr每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来
 * 返回需要至少多少张贴纸可以完成这个任务。
 * 例子：str= "babac"，arr = {"ba","c","abcd"}
 * ba + ba + c  3  abcd + abcd 2  abcd+ba 2
 * 所以返回2
 * 
 * 本题测试链接：https://leetcode.com/problems/stickers-to-spell-word
 */
public class StickersToSpellWord {
    /**
     * 暴力递归方式
     * @param stickers 贴纸数组
     * @param target 目标字符串
     * @return 拼接需要的最少贴纸数量
     */
    public static int minStickers1(String[] stickers, String target) {
        int ans = process1(stickers, target);
        // 如果ans为Integer.MAX_VALUE,则认为没有结果
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 暴力递归方式递归方法
     * @param stickers 贴纸数组
     * @param target 目标字符串
     * @return
     */
    public static int process1(String[] stickers, String target) {
        // base case
        // 说明当前已经没有需要进行拼接的字符串了，前面已经完成拼接任务了
        if (target.length() == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        // 从stickers数组中一张一张贴纸作为第一张贴纸开始尝试
        for (String first : stickers) {
            // 将first贴纸加入到组合target的贴纸队列之后，还剩多少字符需要组合
            String rest = minus(target, first);
            // 如果rest和target的长度不一样，说明first参与了target的组合
            if (rest.length() != target.length()) {
                min = Math.min(min, process1(stickers, rest));
            }
        }
        // 使用min + 0或者1 是因为，第一张first还需要根据后面生成的min的值判断决策是否可行，如果不可行，则直接 + 0，否则 + 1
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }
    
    /** 辅助方法：将字符串s1中在字符串s2中出现的字符全部去掉并排序返回 */
    public static String minus(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] count = new int[26];
        // 先将str1中的所有字符计算进入到count数组中
        for (char cha : str1) {
            count[cha - 'a']++;
        }
        // 再将str2中所有字符都从count数组中删除掉
        for (char cha : str2) {
            count[cha - 'a']--;
        }
        // 拼接字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();
    }


    /***
     * 第二步分析：是否可以使用动态规划表，
     * 可以看到process()函数中，动态的变量为target这个字符串，
     * 因为这个字符串是我们递归过程中使用的关键变量，但是字符串最后1位
     * 无法确定究竟是哪个字符，且字符串长度也确定不了，故而要形成的动态
     * 规划表规格是无法确定的，所以只能使用傻缓存方式处理(参看第三种处理)
     */
    public static int minStickers2(String[] stickers, String target) {
        int N = stickers.length;
        // TODO--优化点1：关键词优化（使用词频表代替贴纸数组）
        int[][] counts = new int[N][26];
        for (int i = 0; i < N; i++) {
            char[] str = stickers[i].toCharArray();
            for (char cha : str) {
                counts[i][cha - 'a']++;
            }
        }
        
        // 初始化傻缓存结构
        HashMap<String, Integer> dp = new HashMap<>();
        // 当target到末尾的时候，让傻缓存中的值为""即可
        dp.put("", 0);
        
        int ans = process2(counts, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 使用傻缓存方式处理时--对应的递归方式
     * @param stickers 贴纸数组
     * @param target 目标字符串
     * @param dp 使用哈希表做的傻缓存结构
     * @return
     */
    public static int process2(int[][] stickers, String target, HashMap<String, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        
        char[] targetChar = target.toCharArray();
        // TODO--优化2：将目标字符串也转换成一个数组记录，方便相减
        int[] targetCounts = new int[26];
        for (char cha : targetChar) {
            targetCounts[cha - 'a']++;
        }
        
        // TODO--【重要-剪枝操作】优化3：例如target第一个字符为a,则只要包含字符a的字符串，其余的都不参与
        int N = stickers.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            // 当前的贴纸
            int[] sticker = stickers[i];
            // 当前的贴纸包含目标字符串的第一个字符
            if (sticker[targetChar[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    // 说明目标字符串中还有当前字符串没有消去但是能消去的字符
                    if (targetCounts[j] > 0) {
                        // 可以被消去的某种字符数量
                        int nums = targetCounts[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                // 继续向下求出所有支路的最小值（即需要的贴纸数量的最小值）
                min = Math.min(min, process2(stickers, rest, dp));
            }
        }
        // 求出包含当前位置开始需要的贴纸的最小值，并记录进缓存中
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(target, ans);
        return ans;
    }


    public static void main(String[] args) {
        String[] strs = new String[] {"a", "abc", "bcd", "adrf", "erf", "werd", "etcs"};
        String target = "acrfce";

        System.out.println(minStickers1(strs, target));
        System.out.println(minStickers2(strs, target));
    }
}
