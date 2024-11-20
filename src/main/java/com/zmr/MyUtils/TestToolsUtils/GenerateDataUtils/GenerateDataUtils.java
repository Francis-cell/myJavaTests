package com.zmr.MyUtils.TestToolsUtils.GenerateDataUtils;

/**
 * <p> 数据初始化方法 </p>
 */
public class GenerateDataUtils {
    /** ---------------------------------- 随机数值类型  ----------------------------------*/
    /**
     * <p> 随机一个整形数值 </p>
     * @param maxValue 随机数值中的最大值
     * @return
     */
    public static int generateRandomInt(int maxValue) {
        return (int)(Math.random() * maxValue);
    }


    /** ---------------------------------- 随机数组类型  ----------------------------------*/
    /**
     * <p> 构建一个随机的整形数组，要求数据在数据的范围内 </p>
     * @param maxSize 数组的最大大小
     * @param maxValue 数组的最大的元素值
     * @return
     */
    public static int[] generateRandomIntArray(int maxSize, int maxValue) {
        // 随机数组的长度
        int[] arr = new int[(int)(Math.random() * maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * maxValue) - (int) (Math.random() * (maxValue));
        }
        return arr;
    }
}
