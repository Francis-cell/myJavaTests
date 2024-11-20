package com.zmr.MyUtils.TestToolsUtils.DataCompareUtils;

/**
 * <p> 数值相似比较器 </p>
 */
public class DataCompareUtils {
    /**
     * <p> 整型数组比较器，如果两个整型中的元素全部一样，则返回 true，反之返回 false </p>
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqualIntArray(int[] arr1, int[] arr2) {
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
}
