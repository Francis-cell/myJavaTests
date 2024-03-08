package com.zmr.LearningFiles.AlgorithmFourthTests.basicDemos;

import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.BasicAbout.In;
import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdIn;
import com.zmr.LearningFiles.AlgorithmFourthTests.MethodsFromBook.BasicAbout.StdOut;

import java.util.Arrays;

public class BinarySearchNew {
    /**
     * <p> key 的而元素如果不在 a 中，那么将返回 -1，否则返回它所在的位置 </p>
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        // 数组必须是有序的
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + (high - low) >> 1;
            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] writeList = In.readInts(args[0]);
        Arrays.sort(writeList);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, writeList) < 0) {
                StdOut.println(key);
            }
        }
    }
}
