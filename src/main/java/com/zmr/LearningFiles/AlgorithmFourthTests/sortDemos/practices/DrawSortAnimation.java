package com.zmr.LearningFiles.AlgorithmFourthTests.sortDemos.practices;

import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdDraw;
import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdRandom;
import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.SortAbout.Insertion;

/**
 * <p> 绘制出排序的动画（插入排序、选择排序） </p>
 */
public class DrawSortAnimation {
    /**
     * <p> 插入排序 实现 </p>
     */
    public static void insertionSortInner(Comparable[] arr) throws InterruptedException {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
            Thread.sleep(618);
            StdDraw.setCanvasSize(1000, 512);
            drawRandomArr((Double[]) arr);
        }
    }


    /**
     * <p> 选择排序 实现 </p>
     * @param arr
     */
    public static void selectionSortInner(Comparable[] arr) throws InterruptedException {
        for (int i = 0; i < arr.length; i++) {
            // 找到最小值元素
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
            Thread.sleep(618);
            StdDraw.setCanvasSize(1000, 512);
            drawRandomArr((Double[]) arr);
        }
    }


    /**
     * <p> 比较两个元素的大小 a < b 返回 false，a >= b 返回 true </p>
     * @param a
     * @param b
     * @return
     */
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * <p> 交换数组 arr 中下标在 index1 和 index2 位置的元素 </p>
     * @param arr
     * @param index1
     * @param index2
     */
    private static void swap(Comparable[] arr, int index1, int index2) {
        Comparable tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    /**
     * <p> 绘制当前数组的排序情况 </p>
     * @param arr
     */
    public static void drawArray(Double[] arr) {
        // 绘制当前的数组的条形图
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = arr[i] / 2.0;
            double rw = 0.1 / N;
            double rh = arr[i] / 2.0;
            StdDraw.setCanvasSize(1000, 512);
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static void drawRandomArr(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.setYscale(0.0, 10.0);
            StdDraw.setPenColor(92, 97, 100);
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 自定义数组
        Double[] a = new Double[] {1.1, 1.7, 2.7, 9.1, 3.6, 5.7, 4.6, 5.8, 2.5};

        // 使用生成的随机数组然后进行绘制
        // int N = 30;
        // Double[] a = new Double[N];
        // for (int i = 0; i < N; i++) {
        //     a[i] = StdRandom.random();
        // }

        // drawRandomArr(a);
        // insertionSortInner(a);
        selectionSortInner(a);

        // Insertion.sort(a);

        // drawArray(d);
        // drawRandomArr(a);
    }
}
