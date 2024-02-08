package com.zmr.LearningFiles.MultiThreadTests.cancelAndClose;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static reactor.core.Scannable.Attr.CAPACITY;

public class LogWriter {
    private final BlockingQueue<String> queue;

    private final LoggerThread logger;

    private boolean shutdownRequested;

    public LogWriter(PrintWriter writer) {
        this.queue = new LinkedBlockingQueue<String>((Collection<? extends String>) CAPACITY);
        this.logger = new LoggerThread(writer);
    }

    public void start() {
        logger.start();
    }

    /**
     * <p> 如果想要使得当前工具类在软件产品中能发挥出实际的作用，还需要实现一种终止日志线程的方法，从而避免 JVM 无法被正常关闭 </p>
     */
    // public void log(String msg) throws InterruptedException {
    //     queue.put(msg);
    // }


    /**
     * <p> 这种方式存在“竞态条件”，所以这个方法并不可靠  </p>
     * <p> log 的实现是一种“先判断再运行”的代码序列： </p>
     * <p> 生产者发现该服务还没有关闭，因此在关闭服务后仍然会将日志消息放入队列，这同样会使得生产者可能在调用log时阻塞并无法
     * 解除阻塞状态。</p>
     * <p> 可以通过一些技巧来降低这种情况发生的概率（例如在宣布队列被清空之前，让消费者等待数秒钟），但这些都没有解决问题的
     * 本质，即使很小的概率也可能导致程序发生故障</p>
     */
    public void log(String msg) throws InterruptedException {
        if (!shutdownRequested) {
            queue.put(msg);
        } else {
            throw new IllegalStateException("logger is shut down.");
        }
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
                    writer.println(queue.take());
                }
            } catch (InterruptedException ignored) {
            } finally {
                writer.close();
            }
        }
    }
}
