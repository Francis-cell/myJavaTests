package com.zmr.LearningFiles.MultiThreadTests.ObjectCombinationDemo;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class Counter {
    @GuardedBy("this")
    private long value = 0L;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalArgumentException("Count overflow!");
        }
        return ++value;
    }
}
