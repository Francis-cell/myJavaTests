package com.zmr.LearningFiles.MultiThreadTests.BasicThreadTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueExample {
    /**
     * <p> 无界队列 </p>
     */
    public static void unboundedQueueDemo() {
        BlockingQueue<Integer> unboundedQueue = new LinkedBlockingQueue<>();
        new Thread(() -> {
            try {
                unboundedQueue.put(1);
                System.out.println("Produced 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * <p> 有界队列 </p>
     */
    public static void boundedQueueDemo() {
        BlockingQueue<Integer> boundedQueue = new ArrayBlockingQueue<>(1);
        new Thread(() -> {
            try {
                boundedQueue.put(1);
                System.out.println("Produced 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).run();
    }

    /**
     * <p> 同步移交 </p>
     */
    public static void synchronousQueueDemo() {
        BlockingQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                synchronousQueue.put(1);
                System.out.println("Produced 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).run();
    }

    /**
     * <p> {@link HiddenIterator#addTenThings aaaa} </p>
     * <pre>{@code
     *  if (a > 0) {
     *      return 1;
     *  } else if (b > 0) {
     *      return 2;
     *  } else {
     *      return 3;
     *  }
     * }</pre>
     *
     * <pre>
     *     1.步骤1
     *     2.步骤2
     *     3.步骤3
     * </pre>
     */
    public static void main(String[] args) {
        // 无界队列
        unboundedQueueDemo();
        // 有界队列
        boundedQueueDemo();
        // 同步移交
        synchronousQueueDemo();
    }
}
