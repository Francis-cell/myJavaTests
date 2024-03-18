package com.zmr.LearningFiles.BooksReading.MultiThreadTests.cancelAndClose;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            // WARNING - 这里不对中断状态进行处理的原因是：
            // 它已经知道线程将要结束，因此在调用栈中已经没有上层代码需要知道中断信息

            // 常见对中断的响应方式：
            // 1、传递异常（可能在执行某个特定域于任务的清除操作之后），从而使你的方法也成为可中断的阻塞方法；
            // 2、恢复中断状态，从而使调用栈中的上层代码能够对其进行处理；
            // Thread.currentThread().interrupt();
        }
    }

    public void cancel() {
        cancelled = true;
    }
}
