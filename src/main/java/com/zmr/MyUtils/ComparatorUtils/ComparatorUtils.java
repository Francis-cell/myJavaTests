package com.zmr.MyUtils.ComparatorUtils;

import java.util.Arrays;
import java.util.Comparator;
/**
 * <p> 比较器工具方法 </p>
 */
public class ComparatorUtils {
    /**
     * <p> char 数组比较器 </p>
     */
    public static class CharArrayComparator implements Comparator<char[]> {
        @Override
        public int compare(char[] o1, char[] o2) {
            int len1 = o1.length;
            int len2 = o2.length;
            int lim = Math.min(len1, len2);
            int k = 0;

            while (k < lim) {
                char c1 = o1[k];
                char c2 = o2[k];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }
            return len1 - len2;
        }
    }

    public static void main(String[] args) {
        char[][] arrays = {
                {'d', 'e', 'f'},
                {'a', 'b', 'c'},
                {'a', 'c', 'b'},
                {'b', 'a', 'c'}
        };

        // 使用比较器对char数组进行排序
        Arrays.sort(arrays, new CharArrayComparator());

        // 打印排序后的数组
        for (char[] array : arrays) {
            System.out.println(new String(array));
        }
    }
}
