package com.zmr.LearningFiles.BooksReading.MultiThreadTests.threadLocalTests;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NotThreadSafe
public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    // ...

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (!absent) {
                list.add(x);
            }
            return absent;
        }
    }

    public synchronized boolean putIfAbsentNotSafe(E x) {
        boolean absent = !list.contains(x);
        if (!absent) {
            list.add(x);
        }
        return absent;
    }
}
