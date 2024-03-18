package com.zmr.LearningFiles.BooksReading.MultiThreadTests.threadLocalTests;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class MutablePointSafe {
    public final int x, y;

    public MutablePointSafe(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
