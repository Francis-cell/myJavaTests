package com.zmr.LearningFiles.BooksReading.MultiThreadTests.cancelAndClose;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 在外部线程中安排中断（不要这样）
 */
public class InterruptThreadOut {
    private static final ScheduledExecutorService cancelExec =  Executors.newScheduledThreadPool(1);

    /**
     * <p>
     *    这种方式很简单，但是却破坏了下面的规则
     *    </p><p>
     *    1、在中断线程前应该了解它的中断策略；
     *    </p><p>
     *    2、由于 timeRun 可以从任意一个线程中调用，因此它无法知道这个调用线程的中断策略，如果任务在超时之前完成，那么中断 timeRun 所在线程
     *    的取消任务将在 timeRun 返回到调用者之后启动；我们不知道在这种情况下将运行什么代码，但结果一定是不好的。
     * </p>
     * @param r
     * @param timeout
     * @param unit
     */
    public static void timeRun(Runnable r, long timeout, TimeUnit unit) {
        // 当前线程都可以调用终端操作，外部的线程的中断策略不一定
        final Thread taskThread = Thread.currentThread();
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);

        r.run();
    }
}
