package com.zmr.MyUtils.PrintUtils;

import java.util.List;
import java.util.Map;

public interface PrintUtils {
    /**
     * <p> 打印列表中的元素 </p>
     * @param lists
     * @param <E>
     */
    <E> void printList(List<E> lists);

    /**
     * <p> 一维数组打印 </p>
     * @param arr
     */
    <T> void printArr(T[] arr);

    /**
     * <p> 二维数组打印 </p>
     * @param arr
     */
    <T> void printArr(T[][] arr);

    /**
     * 打印 Map 中的元素
     * @param map
     * @param <K>
     * @param <V>
     */
    <K, V> void printMap(Map<K, V> map);
}
