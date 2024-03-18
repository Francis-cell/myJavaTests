package com.zmr.LearningFiles.BooksReading.MultiThreadTests.BasicThreadTest;

import javax.annotation.concurrent.GuardedBy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class HiddenIterator {
    @GuardedBy("this") // NotThreadSafe
    private final Set<Integer> set = new HashSet<>();

    private final Set<Integer> setSafe = Collections.synchronizedSet(set);

    public synchronized void add(Integer i) {
        setSafe.add(i);
    }

    public synchronized void remove(Integer i) {
        setSafe.remove(i);
    }

    /**
     * <p> ---test--- </p>
     */
    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            add(r.nextInt());
        }
        System.out.println("DEBUG: add ten elements to " + setSafe);
    }
}
