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
}
