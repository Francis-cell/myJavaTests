package com.zmr.LearningFiles.MultiThreadTests.ExecutorDemos;

import java.util.concurrent.Executor;

public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        // 为每一个请求都创建新线程的 Executor
        new Thread(command).start();
    }

    // ... 其余实现
}
