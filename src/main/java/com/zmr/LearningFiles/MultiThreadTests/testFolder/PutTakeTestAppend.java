package com.zmr.LearningFiles.MultiThreadTests.testFolder;

import com.zmr.LearningFiles.MultiThreadTests.testFolder.utils.RandomNums;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.TestCase.assertEquals;

public class PutTakeTestAppend {
    private static final ExecutorService pool = Executors.newCachedThreadPool();

    private final AtomicInteger putSum = new AtomicInteger(0);

    private final AtomicInteger takeSum = new AtomicInteger(0);

    private final CyclicBarrier barrier;

    private final BarrierTimer timer;

    private final BoundedBuffer<Integer> bb;

    private final int nTrials, nPairs;

    PutTakeTestAppend(int capacity, int nPairs, int nTrials) {
        this.bb = new BoundedBuffer<Integer>(capacity);
        this.nTrials = nTrials;
        this.nPairs = nPairs;
        this.timer = new BarrierTimer();
        this.barrier = new CyclicBarrier(nPairs * 2 + 1, timer);
    }

    void test() {
        try {
            // 开始之前首先清空一下时间记录器
            timer.clear();
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            // 等待所有线程就绪
            barrier.await();
            // 等待所有线程执行完成
            barrier.await();

            // 获取到每次操作的运行时间（整个运行过程的时间 / 总操作数量）
            long nsPerItem = timer.getTime() / (nPairs * (long) nTrials);
            // 输出每 ns 的吞吐量情况
            System.out.println("Throughput: " + nsPerItem + " ns/item");

            assertEquals(putSum.get(), takeSum.get());
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p> 内部类-生产者 </p>
     */
    class Producer implements Runnable {
        public void run() {
            try {
                int seed = (this.hashCode() ^ (int) System.nanoTime());
                int sum = 0;
                // 设置屏障，等待消费者消费完毕再开始
                barrier.await();
                for (int i = nTrials; i > 0; --i) {
                    bb.put(seed);
                    sum += seed;
                    seed = RandomNums.xorShift(seed);
                }
                putSum.getAndAdd(sum);
                // 设置屏障，等待所有的生产者和消费者都执行完毕
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * <p> 内部类-消费者 </p>
     */
    class Consumer implements Runnable {
       public void run() {
           try {
               // 设置屏障，等待生产者生产完毕再开始
               barrier.await();
               int sum = 0;
               for (int i = nTrials; i > 0 ; --i) {
                   sum += bb.take();
               }
               takeSum.getAndAdd(sum);
               // 设置屏障，等待所有的生产者和消费者都执行完毕
               barrier.await();
           } catch (InterruptedException | BrokenBarrierException e) {
               throw new RuntimeException(e);
           }
       }
    }


    class BarrierTimer implements Runnable {
        private boolean started;

        private long startTime, endTime;

        public synchronized void run() {
            long t = System.nanoTime();
            if (!started) {
                started = true;
                startTime = t;
            } else {
                endTime = t;
            }
        }

        public synchronized void clear() {
            started = false;
        }

        public synchronized long getTime() {
            return endTime - startTime;
        }
    }


    /**
     * <p> 下面方法将会起到以下的作用 </p>
     * <p> 1、生产者-消费者 模式在不同参数组合下的吞吐率； </p>
     * <p> 2、有界缓存在不同线程数量下的可伸缩性； </p>
     * <p> 3、如何选择缓存的大小； </p>
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 每个线程中的测试次数
        int tpt = 100000;
        for (int cap = 1; cap < 1000; cap*=10) {
            System.out.println("Capacity: " + cap);
            for (int pairs = 1; pairs <= 128; pairs *= 2) {
                PutTakeTestAppend t = new PutTakeTestAppend(cap, pairs, tpt);
                System.out.println("Pairs: " + pairs + "\t");
                t.test();
                System.out.println("\t");
                Thread.sleep(1000);
                t.test();
                System.out.println();
                Thread.sleep(1000);
            }
        }
        pool.shutdown();
    }
}
