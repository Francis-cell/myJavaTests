package com.zmr.MyUtils.MapUtils.impl;

import com.zmr.MyUtils.MapUtils.MapUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MapUtilsImpl implements MapUtils {
    private static final MapUtilsImpl INSTANCE  = new MapUtilsImpl();

    private MapUtilsImpl() {}

    public static MapUtilsImpl getInstance() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     * @param originalMap
     * @param ignoreMap
     * @return
     * @param <K>
     * @param <V>
     */
    @Override
    public <K, V> Map<K, V> reverseMap(Map<V, K> originalMap, Map<V, K> ignoreMap) {
        Map<K, V> reversedMap = new HashMap<>();
        for (Map.Entry<V, K> entry : originalMap.entrySet()) {
            // 忽略 key
            V key = entry.getKey();
            K value = entry.getValue();
            if (ignoreMap.containsKey(key)) {
                continue;
            }
            // 将值作为键，键作为值
            reversedMap.put(value, key);
        }
        return reversedMap;
    }
}
