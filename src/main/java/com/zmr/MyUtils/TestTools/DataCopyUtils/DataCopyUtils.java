package com.zmr.MyUtils.TestTools.DataCopyUtils;

/**
 * <p> 数据拷贝方法 </p>
 */
public class DataCopyUtils {
    /**
     * 整形数组拷贝
     * @param arr
     * @return
     */
    public static int[] copyIntArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        return tmp;
    }
}
