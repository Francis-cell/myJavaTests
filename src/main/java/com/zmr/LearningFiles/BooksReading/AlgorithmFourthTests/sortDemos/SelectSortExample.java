package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.sortDemos;

/**
 * <p> 选择排序 </p>
 */
public class SelectSortExample {
    /**
     * <p> 将可排序的数组 a 按照升序进行排序 </p>
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 最小元素的索引
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (SortAboutMethods.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortAboutMethods.exchange(a, i, min);
        }
    }
}
