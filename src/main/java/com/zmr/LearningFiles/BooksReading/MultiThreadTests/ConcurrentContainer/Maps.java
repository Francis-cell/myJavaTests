package com.zmr.LearningFiles.BooksReading.MultiThreadTests.ConcurrentContainer;


import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这里主要比较 ConcurrentHashMap && 同步的加锁的 Map（Hashtable、synchronizedMap） 之间的区别
 * ConcurrentHashMap:
 * <p>
 *   1、并不是将每个方法都在同一个锁上同步并使得每次只能有一个线程访问容器，而是使用一种粒度更细的加锁机制
 *   来实现更大程度的共享，这种机制称为分段锁（Lock Striping）；
 * </p><p>
 *   2、任意梳理的读取线程可以并发访问 Map，执行读取操作的线程和执行写入操作的线程可以并发的访问 Map，并且
 *   一定数量的写入线程可以并发地修改Map；
 *</p>
 *
 * 同步的加锁的 Map（Hashtable、synchronizedMap）:
 * <p>
 * 1、获得 Map 的锁能防止其他线程访问这个 Map；
 * </p>
 * <p>
 * 2、在一些不常见的功能上需要使用这种功能，例如通过原子方式添加一些映射，或者对 Map 迭代若干次并在此期间
 *   保持元素顺序相同；
 * </p>
 */
public class Maps {
    public static void concurrentHashMapTest() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                // 使用 put 方法时，ConcurrentHashMap 会自动进行分段锁定
                concurrentHashMap.put("Key" + i, i);
            }
        };

        // 创建多个线程同时对 concurrentHashMap 进行操作
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ConcurrentHashMap size:" + concurrentHashMap.size());
    }

    public static void HashTableTest() {
        Hashtable<String, Integer> hashTable = new Hashtable<>();

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                // 手动进行同步操作上锁
                synchronized (hashTable) {
                    hashTable.put("Key" + i, i);
                }
            }
        };

        // 创建多个线程同时对 concurrentHashMap 进行操作
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("HashTable size: " + hashTable.size());
    }

    public static void synchronizedMapTest() {
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                // 手动进行同步操作上锁
                synchronized (synchronizedMap) {
                    synchronizedMap.put("Key" + i, i);
                }
            }
        };

        // 创建多个线程同时对 concurrentHashMap 进行操作
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("SynchronizedMap size: " + synchronizedMap.size());
    }

    public static void main(String[] args) {
        concurrentHashMapTest();
        HashTableTest();
        synchronizedMapTest();
    }
}
