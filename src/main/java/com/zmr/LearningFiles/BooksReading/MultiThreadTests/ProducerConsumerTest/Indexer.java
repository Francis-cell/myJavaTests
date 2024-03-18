package com.zmr.LearningFiles.BooksReading.MultiThreadTests.ProducerConsumerTest;

import java.io.File;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable {
    private final BlockingQueue<File> queue;


    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                indexFile(queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // 其他方法
    private void indexFile(File take) {

    }
}
