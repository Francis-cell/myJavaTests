package com.zmr.LearningFiles.AlgorithmFourthTests.sortDemos;

/**
 * <p> 插入排序 </p>
 */
public class InsertSortExample {
    public static void sort(Comparable[] a) {
        // 升序排序 a
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将当前元素 a[i] 和 a[0] 到 a[i - 1] 上的元素进行比较
            for (int j = i; j > 0 && SortAboutMethods.less(a[j], a[j-1]); j--) {
                SortAboutMethods.exchange(a, j, j - 1);
            }
        }
    }
}
