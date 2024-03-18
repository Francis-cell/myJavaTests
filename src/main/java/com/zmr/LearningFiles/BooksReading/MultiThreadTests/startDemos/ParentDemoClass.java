package com.zmr.LearningFiles.BooksReading.MultiThreadTests.startDemos;

public class ParentDemoClass {
    /**
     * 可重入的锁
     */
    public synchronized void doSomething() {
        System.out.println("父类的 doSomething 方法调用！");
    }
}
