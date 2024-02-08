package com.zmr.LearningFiles.EffectiveJavaDemos.ThreadDemos;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class CountDownLatchDemo {
    public static long time (Executor executor, int concurrency, Runnable action) throws InterruptedException{
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                // Tell time we are ready.
                ready.countDown();
                // Wait till peers are ready.
                try {
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // Tell time we are done.
                    done.countDown();
                }
            });
        }

        // Wait for all workers to be ready.
        ready.await();
        long startNanos = System.nanoTime();
        // And they're off!
        start.countDown();
        // Wait for all workers to finish
        done.await();
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) {

    }
}
