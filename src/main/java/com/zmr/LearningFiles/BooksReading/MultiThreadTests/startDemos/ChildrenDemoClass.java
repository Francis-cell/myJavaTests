package com.zmr.LearningFiles.BooksReading.MultiThreadTests.startDemos;

public class ChildrenDemoClass extends ParentDemoClass {
    /**
     * 可重入的锁
     */
    public synchronized void doSomething() {
        System.out.println("子类的 doSomething 方法调用！");
        super.doSomething();
    }
}
