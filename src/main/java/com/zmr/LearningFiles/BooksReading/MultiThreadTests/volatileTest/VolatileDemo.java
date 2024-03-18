package com.zmr.LearningFiles.BooksReading.MultiThreadTests.volatileTest;

import java.util.concurrent.ExecutorService;

public class VolatileDemo {
    private volatile long value;

    @org.junit.Test
    public void testAtomicLong() {
        // 并发任务数
        final int TASK_AMOUNT = 10;

        // 线程池，获取 CPU 密集型任务线程池
        // ExecutorService pool = ThreadUtil.getCpuIntenseTargetThreadPool();
    }
}
