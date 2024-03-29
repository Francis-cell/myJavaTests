package com.zmr.LearningFiles.BooksReading.MultiThreadTests.CASDemos;

import javax.annotation.concurrent.ThreadSafe;

/**
 * <p> 非阻塞的计数器 </p>
 */
@ThreadSafe
public class CASCounter {
    private SimulatedCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        }
        while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }
}
