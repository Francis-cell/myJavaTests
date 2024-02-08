package com.zmr.LearningFiles.MultiThreadTests.syncUtils;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        // 起始门 - 第一个闭锁
        final CountDownLatch startGate = new CountDownLatch(1);
        // 结束门 - 第二个闭锁
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            // 在线程结束之前，告诉“结束门”计数 - 1
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                        // 忽略掉阻塞
                    }
                }
            };

            t.start();
        }

        long start = System.nanoTime();
        // 起始门 - 1，放开所有线程，避免出现创建的多个线程没有同时启动的问题（方便测算整体运行时间）
        startGate.countDown();
        // 结束门 -- 等待计数器值为0 （即会等待所有的线程都执行完成，这样保证线程全部结束了）
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
