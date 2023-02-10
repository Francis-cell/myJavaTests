package main.java.com.zmr.LearningFiles.MyThreadLearning.VolatileTests;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * volatile修饰关键字，保证可见性
 * @date 2023/1/21 10:46
 */
public class Main {
    private static volatile boolean running = true;

    private static void m() {
        System.out.println("m start!");
        while (running) {
            //System.out.println("running!");
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(Main::m, "t1").start();
        Thread.sleep(10000);
        running = false;
    }
}
