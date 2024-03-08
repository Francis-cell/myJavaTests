package com.zmr.LearningFiles.AlgorithmFourthTests.sortDemos;

import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdOut;

/**
 * <p> 排序相关的方法 </p>
 */
public class SortAboutMethods {
    /**
     * <p> 比较两个元素的大小，如果是负值，则前者小于后者，如果等于0，则两者相等，如果大于0，则前者大于后者 </p>
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * <p> 交换在可比较数组 a 中下标在 i 和 j 位置的元素 </p>
     * @param a
     * @param i
     * @param j
     */
    public static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * <p> 打印可比较数组 a 中的所有元素 </p>
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    /**
     * <p> 检查可比较数组中元素是否已经排序 </p>
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
}
