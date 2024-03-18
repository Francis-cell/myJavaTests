package com.zmr.LearningFiles.BooksReading.MultiThreadTests.threadLocalTests;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * 这个方法有一个注意点：
 * SafePoint(SafePoint p) 方法的实现不能使用 this(p.x, p.y)，因为这样将会产生 竞态条件
 * 使用本例中的方法将会和避免产生竞态条件
 */
@ThreadSafe
public class SafePoint {
    @GuardedBy("this")
    private int x, y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[] { x, y };
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
