package com.zmr.MyUtils.MapUtils;

import java.util.List;
import java.util.Map;

public interface MapUtils {
    /**
     * <p> 反转一个 map 映射中的 key 和 value，形成一个新的 map，形成过程中 </p>
     * @param originalMap 要反转的 map
     * @param ignoreMap 反转时需要忽略的 映射关系
     * @return
     */
    <K, V> Map<K, V> reverseMap(Map<V, K> originalMap, Map<V, K> ignoreMap);

    /**
     * <p> 合并两个 map </p>
     * @param map1 要合并的 map
     * @param map2 要合并的 map
     * @return 合并后的 map
     */
    <K, V> Map<K, V> mergeMap(Map<K, V> map1, Map<K, V> map2);

    /**
     * <p> 将 str 翻译成 map 中的字符串并连接 </p>
     * @param map 翻译标准
     * @param str 代翻译字符串
     * @param splitStr 分隔符
     * @return
     */
    String translateMapString(Map<String, String> map, String str, String splitStr);

    /**
     * <p> 更新一个 map 中的映射关系，如果存在则更新 map 映射关系，如果不存在则更新； </p>
     * <p> 最后一个元素指定依据的唯一 key（可以不指定，这种情况下要求子 Map 只能单元素） </p>
     * @param maps 要进行数据插入的 map 映射关系
     * @param key 要插入的 key
     * @param newValue 对应的 key 要更新的新的值信息
     * @param indexKey 要被更新的唯一 key 信息
     * @param indexValue 要被更新的唯一 key 对应的 value 信息
     */
    <T> void updateMap(List<Map<String, T>> maps, String key, T newValue, String indexKey, T indexValue);
}
