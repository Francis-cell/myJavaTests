package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.PrintUtils.PrintUtils;
import com.zmr.MyUtils.DataCompareUtils.DataCompareUtils;
import com.zmr.MyUtils.TestToolsUtils.DataCopyUtils.DataCopyUtils;
import com.zmr.MyUtils.TestToolsUtils.GenerateDataUtils.GenerateDataUtils;

/**
 * <p> 移动零 (必须在不复制数组的情况下原地对数组进行操作) </p>
 */
public class MoveZeroes {
    /**
     * <p> 暴力解 </p>
     * @param nums
     */
    public static void moveZeroesCrude(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swapElementForArr(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    // /**
    // * <p> 元素交换求解法 </p>
    // * @param nums
    // */
    // public static void moveZeroesCrudeNew(int[] nums) {
    //    // 0 元素序列之后的第一个不为 0 的元素的下标
    //    int notZeroIndex = 0;
    //    // 当前处理到的为 0 的元素下标
    //    int zeroIndex = 0;
    //    for (int i = 0; i < nums.length ; i++) {
    //        // 找到当前情况下第一个不为 0 的元素和第一个为 0 的元素的下标值
    //        // 如果 nums[zeroIndex] 已经是 0 了则不进行交换
    //        // zeroIndex == 0 的时候，代表第一次进行赋值
    //        if (nums[i] == 0 && (zeroIndex == 0 || nums[zeroIndex] != 0)) {
    //            zeroIndex = i;
    //        } else {
    //            notZeroIndex = i;
    //        }
    //
    //        // 执行元素交换
    //        if (zeroIndex != notZeroIndex && nums[notZeroIndex] != 0) {
    //            swapElementForArr(nums, zeroIndex, notZeroIndex);
    //            zeroIndex++;
    //            notZeroIndex = i;
    //        }
    //    }
    // }

    /**
     * <p> 交换 nums 数组中的 index1 和 index2 下标的元素值 </p>
     * @param nums 要执行处理的数组
     * @param index1 要交换的元素下标1
     * @param index2 要交换的元素下标2
     */
    public static void swapElementForArr(int[] nums, int index1, int index2) {
        int numsLength = nums.length;
        // 下标越界（不进行处理）
        if (index1 < 0 || index1 >= numsLength || index2 < 0 || index2 >= numsLength) {
            return;
        }
        // index1 的元素的值
        int swapElement = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = swapElement;
    }


    /**
     * <p> 双指针解法 </p>
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        // 1、定义第一个非 0 的元素的指针的位置
        int cur = 0;
        // 2、开始收集不是 0 的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }

        // 3、将剩余位置的元素赋值为 0
        for (int i = cur; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        // // 1,3,12,0,0
        // int[] nums1 = new int[] {0,1,0,3,12};
        // // 0
        // int[] nums2 = new int[] {0};
        // // 1,0
        // int[] nums3 = new int[] {1, 0};
        //
        // moveZeroes(nums1);
        // PrintUtils.printArr(nums1);
        //moveZeroesCrude(nums2);
        //PrintUtils.printArr(nums2);
        //moveZeroesCrude(nums3);
        //PrintUtils.printArr(nums3);

        // 对撞测试
        int maxSize = 1000;
        int maxValue = 10000;
        int testTime = 100000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            // 随机数组
            int[] arr = GenerateDataUtils.generateRandomIntArray(maxSize, maxValue);
            int[] arrCopy = DataCopyUtils.copyIntArray(arr);
            int[] arrOrigin = DataCopyUtils.copyIntArray(arr);

            // 暴力解
            moveZeroesCrude(arr);
            // 双指针解
            moveZeroes(arrCopy);
            if (!DataCompareUtils.isEqualIntArray(arr, arrCopy)) {
                System.out.println("测试失败！");
                System.out.println("当前随机数组为：");
                PrintUtils.printArr(arrOrigin);
                System.out.println("暴力解 结果：");
                PrintUtils.printArr(arr);
                System.out.println("双指针解 结果：");
                PrintUtils.printArr(arrCopy);
                return;
            }
        }
        System.out.println("测试完成！");
    }
}
