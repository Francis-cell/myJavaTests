package com.zmr.LearningFiles.MultiThreadTests.ConditionQueue;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {
    // 条件谓词： not-full (!isFull())
    // 条件谓词： not-empty (!isEmpty())

    // public BoundedBuffer(int size) {
    //     super(size);
    // }
}
