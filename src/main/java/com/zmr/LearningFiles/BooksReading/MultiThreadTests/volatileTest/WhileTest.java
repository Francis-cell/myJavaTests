package com.zmr.LearningFiles.BooksReading.MultiThreadTests.volatileTest;

public class WhileTest {
    public static void main(String[] args) {
        boolean asleep = false;

        while (!asleep) {
            System.out.println("执行！");
            asleep = true;
        }
    }
}
