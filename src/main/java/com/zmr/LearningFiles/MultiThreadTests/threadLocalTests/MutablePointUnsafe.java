package com.zmr.LearningFiles.MultiThreadTests.threadLocalTests;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class MutablePointUnsafe {
    public int x, y;

    public MutablePointUnsafe() {
        x = 0;
        y = 0;
    }

    public MutablePointUnsafe(MutablePointUnsafe p) {
        this.x = p.x;
        this.y = p.y;
    }
}
