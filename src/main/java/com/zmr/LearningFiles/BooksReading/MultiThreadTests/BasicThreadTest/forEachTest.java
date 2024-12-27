package com.zmr.LearningFiles.BooksReading.MultiThreadTests.BasicThreadTest;

import com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTests.genericsTest.entity.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class forEachTest {
    List<Person> personList = Collections.synchronizedList(new ArrayList<Person>());

    // ...

    /**
     * 非线程安全的方法，可能会抛出 ConcurrentModificationException 异常
     */
    public void unSafeTest() {
        for (Person p : personList) {
            // doSomeThing
        }
    }

    /**
     * 对容器进行同步、上锁;
     * 那么在调用 doSomething 时将持有一个锁，这可能会产生死锁;
     * 即使不存在饥饿或者死锁等风险，长时间的对容器加锁也会降低程序的可伸缩性;
     * 持有锁的时间越长，那么在锁上的竞争就可能越激烈，如果许多线程都在等待锁被释放，那么将极大地降低吞吐量和 CPU 的利用率;
     */
    public void safeTest() {
        synchronized (personList) {
            for (Person p : personList) {
                // doSomeThing
            }
        }
    }

    public void cloneAndIterate() {
        // 克隆容器
        List<Person> clonedList;
        synchronized (personList) {
            clonedList = new ArrayList<>(personList);
        }

        // 在克隆的容器上进行迭代操作
        for (Person p : clonedList) {
            // doSomething
        }
    }
}
