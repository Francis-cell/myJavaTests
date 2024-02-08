package com.zmr.LearningFiles.MultiThreadTests.syncUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundedHashSet<T> {
    private final Set<T> set;

    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        // 阻塞，直到获得了许可
        sem.acquire();
        boolean wasAdded = false;
        try {
            // 添加许可，set 中如果存在了对应的许可，将会然后就 false (因此这个许可只能被获取一次)
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded) {
                // 如果获得的许可的值为 false，那么直接释放当前的信号量
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            sem.release();
        }
        return wasRemoved;
    }
}
