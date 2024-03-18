package com.zmr.LearningFiles.BooksReading.MultiThreadTests.LockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition serviceClosed = lock.newCondition();
    private boolean isOpen = true;

    public void close() {
        lock.lock();
        try {
            if (!isOpen) {
                // 如果服务已经关闭，则直接返回
                return;
            }
            isOpen = false;
            System.out.println("Service is closing...");

            // 模拟关闭操作的耗时
            Thread.sleep(2000);
            System.out.println("Service closed.");

            // 通知所有等待的线程服务已关闭
            serviceClosed.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void performOperation() {
        lock.lock();
        try {
            // 如果服务已关闭，则等待
            while (!isOpen) {
                System.out.println("Service is closed. Cannot perform operation.");
                serviceClosed.await();
            }
            System.out.println("Performing operation...");

            // 模拟耗时操作
            Thread.sleep(1000);
            System.out.println("Operation completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
