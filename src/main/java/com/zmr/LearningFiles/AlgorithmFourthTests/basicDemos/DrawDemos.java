package com.zmr.LearningFiles.AlgorithmFourthTests.basicDemos;

import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdDraw;
import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdRandom;

import java.awt.*;
import java.util.Arrays;

/**
 * <p> StdDraw 绘图 </p>
 */
public class DrawDemos {
    /**
     * <p> 函数值绘制 </p>
     */
    public static void drawFun() {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 0; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
        }
    }

    /**
     * <p> 随机数组绘制 </p>
     */
    public static void drawRandomArr() {
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.random();
        }
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;

            StdDraw.setPenColor(randomRGB());
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    /**
     * <p> 绘制已经排序完成的随机数组 </p>
     */
    public static void drawSortedRandomArr() {
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.random();
        }

        Arrays.sort(a);

        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;

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

    public static void main(String[] args) {
        // drawFun();
        drawRandomArr();
        // drawSortedRandomArr();
    }
}
