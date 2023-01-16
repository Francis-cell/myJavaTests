package LearningFiles.MyAlgorithmTests.sortArithmetic;

import static LearningFiles.MyAlgorithmTests.sortArithmetic.ArrayUtils.printArray;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2021/9/25 19:57
 */
public class InsertSorted {

    /**
     * 插入排序
     * @param arr
     */
    public static void insert_sorted(int[] arr){
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 ; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
        printArray(arr);
    }
}
