package com.zmr.LearningFiles.BooksReading.MultiThreadTests.CASDemos;

import javax.annotation.concurrent.GuardedBy;

/**
 * <p> 模拟 CAS </p>
 */
public class SimulatedCAS {
    @GuardedBy("this")
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
         return (expectedValue == compareAndSwap(expectedValue, newValue));
    }
}
