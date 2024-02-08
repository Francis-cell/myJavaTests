package com.zmr.LearningFiles.MultiThreadTests.threadLocalTests;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这个方法之所以是线程安全的，是因为没有在状态变量上存在约束条件；
 * 如果存在约束条件，那么这个方法将不再是线程安全的，需要加锁同步才能再次实现线程安全；
 */
@ThreadSafe
public class PublishVehicleTracker {
    private final Map<String, SafePoint> locations;

    private final Map<String, SafePoint> unmodifiableMap;

    public PublishVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<String, SafePoint>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException("Invalid vehicle name: " + id);
        }
        locations.get(id).set(x, y);
    }
}
