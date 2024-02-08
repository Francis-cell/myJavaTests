package com.zmr.LearningFiles.MultiThreadTests.threadLocalTests;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Java 监视器模式
 * 说明： "监视器最重要的特点是互斥，即同一个时刻，只有一个线程能进入监视器中定义的临界区"
 * TODO 待确认问题：
 * 1、如果线程A获得了set 方法的锁，同时线程B获得了 get方法的锁
 * 2、如果A先set了值，B后get到值，那么B将获取到的是A更新后的值
 * 3、如果B先get了值，A后set了值，那么B将获取到的是A更新前的值
 * TODO 请问这种情况算是线程安全的吗？？？
 */
@ThreadSafe
public class MonitorVehicleTracker {
    @GuardedBy("this")
    private final Map<String, MutablePointUnsafe> locations;

    public MonitorVehicleTracker (Map<String, MutablePointUnsafe> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePointUnsafe> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePointUnsafe getLocation(String id) {
        MutablePointUnsafe loc = locations.get(id);
        return loc == null ? null : new MutablePointUnsafe(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePointUnsafe loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePointUnsafe> deepCopy(
            Map<String, MutablePointUnsafe> map) {
        Map<String, MutablePointUnsafe> result = new HashMap<>();
        for (String id : map.keySet()) {
            result.put(id, new MutablePointUnsafe(map.get(id)));
        }
        // return the Read-Only map. ( 防止容器对象被修改 )
        return Collections.unmodifiableMap(result);
    }
}
