package com.zmr.LearningFiles.MultiThreadTests.syncUtils.efficientScalableResCaching;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *     这种方式存在的问题为：如果一个线程启动了一个开销很大的计算，其他线程不知道这个线程正在进行，那么很有可能会重复这个计算
 * </p>
 * <p> 问题：两个线程可能会去计算相同的值 </p>
 * <p> A [f(1)不在缓存中]----> [---------计算f(1)---------]------[将f(1)放入缓存]---> </p>
 * <p> B ------------------------> [f(1)不在缓存中]-------> [---------计算f(1)---------]-------[将f(1)放入缓存]---> </p>
 */
public class Memories2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();

    private final Computable<A, V> c;

    public Memories2 (Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
