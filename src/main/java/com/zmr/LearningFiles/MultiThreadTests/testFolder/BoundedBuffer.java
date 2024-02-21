package com.zmr.LearningFiles.MultiThreadTests.testFolder;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.Semaphore;

/**
 * <p> 在实际情况下，应该使用 ArrayBlockingQueue 或者 LinkedBlockingQueue，而不是自己编写 </p>
 * @param <E>
 */
@ThreadSafe
public class BoundedBuffer<E> {
    private final Semaphore availableItems, availableSpaces;

    @GuardedBy("this")
    private final E[] items;

    @GuardedBy("this")
    private int putPosition = 0, takePosition = 0;

    public BoundedBuffer(int capacity) {
        availableItems = new Semaphore(0);
        availableSpaces = new Semaphore(capacity);
        items = (E[] ) new Object[capacity];
    }

    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull() {
        return availableSpaces.availablePermits() == 0;
    }

    public void put(E x) throws InterruptedException {
        // 剩余空间-信号量值 - 1
        availableSpaces.acquire();
        // 插入元素
        doInsert(x);
        // 元素-信号量值 + 1
        availableItems.release();
    }

    public E take() throws InterruptedException {
        // 元素-信号量值 - 1
        availableItems.acquire();
        // （循环）移除单个元素
        E item = doExtract();
        // 剩余空间-信号量值 + 1
        availableSpaces.release();
        return item;
    }

    private synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : i;
    }

    private synchronized E doExtract() {
        int i = takePosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return x;
    }
}
