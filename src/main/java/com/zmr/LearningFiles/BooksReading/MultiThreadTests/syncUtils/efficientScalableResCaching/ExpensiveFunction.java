package com.zmr.LearningFiles.BooksReading.MultiThreadTests.syncUtils.efficientScalableResCaching;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        // ... 长时间的计算之后
        return new BigInteger(arg);
    }
}
