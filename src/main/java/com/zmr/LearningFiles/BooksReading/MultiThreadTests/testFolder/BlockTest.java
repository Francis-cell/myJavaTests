package com.zmr.LearningFiles.BooksReading.MultiThreadTests.testFolder;

import static org.junit.Assert.assertFalse;

public class BlockTest {
    private final int LOCKUP_DETECT_TIMEOUT = 10;

    public void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);

        Thread taker = new Thread() {
            public void run() {
                try {
                    int unused = bb.take();
                    failed();
                } catch (InterruptedException success) {
                    // 阻塞了说明是正常的
                }
            }
        };

        try {
            taker.start();
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            taker.interrupt();
            taker.join(LOCKUP_DETECT_TIMEOUT);
            assertFalse(taker.isAlive());
        } catch (InterruptedException e) {
            failed();
        }
    }

    void failed() {
        System.out.println("Failed!");
    }
}
