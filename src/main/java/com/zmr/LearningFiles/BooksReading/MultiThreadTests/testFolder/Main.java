package com.zmr.LearningFiles.BooksReading.MultiThreadTests.testFolder;

import com.zmr.LearningFiles.BooksReading.MultiThreadTests.testFolder.utils.RandomNums;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            int j = RandomNums.xorShift(i);
            System.out.println(j);
        }
    }
}
