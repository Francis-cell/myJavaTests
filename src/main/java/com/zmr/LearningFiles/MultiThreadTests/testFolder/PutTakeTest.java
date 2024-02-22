package com.zmr.LearningFiles.MultiThreadTests.testFolder;

import com.zmr.LearningFiles.MultiThreadTests.testFolder.utils.RandomNums;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.TestCase.assertEquals;

public class PutTakeTest {
    private static final ExecutorService pool = Executors.newCachedThreadPool();

    private final AtomicInteger putSum = new AtomicInteger(0);

    private final AtomicInteger takeSum = new AtomicInteger(0);

    private final CyclicBarrier barrier;

    private final BoundedBuffer<Integer> bb;

    private final int nTrials, nPairs;

    PutTakeTest (int capacity, int nPairs, int nTrials) {
        this.bb = new BoundedBuffer<Integer>(capacity);
        this.nTrials = nTrials;
        this.nPairs = nPairs;
        this.barrier = new CyclicBarrier(nPairs * 2 + 1);
    }

    void test() {
        try {
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            // 等待所有线程就绪
            barrier.await();
            // 等待所有线程执行完成
            barrier.await();
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

    public static void main(String[] args) {
        new PutTakeTest(10, 10, 100000).test();
        pool.shutdown();
    }
}
