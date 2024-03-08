package com.zmr.LearningFiles.AlgorithmFourthTests.sortDemos;

import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdDraw;

import java.awt.*;

/**
 * <p> 希尔排序 </p>
 * <p> 概念补充： </p>
 * <p> h 有序数组：使数组中任意间隔为 h 的元素都是有序的
 * (注意此处是“间隔 h 的元素”，而不是在“间隔 h 范围内的所有元素”)</p>
 */
public class ShellSortExample {
    /**
     * <p> Shell 排序主体 </p>
     * @param a
     */
    public static void sort(int[] a) {
        // 将 a[] 按照升序进行排序
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            // 1、4、13、40、121、364、1093...
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // 开始之前打印一下数组中元素的情况
            drawArray(a);
            // 将数组变为 h 有序
            for (int i = h; i < N; i++) {
                // 将 a[i] 插入到 a[i - h]、a[i - 2 * h]、a[i - 3 * h]... 之
                for (int j = i; j >= h && SortAboutMethods.less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    /**
     * <p> 交换在可比较数组 a 中下标在 i 和 j 位置的元素 </p>
     * @param a
     * @param i
     * @param j
     */
    public static void exchange(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * <p> 将当前的数组绘制成条形图 </p>
     * @param a
     */
    public static void drawArray(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 5.0;

            System.out.printf("x: %f, y: %f\n", x, y);

            StdDraw.setPenColor(randomRGB());
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    /**
     * <p> 随机一个颜色 </p>
     * @return
     */
    public static Color randomRGB() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }

    /**
     * <p> 随机数组 </p>
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int size = (int) (Math.random() * (maxSize + 1));
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = (int) (Math.random() * (maxValue + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 50;
        int[] arr = generateRandomArray(maxSize, maxValue);
        sort(arr);
    }
}
