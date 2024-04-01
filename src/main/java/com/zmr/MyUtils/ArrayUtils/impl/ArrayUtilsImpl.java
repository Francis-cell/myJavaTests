package com.zmr.MyUtils.ArrayUtils.impl;

import com.zmr.MyUtils.ArrayUtils.ArrayUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

@Component
public class ArrayUtilsImpl implements ArrayUtils {
    private static final ArrayUtilsImpl INSTANCE  = new ArrayUtilsImpl();

    private ArrayUtilsImpl() {}

    public static ArrayUtilsImpl getInstance() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     * @param clazz
     * @param arr
     * @return
     * @param <T>
     */
    @Override
    public <T> T[][] reverseArr(Class<T> clazz, T[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return null;
        }
        int rows = arr[0].length;
        int cols = arr.length;
        // 创建泛型数组
        // T[][] ans = (T[][]) new Object[rows][cols];
        // 对于二维数组，需要手动传入 clazz 才行，下面的这种手段无法获取到数组的类型
        // T[][] ans = (T[][]) Array.newInstance(arr.getClass().getComponentType(), rows, cols);
        T[][] ans = (T[][]) Array.newInstance(clazz, rows, cols);
        // 转置
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ans[j][i] = arr[i][j];
            }
        }
        return ans;
    }

    /**
     * {@inheritDoc}
     * @param arr 要参与检查的数组
     * @param ele 要被检查是否存在的元素
     * @return
     * @param <T>
     */
    @Override
    public <T> boolean arrContainsElement(T[] arr, T ele) {
        if (ele == null) {
            return false;
        }
        for (T e : arr) {
            // 基本元素类型
            if (e instanceof Integer || e instanceof Double) {
                if (ele == e) {
                    return true;
                }
            }
            // 字符串类型
            else if (e instanceof String) {
                if (ele.equals(e)) {
                    return true;
                }
            }
            // TODO - 封装类型的判断
        }
        return false;
    }
}
