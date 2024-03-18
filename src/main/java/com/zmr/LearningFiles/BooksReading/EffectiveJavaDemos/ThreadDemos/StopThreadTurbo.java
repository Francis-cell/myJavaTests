package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.ThreadDemos;

import java.util.concurrent.TimeUnit;

/**
 * 注意写和读操作都被同步了
 * 只有读被同步 or 写被同步是不够的，需要两者都被同步，才能保证同步能够起作用
 */
public class StopThreadTurbo {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
           int i = 0;
           while (!stopRequested()) {
               i++;
           }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
