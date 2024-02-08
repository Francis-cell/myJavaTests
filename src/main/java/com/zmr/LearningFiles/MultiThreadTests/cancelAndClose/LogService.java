package com.zmr.LearningFiles.MultiThreadTests.cancelAndClose;

import javax.annotation.concurrent.GuardedBy;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

/**
 * <p> 在 LogWriter 基础上解决竞态条件问题（使日志消息的提交操作成为原子操作） </p>
 * <p> 然而不希望在消息加入队列时持有一个锁，因为 put 方法本身就可以阻塞 </p>
 * <p> 采取的方法： </p>
 * <p> 通过原子方式来检查关闭请求，并且有条件的递增一个计数器来“保持”提交消息的权利 </p>
 * <p> 本质上是使用一个计数栈，当栈为空，说明生产者生产的信息都被消费者消费完毕了，那么就可以正常关闭消费者进程了  </p>
 */
public class LogService {
    private final BlockingQueue<String> queue;

    private final LoggerThread loggerThread;

    private final PrintWriter writer;

    @GuardedBy("this")
    private boolean isShutDown;

    @GuardedBy("this")
    private int reservations;

    public LogService(BlockingQueue<String> queue, LoggerThread loggerThread, PrintWriter writer) {
        this.queue = queue;
        this.loggerThread = loggerThread;
        this.writer = writer;
    }

    public void start() {
        loggerThread.start();
    }

    public void stop() {
        synchronized (this) {
            isShutDown = true;
        }
        loggerThread.interrupt();
    }

    public void log (String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutDown) {
                throw new IllegalStateException("has shut down the producer.");
            }
            ++reservations;
        }
        queue.put(msg);
    }


    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        private LoggerThread(PrintWriter writer) {
            this.writer = writer;
        }

        // ...

        public void run() {
            try {
                while (true) {
                    synchronized (LogService.this) {
                        if (isShutDown && reservations == 0) {
                            break;
                        }
                    }
                    String msg = queue.take();
                    synchronized (LogService.this) {
                        --reservations;
                    }
                    writer.println(msg);
                }
            } catch (InterruptedException ignored) {
                /** retry */
            } finally {
                writer.close();
            }
        }
    }
}
