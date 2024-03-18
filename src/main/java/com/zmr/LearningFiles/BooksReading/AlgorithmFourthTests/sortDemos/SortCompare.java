package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.sortDemos;

import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdOut;
import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdRandom;
import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.PerformanceAbout.Stopwatch;
import com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.MethodsFromBook.SortAbout.*;

/**
 * <p> 算法性能比较 </p>
 */
public class SortCompare {
    /**
     * <p> 调度指定的排序算法，并返回运行的时间 </p>
     * @param alg
     * @param a
     * @return
     */
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        }
        if (alg.equals("Selection")) {
            Selection.sort(a);
        }
        if (alg.equals("Shell")) {
            Shell.sort(a);
        }
        if (alg.equals("Merge")) {
            Merge.sort(a);
        }
        if (alg.equals("Quick")) {
            Quick.sort(a);
        }
        if (alg.equals("Heap")) {
            Heap.sort(a);
        }
        return timer.elapsedTime();
    }

    /**
     * <p> 随机一个 double 类型元素的数组，然后对它执行指定的排序操作，并返回执行的总时间 </p>
     * @param alg
     * @param N
     * @param T
     * @return
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // 开始一轮测试
            for (int i = 0; i < N; i++) {
                // 生成随机数组
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);

        // 算法1的总时间
        double t1 = timeRandomInput(alg1, N, T);
        // 算法2的总时间
        double t2 = timeRandomInput(alg2, N, T);

        StdOut.printf("For %d random Doubles\n   %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
