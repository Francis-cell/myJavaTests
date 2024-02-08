package com.zmr.LearningFiles.MultiThreadTests.syncUtils.efficientScalableResCaching;

public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
