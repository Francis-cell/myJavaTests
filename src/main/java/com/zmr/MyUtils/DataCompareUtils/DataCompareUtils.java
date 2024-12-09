package com.zmr.MyUtils.DataCompareUtils;

import java.util.Date;

/**
 * <p> 数值相似比较器 </p>
 */
public class DataCompareUtils {
    /**
     * <p> 检查两个数据是否是相同的  </p>
     * @param v1
     * @param v2
     * @return
     * @param <E>
     */
    public static <E> Boolean checkTwoValueEquals(E v1, E v2) {
        Boolean ans = false;
        // 1、类型校验
        // null 值校验
        if (v1 == null && v2 == null) {
            return true;
        }
        if (v1 == null || v2 == null) {
            return false;
        }
        // v1 和 v2 的数据类型是否相同的校验
        if (v1.getClass().getName() != null && v2.getClass().getName() != null
                && !v1.getClass().getName().equals(v2.getClass().getName())) {
            return false;
        }

        // 2、字符串检查
        if (v1 instanceof String && v1.equals(v2)) {
            return true;
        }
        // 3、Integer、Double 检查
        if (v1 instanceof Integer || v1 instanceof Double) {
            return v1 == v2;
        }
        // 4、Date 检查
        if (v1 instanceof Date) {
            return ((Date) v1).compareTo((Date) v2) == 0;
        }

        return ans;
    }

    /**
     * <p> 整型数组比较器，如果两个整型中的元素全部一样，则返回 true，反之返回 false </p>
     * @param arr1
     * @param arr2
     * @return
     */
    public static Boolean isEqualIntArray(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 != null || arr1 != null && arr2 == null) {
            return false;
        }

        if (arr1 == null && arr2 == null) {
            return true;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
    }
}
