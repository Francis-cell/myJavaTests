package com.zmr.MyUtils.ArrayUtils;

import java.util.List;

public interface ArrayUtils {
    /**
     * <p> 转置-二维数组 </p>
     * @param clazz 数组中元素的类型
     * @param arr 要进行转置的数组
     * @return
     * @param <T>
     */
    <T> T[][] reverseArr(Class<T> clazz, T[][] arr);

    /**
     * <p> 查看一个元素是否在某个一维数组中存在 </p>
     * @param arr 要参与检查的数组
     * @param ele 要被检查是否存在的元素
     * @return true - 存在； false - 不存在；
     */
    <T> boolean arrContainsElement(T[] arr, T ele);

    /**
     * <p> 获取到两个数组之间的差别，返回值中为一个二维数组，
     * 其中第一个元素为在 arr1 中存在但是不在 arr2 中不存在的元素;
     * 第二个元素在 arr1 中不存在但是在 arr2 中存在的元素</p>
     * @param arr1 待比较的数组1
     * @param arr2 待比较的数组2
     * @return 差值列表
     * @param <T>
     */
    <T extends Comparable<T>> List<T[]> getDifferentElementsFromTwoArray(T[] arr1, T[] arr2);
}
