package com.zmr.LearningFiles.BooksReading.MultiThreadTests.CASDemos;

import java.util.concurrent.atomic.AtomicReference;

/**
 * <p> 单例模式的的实现 </p>
 */
public class SingleTonAtomicReference {
    private static final AtomicReference<SingleTonAtomicReference> INSTANCE = new AtomicReference<>();

    private SingleTonAtomicReference() {
        // 私有构造
        // ... 省略其他写法
    }

    public static SingleTonAtomicReference getInstance() {
        SingleTonAtomicReference instance = INSTANCE.get();
        do {
            instance = new SingleTonAtomicReference();
        }
        while (INSTANCE.compareAndSet(null, instance));
        return instance;
    }
}
