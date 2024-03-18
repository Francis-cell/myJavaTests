package com.zmr.LearningFiles.BooksReading.MultiThreadTests.ConcurrentContainer;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    /**
     * ConcurrentHashMap 中一些常用方法的调用
     */
    public static void usuallyUseMethodsTest() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            concurrentHashMap.put("Key" + i, i);
        }

        // V putIfAbsent (K key, V value) ===== 仅当 K 没有相应的映射值时才插入
        concurrentHashMap.putIfAbsent("Key10", 10);
        concurrentHashMap.putIfAbsent("Key8", 20);
        // traverseConcurrentMap01(concurrentHashMap);


        // boolean remove (K key, V value) ===== 仅当 K 被映射到 V 时才移除
        concurrentHashMap.remove("Key11", 11);
        concurrentHashMap.remove("Key9", 5);
        concurrentHashMap.remove("Key8", 8);
        // traverseConcurrentMap02(concurrentHashMap);


        // boolean replace (K key, V oldValue, V newValue) ===== 仅当 K 被映射到 oldValue 时才替换为 newValue
        concurrentHashMap.replace("Key4", 4, 30);
        // traverseConcurrentMap03(concurrentHashMap);


        // V replace (K key, V newValue) ===== 仅当 K 被映射到某个值时才替换为 newValue
        concurrentHashMap.replace("Key3", 30);
        traverseConcurrentMap03(concurrentHashMap);


    }

    /**
     * 使用迭代器遍历
     */
    public static <K, V> void traverseConcurrentMap01(ConcurrentHashMap<K, V> map) {
        // 使用迭代器遍历 entrySet
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) iterator.next();
            System.out.println("Key:" + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    /**
     * 使用 forEach 遍历
     */
    public static <K, V> void traverseConcurrentMap02(ConcurrentHashMap<K, V> map) {
        // 使用 forEach 遍历 entrySet
        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
    }

    /**
     * 使用迭代器遍历 keySet，再通过键获取值
     */
    public static <K, V> void traverseConcurrentMap03(ConcurrentHashMap<K, V> map) {
        // 使用迭代器遍历 keySet
        Iterator<K> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            // 获取到当前的 key
            K key = iterator.next();
            // 获取到当前的 value
            V value = map.get(key);
            System.out.println("Key:" + key + ", Value: " + value);
        }
    }

    public static void main(String[] args) {
        // ConcurrentHashMap 中一些常用方法的调用
        usuallyUseMethodsTest();
    }
}
