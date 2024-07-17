package com.zmr.MyUtils.MapUtils.impl;

import com.alibaba.excel.util.StringUtils;
import com.zmr.ImportantComponents.Exception.BusinessException;
import com.zmr.MyUtils.BasicUtils.CompareUtils;
import com.zmr.MyUtils.BasicUtils.impl.CompareUtilsImpl;
import com.zmr.MyUtils.MapUtils.MapUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    /**
     * {@inheritDoc}
     * @param map1 要合并的 map
     * @param map2 要合并的 map
     * @return
     * @param <K>
     * @param <V>
     */
    @Override
    public <K, V> Map<K, V> mergeMap(Map<K, V> map1, Map<K, V> map2) {
        // 检查两个 map 是否是同一种类型
        if (!isSameType(map1, map2)) {
            throw new IllegalArgumentException("要合并的两个 map 类型不一致！");
        }
        // 创建一个新的Map来存放合并后的结果
        Map<K, V> mergedMap = new HashMap<>(map1);
        // 将第二个Map的所有项合并到新的Map中
        // 如果有相同的键，后面的值会覆盖前面的值
        mergedMap.putAll(map2);
        return mergedMap;
    }

    /**
     * {@inheritDoc}
     * @param map 翻译标准
     * @param str 代翻译字符串
     * @param splitStr 分隔符
     * @return
     */
    public String translateMapString(Map<String, String> map, String str, String splitStr) {
        if (map == null || str == null || "".equals(str) || splitStr == null || "".equals(splitStr)) {
            return str;
        }
        String[] strArr = str.split(splitStr);
        List<String> ansList = new ArrayList<>();
        for (String strInner: strArr) {
            String tmp = map.get(strInner) == null ? "" : map.get(strInner);
            if (!"".equals(tmp)) {
                ansList.add(tmp);
            }
        }
        String[] ans = ansList.toArray(new String[ansList.size()]);
        return String.join(",", ans);
    }

    /**
     * {@inheritDoc}
     * <p> 更新一个 map 中的映射关系，如果存在则更新 map 映射关系，如果不存在则更新； </p>
     * <p> 最后一个元素指定依据的唯一 key（可以不指定，这种情况下要求子 Map 只能单元素） </p>
     * @param maps 要进行数据插入的 map 映射关系
     * @param key 要插入的 key
     * @param newValue 对应的 key 要更新的新的值信息
     * @param indexKey 要被更新的唯一 key 信息
     * @param indexValue 要被更新的唯一 key 对应的 value 信息
     * @param <T>
     */
    @Override
    public <T> void updateMap(List<Map<String, T>> maps, String key, T newValue, String indexKey, T indexValue) {
        // 要被更新的唯一 key 信息 不能为空
        if (StringUtils.isEmpty(indexKey)) {
            throw new BusinessException("indexKey 不能为空！");
        }
        // 要被更新的唯一 key 信息 不能为空
        if (indexValue == null) {
            throw new BusinessException("indexValue 不能为空！");
        }
        // key 不能为空
        if (StringUtils.isEmpty(key)) {
            throw new BusinessException("key 不能为空！");
        }
        // newValue 不能为空
        if (newValue == null) {
            throw new BusinessException("newValue 不能为空！");
        }

        // 原本存在则更新映射中的数据，原本不存在，则新增一个映射关系
        int count = 0;
        for (Map<String, T> map : maps) {
            // 映射中存在对应的 key 信息
            if (map.get(indexKey) != null &&
                    CompareUtilsImpl.getInstance().checkTwoValueEquals(map.get(indexKey), indexValue)) {
                map.put(key, newValue);
                count++;
            }
        }

        // 说明没更新，执行新增操作
        if (count == 0) {
            Map<String, T> tmpMap = new HashMap<>();
            tmpMap.put(indexKey, indexValue);
            tmpMap.put(key, newValue);
            maps.add(tmpMap);
        }
    }

    /**
     * <p> 检查两个Map的类型是否一致 (使用反射机制检查) </p>
     * @param map1 第一个Map
     * @param map2 第二个Map
     * @return 类型是否一致
     */
    private boolean isSameType(Map<?, ?> map1, Map<?, ?> map2) {
        Type type1 = map1.getClass().getGenericSuperclass();
        Type type2 = map2.getClass().getGenericSuperclass();

        if (type1 instanceof ParameterizedType && type2 instanceof ParameterizedType) {
            ParameterizedType pType1 = (ParameterizedType) type1;
            ParameterizedType pType2 = (ParameterizedType) type2;

            Type[] typeArgs1 = pType1.getActualTypeArguments();
            Type[] typeArgs2 = pType2.getActualTypeArguments();

            return typeArgs1[0].equals(typeArgs2[0]) && typeArgs1[1].equals(typeArgs2[1]);
        }

        return false;
    }
}
