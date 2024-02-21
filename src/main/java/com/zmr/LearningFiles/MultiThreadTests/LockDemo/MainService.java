package com.zmr.LearningFiles.MultiThreadTests.LockDemo;

public class MainService {
    public static void main(String[] args) {
        ServiceDemo serviceDemo = new ServiceDemo();

        // 开启两个线程进行操作
        Thread thread1 = new Thread(serviceDemo::performOperation);
        Thread thread2 = new Thread(serviceDemo::close);
        Thread thread3 = new Thread(serviceDemo::performOperation);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
