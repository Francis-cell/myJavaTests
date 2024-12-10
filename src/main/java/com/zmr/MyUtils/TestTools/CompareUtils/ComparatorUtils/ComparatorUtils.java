package com.zmr.MyUtils.TestTools.CompareUtils.ComparatorUtils;

import com.zmr.MyUtils.TestTools.PrintUtils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;
/**
 * <p> 比较器工具方法 </p>
 */
public class ComparatorUtils {
    /**
     * <p> char 数组比较器 </p>
     * <p> 使用示例说明： </p>
     * <pre>
     *     {@code
     *         // Char 数组比较器（Char 数组的数组）
     *         char[][] arrays = {
     *                 {'d', 'e', 'f'},
     *                 {'a', 'b', 'c'},
     *                 {'a', 'c', 'b'},
     *                 {'b', 'a', 'c'}
     *         };
     *         // 使用比较器对char数组进行排序
     *         Arrays.sort(arrays, new CharArrayComparator());
     *     }
     * </pre>
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

    /**
     * <p> 数组比较器 </p>
     * <p> 使用示例说明： </p>
     * <pre>
     *     {@code
     *         // Character 元素比较器
     *         Character[] chars = new Character[] {'b', 'a', 'c'};
     *         Arrays.sort(chars, new ArrayComparator<>());
     *
     *         // String 元素比较器
     *         String[] strings = new String[] {"abc", "cba", "cab", "bac", "bca"};
     *         Arrays.sort(strings, new ArrayComparator<>());
     *
     *         // Integer 元素比较器
     *         Integer[] integers = new Integer[] {10, 4, 6, 19};
     *         Arrays.sort(integers, new ArrayComparator<>());
     *
     *         // Double 元素比较器
     *         Double[] doubles = new Double[] {10.1, 12.3, 0.7, 5.9};
     *         Arrays.sort(doubles, new ArrayComparator<>());
     *     }
     * </pre>
     * @param <T>
     */
    public static class ArrayComparator<T extends Comparable<T>> implements Comparator<T> {
        @Override
        public int compare(T e1, T e2) {
            // Character 类型
            if (e1 instanceof Character) {
                return (Character) e1 - (Character) e2;
            }
            // String 类型
            if (e1 instanceof String) {
                return ((String) e1).compareTo((String) e2);
            }
            // Integer 类型
            if (e1 instanceof Integer) {
                return (Integer) e1 - (Integer) e2;
            }
            // Double 类型
            if (e1 instanceof Double) {
                Double tmpVal = (Double) e1 - (Double) e2;
                return tmpVal > 0 ? 1 : tmpVal == 0 ? 0 : -1;
            }
            return 0;
        }
    }


    /**
     * <p> 测试 </p>
     * @param args
     */
    public static void main(String[] args) {

        // Char 数组比较器（Char 数组的数组）
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

        // Character 元素比较器
        Character[] chars = new Character[] {'b', 'a', 'c'};
        Arrays.sort(chars, new ArrayComparator<>());
        PrintUtils.printArr(chars);

        // String 元素比较器
        String[] strings = new String[] {"abc", "cba", "cab", "bac", "bca"};
        Arrays.sort(strings, new ArrayComparator<>());
        PrintUtils.printArr(strings);

        // Integer 元素比较器
        Integer[] integers = new Integer[] {10, 4, 6, 19};
        Arrays.sort(integers, new ArrayComparator<>());
        PrintUtils.printArr(integers);

        // Double 元素比较器
        Double[] doubles = new Double[] {10.1, 12.3, 0.7, 5.9};
        Arrays.sort(doubles, new ArrayComparator<>());
        PrintUtils.printArr(doubles);

    }
}
