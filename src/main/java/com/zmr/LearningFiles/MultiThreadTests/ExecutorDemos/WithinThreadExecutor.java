package com.zmr.LearningFiles.MultiThreadTests.ExecutorDemos;

import java.util.concurrent.Executor;

public class WithinThreadExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
         // 在调用线程中以同步的方式执行所有任务的 Executor
         command.run();
    }

    // ... 其他实现
}
