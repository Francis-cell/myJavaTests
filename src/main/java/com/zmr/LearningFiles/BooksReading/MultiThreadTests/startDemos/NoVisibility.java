package com.zmr.LearningFiles.BooksReading.MultiThreadTests.startDemos;

/**
 * 类没有使用同步的变量
 * 1、写线程修改了变量a的值[没有同步]；
 * 2、读线程读取变量a的值[会读取到之前的值]；
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        // 读线程开启循环获取
        new ReaderThread().start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // 如果线程在休眠期间被中断，会抛出 InterruptedException 异常
            throw new RuntimeException(e);
        }
        // 写线程写入数据
        number = 42;
        ready = true;
    }
}
