package com.zmr.MyUtils.MapUtils;

import java.util.Map;

public interface MapUtils {
    /**
     * <p> 反转一个 map 映射中的 key 和 value，形成一个新的 map，形成过程中 </p>
     * @param originalMap 要反转的 map
     * @param ignoreMap 反转时需要忽略的 映射关系
     * @return
     */
    <K, V> Map<K, V> reverseMap(Map<V, K> originalMap, Map<V, K> ignoreMap);
}
