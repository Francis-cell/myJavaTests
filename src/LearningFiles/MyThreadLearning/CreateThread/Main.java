package LearningFiles.MyThreadLearning.CreateThread;

import java.util.concurrent.*;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * 创建线程
 * @date 2023/1/19 20:44
 */
public class Main {
    static class MyThread extends Thread {
        @Override
        public void run () {
            System.out.println("running!");
        }
    }

    static class MyThread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("running!");
        }
    }

    static class MyThread2 implements Callable<String> {
        @Override
        public String call() {
            System.out.println("running!");
            return "success!";
        }
    }


    public static void main(String[] args) {
        // 调用多线程方式
        // 第一种
        new MyThread().start();
        // 第二种
        new Thread(new MyThread1()).start();
        // 第三种-Lambda表达式方式实现
        new Thread(()->{
            System.out.println("running!");
        }).start();


        // 第四种(带返回值)
        Thread t = new Thread(new FutureTask<String>(new MyThread2()));
        t.start();

        // 不使用线程池的方式，获取Call类型带返回值的多线程的返回值
        // TODO 借助FutureTask实现
        try {
            FutureTask<String> task = new FutureTask<String>(new MyThread2());
            Thread tc = new Thread(task);
            tc.start();
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        // 线程池方式
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("running!");
        });

        // 使用线程池装一个callAble类型的线程
        try {
            Future<String> fu= service.submit(new MyThread2());
            String s = fu.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
