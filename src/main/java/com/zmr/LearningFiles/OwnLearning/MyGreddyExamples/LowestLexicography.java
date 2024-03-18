package com.zmr.LearningFiles.OwnLearning.MyGreddyExamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ClassName LowestLexicography
 * @Description 【贪心算法】给定一个字符串数组，求解这些字符拼接出来的在字典序中最小值的字符串
 * @Author zhumengren
 **/
public class LowestLexicography {
    /** 暴力解法 */
    public static String lowestString1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        TreeSet<String> ans = process(strs);
        return ans.size() == 0 ? "" : ans.first();
    }
    
    /** 
     * 返回strs字符串数组全排列的可能结果 
     * 使用TreeSet作为返回值类型的原因：TreeSet天然具备字典序的排序方式，
     * 处理完成之后直接返回TreeSet的第一个位置的值即可
     */
    public static TreeSet<String> process(String[] strs) {
        TreeSet<String> ans = new TreeSet<>();
        if (strs.length == 0) {
            // 防止strs.length == 0情况下没有值，需要特殊处理一下
            ans.add("");
            return ans;
        }
        for (int i = 0; i < strs.length; i++) {
            // 获取当前位置上strs的元素的值
            String first = strs[i];
            // 获得strs移除i位置上元素之后的数组
            String[] nexts = removeIndexString(strs, i);
            // 计算移除i位置之后递归底层产生的所有的ans的值
            TreeSet<String> next = process(nexts);
            // 将next中的所有字符串连接起来
            for (String cur : next) {
                ans.add(first + cur);
            }
        }
        return ans;
    }
    
    /** 辅助方法(移除数组中某个字符串，剩余的字符串数组作为返回值) */
    public static String[] removeIndexString(String[] arr, int index) {
        int N = arr.length;
        // 因为移除了一个元素，所以 新的字符串数组的长度 = 原本的字符串长度 - 1
        String[] ans = new String[N - 1];
        int ansIndex = 0;
        for (int i = 0; i < N; i++) {
            if (i != index) {
                ans[ansIndex++] = arr[i];
            }
        }
        return ans;
    }
    
    
    /** 贪心解法(比较器) */
    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }
    
    public static String lowestString2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 使用比较器将strs进行排序
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
    
    /** 随机生成字符串 */
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int)(Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 5);
            // 如果随机数 <= 0.5，则产生小写字母，否则产生大写字母
            ans[i] = (Math.random() <= 0.5) ? (char) (65 + value) : (char) (97 + value);
        }
        return String.valueOf(ans);
    }
    
    /** 随机生成字符串数组 */
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }
    
    /** 数组拷贝方法 */
    public static String[] copyStringArray(String[] arr) {
        String[] ans = new String[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = String.valueOf(arr[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        //String[] strs = new String[] {"ba", "b"};
        //System.out.println(lowestString1(strs));
        
        //String str1 = "bab";
        //String str2 = "bba";
        //System.out.println(str1.compareTo(str2));
        
        
        int arrLen = 6;
        int strLen = 5;
        int testTimes = 100000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机生成字符串数组、拷贝、比较最小拼接字符结果是否一致
            String[] arr1 = generateRandomStringArray(arrLen, strLen);
            String[] arr2 = copyStringArray(arr1);
            
            if (!lowestString1(arr1).equals(lowestString2(arr2))) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
