package com.zmr.LearningFiles.MultiThreadTests.appendExamples;


/**
 * <p> 当线程在执行同步代码块或者方法时，如果获取不到内置锁(<code> synchronized </code> 关键字或者 <code> Lock </code> 接口
 * 的实现)，它会被阻塞，等待锁的释放。 </p>
 * <p> 如果此时有另一个线程调用了该线程的 <code> interrupt </code>  方法，那么被阻塞的线程中断状态会被设置，但它仍会继续等待
 * 锁的释放；</p>
 */
public class LockBlockingExample {
    private final Object lock = new Object();

    public void performTask() {
        synchronized (lock) {
            try {
                // 模拟执行任务
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // 中断异常被捕获，单线程继续等待锁的释放
                System.out.println("Thread interrupted while waiting for lock");
            }
        }
    }

    public static void main(String[] args) {
        LockBlockingExample example = new LockBlockingExample();
        Thread blockedThread = new Thread(example::performTask);
        blockedThread.start();

        // 主线程等待一段时间后中断 blockedThread
        try {
            Thread.sleep(1000);
            blockedThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
