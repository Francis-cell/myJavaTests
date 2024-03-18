package com.zmr.LearningFiles.BooksReading.MultiThreadTests.ExecutorDemos;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectedExecutionHandlerDemo {
    public static void main(String[] args) {
        final int N_THREADS = 100;
        final int CAPACITY = 1000;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(N_THREADS, N_THREADS,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(CAPACITY));

        // 设置为 调用者执行的方式
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
