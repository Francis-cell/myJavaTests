package com.zmr.LearningFiles.BooksReading.MultiThreadTests.threadLocalTests;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentMap<String, MutablePointSafe> locations;

    private final Map<String, MutablePointSafe> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, MutablePointSafe> points) {
        locations = new ConcurrentHashMap<String, MutablePointSafe>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, MutablePointSafe> getLocations() {
        return unmodifiableMap;
    }

    public MutablePointSafe getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new MutablePointSafe(x, y)) == null) {
            throw new IllegalArgumentException("Invalid vehicle name: " + id);
        }
    }
}
