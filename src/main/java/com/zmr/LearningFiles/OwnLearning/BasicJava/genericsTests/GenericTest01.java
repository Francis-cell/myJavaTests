package com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTests;

import java.util.List;

/**
 * @ClassName GenericTest01
 * @Description 自定义泛型测试类01
 * @Author zhumengren
 * @Date 2022/4/19 9:00

 * @Version 1.0
 **/
public class GenericTest01 {
    /**
     * 打印输入的泛型数组
     * @param inputArray 输入的数组
     * @return void
     */
    public static <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s", element + ", ");
        }
        System.out.println();
    }

    /**
     * 比较x,y,z三个值，并返回最大的那个
     * @return T
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    /**
     * 打印传入的 data 列表的第0个元素的值
     * @param data 传入的列表的值
     * @return void
     */
    public static void getData(List<?> data) {
        System.out.println("data: " + data.get(0));
    }
}
