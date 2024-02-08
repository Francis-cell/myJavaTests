package com.zmr.LearningFiles.MultiThreadTests.syncUtils.efficientScalableResCaching;

import java.util.Map;
import java.util.concurrent.*;

public class Memories3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    private final Computable<A, V> c;

    public Memories3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws InterruptedException {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            // 这里将调用 c.compute
            ft.run();
        }

        try {
            return f.get();
        } catch (ExecutionException e) {
            // 抛出异常
            throw launderThrowable(e.getCause());
        }
    }

    /**
     * <p>
     *      如果 Throwable 是 Error，那么抛出它；
     * </p>
     * <p>
     *      如果是 RuntimeException，那么返回它；
     * </p>
     * <p>
     *      否则抛出 IllegalArgumentException；
     * </p>
     */
    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new IllegalArgumentException("Not unchecked", t);
        }
    }
}
