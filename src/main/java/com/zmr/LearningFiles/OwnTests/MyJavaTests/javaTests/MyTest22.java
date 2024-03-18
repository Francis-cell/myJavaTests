package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import java.util.HashMap;
import java.util.Map;

public class MyTest22 {

    public static <K, V> Map<K, V> reverseMap(Map<V, K> originalMap, Map<V, K> ignoreMap) {
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

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        Map<String, Integer> ignoreMap = new HashMap<>();

        // 原映射关系中的元素
        originalMap.put("Apple", 1);
        originalMap.put("Banana", 2);
        originalMap.put("Cherry", 3);

        // 要忽略的元素
        ignoreMap.put("Cherry", 3);


        Map<Integer, String> reversedMap = reverseMap(originalMap, ignoreMap);

        System.out.println("原始Map: " + originalMap);
        System.out.println("颠倒后的Map: " + reversedMap);
    }
}

