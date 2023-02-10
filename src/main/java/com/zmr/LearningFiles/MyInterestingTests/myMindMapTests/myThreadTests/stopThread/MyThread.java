package main.java.com.zmr.LearningFiles.MyInterestingTests.myMindMapTests.myThreadTests.stopThread;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/12/6 21:21
 */
public class MyThread extends Thread{
    volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println(getName() + " is Running");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("week up for block...");
                // 在异常处理代码中修改共享变量的状态
                stop = true;
            }
        }
        System.out.println(getName() + " is exiting...");
    }
}
