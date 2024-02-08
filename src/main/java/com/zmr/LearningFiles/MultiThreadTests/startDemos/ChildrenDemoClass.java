package com.zmr.LearningFiles.MultiThreadTests.startDemos;

import java.util.concurrent.locks.ReentrantLock;

public class ChildrenDemoClass extends ParentDemoClass {
    /**
     * 可重入的锁
     */
    public synchronized void doSomething() {
        System.out.println("子类的 doSomething 方法调用！");
        super.doSomething();
    }
}
