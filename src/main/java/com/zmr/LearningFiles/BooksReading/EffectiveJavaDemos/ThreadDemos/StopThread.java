package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.ThreadDemos;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThead = new Thread(() -> {
           int i = 0;
           while (!stopRequested) {
               i++;
           }
        });
        backgroundThead.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
