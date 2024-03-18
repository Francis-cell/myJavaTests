package com.zmr.LearningFiles.BooksReading.MultiThreadTests.syncUtils.efficientScalableResCaching;

public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
