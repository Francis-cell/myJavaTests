package com.zmr.LearningFiles.OneWeekPlaning.Greedy.PartOfBackpack;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一和零
 * https://leetcode.cn/problems/ones-and-zeroes/description/
 */
public class OneAndZero {
    /**
     * 单个元素类
     */
    static class Item {
        /** 0 的数量 */
        int numZero;
        /** 1 的数量 */
        int numOne;
        /** 性价比i */
        double ratio;

        public Item(int numZero, int numOne) {
            this.numOne = numOne;
            this.numZero = numZero;
            this.ratio = numOne != 0 ? (double) numZero / numOne : 0.0;
        }

        public double getRatio() {
            return ratio;
        }
    }

    /**
     * 找到最大子集，再 strs 中找到子集满足：最多有 m 个 0和 n 个 1
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int ans = 0;
        // 先将 strs 字符串数组转换成对于 0 和 1 的计数的二维数组
        int[][] numZeroAndOneArr = convertNumArr(strs);

        // 性价比当作 NumZero / NumOne
        Item[] items = new Item[numZeroAndOneArr.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(numZeroAndOneArr[i][0], numZeroAndOneArr[i][1]);
        }

        // 按照性价比排序
        Arrays.sort(items, Comparator.comparingDouble(Item::getRatio).reversed());
        // Arrays.sort(items, Comparator.comparingDouble(Item::getRatio));

        // 当前 0 的总数
        int currentNumZero = 0;
        // 当前 1 的总数
        int currentNumOne = 0;
        for (Item item : items) {
            if (currentNumZero + item.numZero <= m && currentNumOne + item.numOne <= n) {
                currentNumZero += item.numZero;
                currentNumOne += item.numOne;
                ans++;
            }
        }
        return ans;
    }

    /**
     * <p> 将 {"10", "0001", "111001", "1", "0"} 的 String 类型的数组转换成整型的 二维数组
     * 这个二维数组的第一个元素为 0 的数量，第二个元素为 1 的数量 </p>
     * @param strs 要处理的字符串数组
     * @return
     */
    private static int[][] convertNumArr(String[] strs) {
        int size = strs.length;
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            String str = strs[i];
            int len = str.length();
            int numZero = 0;
            int numOne = 0;
            for (int j = 0; j < len; j++) {
                if (str.charAt(j) == '0') {
                    numZero++;
                } else {
                    numOne++;
                }
            }
            ans[i][0] = numZero;
            ans[i][1] = numOne;
        }
        return ans;
    }

    public static void main(String[] args) {
        // String[] strs = {"10", "0001", "111001", "1", "0"};
        String[] strs = {"111","1000","1000","1000"};
        // String[] strs = {"10","0","1"};
        // int m = 5, n = 3;
        // int m = 1, n = 1;
        int m = 9, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }
}
