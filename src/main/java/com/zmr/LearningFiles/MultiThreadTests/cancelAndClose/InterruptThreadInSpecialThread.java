package com.zmr.LearningFiles.MultiThreadTests.cancelAndClose;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>在专门的线程中中断任务: </p>
 * <p>
 *     执行任务的线程拥有自己的执行策略，即使任务不响应中断，显示运行的方法仍能返回到它的调用者；
 * </p>
 * <p>
 *     在启动任务线程后，timeRun 将执行一个限时的 join 方法。在 join 返回后，它将检查任务中
 *     是否有异常抛出，如果有的话，则会在调用 timeRun 的线程中再次抛出该异常；
 * </p>
 * <p>
 *     由于 Throwable 将在两个线程之间共享，因此该变量被声明为 volatile 类型，从而确保安全地
 *     将其从任务线程发布到 timeRun 线程；
 * </p>
 */
public class InterruptThreadInSpecialThread {
    private static final ScheduledExecutorService cancelExec =  Executors.newScheduledThreadPool(1);

    public static void timeRun(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        class ReThrowAbleTask implements Runnable {
            private volatile Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            void reThrow() {
                if (t != null) {
                    throw launderThrowable(t);
                }
            }
        }

        ReThrowAbleTask task = new ReThrowAbleTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.reThrow();
    }

    /**
     * <p>
     *      如果 Throwable 是 Error，那么抛出它；
     * </p>
     * <p>
     *      如果是 RuntimeException，那么返回它；
     * </p>
     * <p>
     *      否则抛出 IllegalArgumentException；
     * </p>
     */
    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new IllegalArgumentException("Not unchecked", t);
        }
    }
}
