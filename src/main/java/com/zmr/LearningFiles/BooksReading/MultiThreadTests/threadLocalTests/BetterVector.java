package com.zmr.LearningFiles.BooksReading.MultiThreadTests.threadLocalTests;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Vector;

@ThreadSafe
public class BetterVector<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}
