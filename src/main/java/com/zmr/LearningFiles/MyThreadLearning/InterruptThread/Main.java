package main.java.com.zmr.LearningFiles.MyThreadLearning.InterruptThread;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * 中断线程
 * @date 2023/1/20 21:00
 */
public class Main {
    /**
     * 线程中isInterrupted的使用
     * @throws InterruptedException
     */
    static void test01() throws InterruptedException {
        // 创建一个线程
        Thread t = new Thread(()->{
            // 判断当前线程是否被中断的标志位的状态
            for(;;) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is interrupted;");
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        });

        // 启动线程
        t.start();

        // 线程沉睡2s
        Thread.sleep(2000);

        // 修改线程t的中断标志位
        t.interrupt();
    }


    /***
     * Thread.interrupted()的使用
     * @throws InterruptedException
     */
    static void test02() throws InterruptedException {
        // 创建一个线程
        Thread t = new Thread(()->{
            // 判断当前线程是否被中断的标志位的状态
            for(;;) {
                if (Thread.interrupted()) {
                    System.out.println("Thread is interrupted;");
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });

        // 启动线程
        t.start();

        // 线程沉睡2s
        Thread.sleep(2000);

        // 修改线程t的中断标志位
        t.interrupt();
    }


    /**
     * sleep()、wait()、join()和interrupt的使用
     * 如果在上面三种方法被调用的时候，会被try(InterruptedException e){} catch{}给捕获
     * @throws InterruptedException
     */
    static void test03() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("线程InterruptedException了！");
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });

        t.start();

        t.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        test03();
    }
}
