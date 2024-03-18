package com.zmr.LearningFiles.BooksReading.MultiThreadTests.threadLocalTests;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这个方法不是线程安全的：
 * 方法存在的问题：
 * 1、没有维持对下界和上界进行越是的不变性条件；
 * 2、setLower 和 setUpper 都尝试维持不变性条件，但却无法做到；
 * 3、两者都是“先检查后执行”的操作，但是没有使用足够的加锁机制来保证在这些操作的原子性
 *
 * 状态变量 lower 和 upper 不是彼此独立的，因此 NumberRange 不能将线程安全性委托给它的线程安全状态变量
 */
@NotThreadSafe
public class NumberRange {
    // 不变性条：lower <= upper
    private final AtomicInteger lower = new AtomicInteger();
    private final AtomicInteger upper = new AtomicInteger();

    public void setLower(int i) {
        // Warning: 不安全的“先检查后执行”
        if (i > upper.get()) {
            throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        // Warning: 不安全的“先检查后执行”
        if (i < lower.get()) {
            throw new IllegalArgumentException("Can't set upper to " + i + " < lower");
        }
        upper.set(i);
    }
}
