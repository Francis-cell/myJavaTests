package com.zmr.MyUtils.PrintUtils.impl;

import com.zmr.MyUtils.PrintUtils.PrintUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class PrintUtilsImpl implements PrintUtils {
    /**
     * {@inheritDoc}
     * @param lists
     * @param <E>
     */
    @Override
    public <E> void printList(List<E> lists) {
        for (E e : lists) {
            System.out.printf(e + ", ");
        }
        System.out.println();
    }

    /**
     * {@inheritDoc}
     * @param arr
     */
    @Override
    public <T> void printArr(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + ", ");
        }
        System.out.println();
    }

    /**
     * {@inheritDoc}
     * @param arr
     */
    @Override
    public <T> void printArr(T[][] arr) {
        // 判空处理
        if (arr.length == 0 || arr[0].length == 0) {
            throw new IllegalArgumentException("The argument for printArr is empty! Please check!");
        }

        // 根据不同的元素类型进行不同的处理操作
        T el = arr[0][0];
        // 字符类型
        if (el instanceof Character || el instanceof String) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(new String(Arrays.toString(arr[i])) + ", ");
            }
        }
        // Integer、Double 类型
        else if (el instanceof Integer || el instanceof Double) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.printf(arr[i][j] + ", ");
                }
                System.out.println();
            }
        }
        // 其他类型，暂时先不支持，需要的时候再支持
        else {
            throw new IllegalArgumentException("The argument for printArr is not support!");
        }

        System.out.println();
    }

    /**
     * {@inheritDoc}
     * @param map
     * @param <K>
     * @param <V>
     */
    @Override
    public <K, V> void printMap(Map<K, V> map) {
        System.out.println("{");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            String tmpName = (String) key;
            System.out.println(tmpName + ": " + value);
        }
        System.out.println("}");
    }
}
