package com.zmr.LearningFiles.BooksReading.MultiThreadTests.cancelAndClose;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {
    private static volatile boolean needPrime = false;

    /**
     * PrimeGenerator 方法配套测试方法
     * @return
     * @throws InterruptedException
     */
    public static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }


    /**
     * BrokenPrimeProducer 方法配套测试方法
     * @throws InterruptedException
     */
    public static void consumePrimes() throws InterruptedException {
        BlockingQueue<BigInteger> primes = new PriorityBlockingQueue<>();
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();
        try {
            while (needMorePrimes()) {
                consume(primes.take());
            }
        } finally {
            producer.cancel();
        }
    }

    private static void consume(BigInteger take) {
    }

    private static boolean needMorePrimes() {
        return needPrime;
    }


    public static void main(String[] args) throws InterruptedException{
        long start = System.nanoTime();
        List<BigInteger> ans = aSecondOfPrimes();
        long end = System.nanoTime();
        for (BigInteger bi : ans) {
            System.out.println(bi);
        }
        System.out.println("The number of generated primes is:" + ans.size());
        // 转换为以 毫秒 为单位的结果
        System.out.println("The run time of generated primes is:" + (end - start) / 1e6 + "毫秒");
        // 转换为以 秒 为单位的结果
        System.out.println("The run time of generated primes is:" + (end - start) / 1e9 + "秒");
    }
}
