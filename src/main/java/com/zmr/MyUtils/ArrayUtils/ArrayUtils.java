package com.zmr.MyUtils.ArrayUtils;

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
}
