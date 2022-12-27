package myMindMapTests.myThreadTests.stopThread;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/12/6 21:26
 */
public class InterruptThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("Starting thread...");
        myThread.start();
        Thread.sleep(3000);
        System.out.println("Interrupt thread...:" + myThread.getName());
        // 设置共享变量的值为true
        myThread.stop = true;
        // 中断线程
        myThread.interrupt();

        // 主线程休眠3秒以便观察线程myThread的中断情况
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }
}
