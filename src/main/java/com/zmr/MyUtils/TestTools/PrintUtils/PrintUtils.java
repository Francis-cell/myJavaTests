package com.zmr.MyUtils.TestTools.PrintUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class PrintUtils {
    private static final PrintUtils INSTANCE  = new PrintUtils();

    private PrintUtils() {}

    public static PrintUtils getInstance() {
        return INSTANCE;
    }

    /**
     * <p> 打印列表中的元素（一维） </p>
     * @param lists
     * @param <E>
     */
    public static <E> void printSampleList(List<E> lists) {
        for (int i = 0; i < lists.size(); i++) {
            System.out.printf("" + lists.get(i));
            if (i < lists.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * <p> 打印列表中的元素（二维） </p>
     * @param lists
     * @param <E>
     */
    public static <E> void printComplicatedList(List<List<E>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            System.out.print("{ ");
            printSampleList(lists.get(i));
            System.out.print("} ");
            System.out.println();
        }
    }

    /**
     * <p> 一维数组打印 </p>
     * @param arr
     */
    public static <T> void printArr(T[] arr) {
        assert arr != null;
        for (int i = 0; i < arr.length; i++) {
            System.out.print("" + arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * <p> 整形一维数组打印 </p>
     * @param arr
     */
    public static void printArr(int[] arr) {
        assert arr != null;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }


    /**
     * <p> 二维数组打印 </p>
     * @param arr
     */
    public static <T> void printArr(T[][] arr) {
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
     * 打印 Map 中的元素
     * @param map
     * @param <K>
     * @param <V>
     */
    public static <K, V> void printMap(Map<K, V> map) {
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
