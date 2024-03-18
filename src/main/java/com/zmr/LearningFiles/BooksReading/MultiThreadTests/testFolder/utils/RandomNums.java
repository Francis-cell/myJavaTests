package com.zmr.LearningFiles.BooksReading.MultiThreadTests.testFolder.utils;

public class RandomNums {
    public static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }
}
