package com.zmr.LearningFiles.MultiThreadTests.startDemos;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashSet;
import java.util.Set;
import main.java.com.zmr.LearningFiles.BasicJava.genericsTest.entity.Person;


/**
 * 实例封闭
 * PersonSet 是由 HashSet 来管理的，但是 HashSet 不是线程安全的。
 * 但是由于 mySet 是私有的并且不会逸出，因此 HashSet 被封闭在 PersonSet 中。
 * 唯一能访问 mySet 的代码路径是 addPerson 和 containsPerson，在执行它们时都要获得 PersonSet 上的锁;
 * PersonSet 的状态完全由它的内置锁保护，因此 PersonSet 是一个线程安全类
 */
@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }
}
