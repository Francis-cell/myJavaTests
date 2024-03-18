package com.zmr.LearningFiles.BooksReading.MultiThreadTests.cancelAndClose;

import java.util.concurrent.*;

public class InterruptThreadNew {
    private static final ScheduledExecutorService taskExec =  Executors.newScheduledThreadPool(1);

    /**
     * <p> 下面的方法使用了 Future.cancel(true) </p>
     * <p> 对应的含义如下： </p>
     * <p> Future 拥有一个 cancel 方法，该方法带有一个 boolean 类型的参数 mayInterruptIfRunning，表示取消操作是否成功
     * （这只是表示任务是否能够接收中断，而不是表示任务是否能检测并处理中断） </p>
     * <p> 1、如果这个参数为 true，并且任务当前正在某个线程中运行，那么这个线程能被中断； </p>
     * <p> 2、如果这个参数为 false，那么意味着“若任务还没启动，就不要运行它”，这种方式应该用于那些不处理中断的任务中； </p>
     *
     * <p> 说明：当 Future.get 抛出 InterruptException 或 TimeoutException 时，如果你知道不再需要结果，
     * 那么就可以调用 Future.cancel 来取消任务 </p>
     */
    public static void timeRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        // 将任务提交给一个 ExecutorService，并通过一个定时的 Future.get 来获取结果
        Future<?> task = taskExec.submit(r);

        try {
            task.get(timeout, unit);
        } catch (ExecutionException e) {
            // 如果在任务中抛出了异常，那么重新抛出该异常
            throw launderThrowable(e.getCause());
        } catch (TimeoutException e) {
            // 取消任务
        } finally {
            // 如果任务已经结束，那么执行取消操作也不会带来任何影响
            // 如果任务正在执行，那么将被中断
            task.cancel(true);
        }
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
