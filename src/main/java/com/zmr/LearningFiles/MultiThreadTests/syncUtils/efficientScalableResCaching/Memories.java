package com.zmr.LearningFiles.MultiThreadTests.syncUtils.efficientScalableResCaching;

import javax.annotation.concurrent.GuardedBy;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     这段代码拥有糟糕的并发性，<code> compute </code> 方法采用了 <code> synchronized </code> 关键字 的加锁方式，
 *     可能出现的问题情况如下所示：
 * </p>
 * <p> A -----> [computed (a + b)] </p>
 * <p> B ----------------------------> [computed (a + b)] </p>
 * <p> C --------------------------------------------------> [get memory data (a + b)] </p>
 */
public class Memories<A, V> implements Computable<A, V>{
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<A, V>();

    private final Computable<A, V> c;

    public Memories(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
