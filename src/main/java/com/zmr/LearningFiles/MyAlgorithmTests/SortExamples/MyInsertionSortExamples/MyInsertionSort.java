package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyInsertionSortExamples;

/**
 * @ClassName MyInsertionSort
 * @Description TODO
 * @Author zhumengren
 * @Date 2023/1/3 8:17
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyInsertionSort {
    /** 插入排序 */
    int[] insertionSort (int[] nums) {
        // 外循环,base为当前正要执行插入操作的值，base = nums[1], nums[2]...nums[nums.length-1]
        for (int i = 1; i <= nums.length-1; i++) {
            int base = nums[i], j = i - 1;
            while (j >=0 && base < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
