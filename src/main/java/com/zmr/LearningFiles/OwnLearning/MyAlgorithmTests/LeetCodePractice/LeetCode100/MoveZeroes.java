package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.PrintUtils.impl.PrintUtilsImpl;

import java.util.ArrayList;

/**
 * <p> 移动零 (必须在不复制数组的情况下原地对数组进行操作) </p>
 */
public class MoveZeroes {
    /**
     * <p> 暴力解 </p>
     * @param nums
     */
    public static void moveZeroesCrude(int[] nums) {
        // // O(2n) 时间复杂度
        // // 1、先遍历一遍数组，找到 0 的总数，并记录下 0 的下标列表
        // // 2、遍历移动
        // // 3、如果 zeroIndexList.get(zeroIndexList.size() - 1) 不是最后一个元素，则说明后面的元素需要向前移动
        // // 4、末尾赋值 0
        //
        // // 1、先遍历一遍数组，找到 0 的总数，并记录下 0 的下标数组
        // ArrayList<Integer> zeroIndexList = new ArrayList<>();
        // // 用于移动完元素之后末尾赋值 0 操作使用
        // int zeroCount = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         zeroIndexList.add(i);
        //         zeroCount++;
        //     }
        // }
        //
        // // 2、遍历移动（两个 0 元素之间的元素统一移动）
        // for (int i = 0; i < zeroIndexList.size() - 1; i++) {
        //     // 开始移动元素下标
        //     int startMoveIndex = zeroIndexList.get(i);
        //     // 结束移动元素下标
        //     int stopMoveIndex = zeroIndexList.get(i + 1);
        //     // 刚开始不会存在两个 0
        //     if (i != 0) {
        //         // 末尾出现两个空格，因此下标需要维护成新的，+2 操作
        //         startMoveIndex += 2;
        //         stopMoveIndex += 2;
        //         // 执行移动
        //         for (int j = startMoveIndex + 1; j < stopMoveIndex; j++) {
        //             nums[j - 2] = nums[j];
        //         }
        //     } else {
        //         // 执行移动
        //         for (int j = startMoveIndex + 1; j < stopMoveIndex; j++) {
        //             nums[j - 1] = nums[j];
        //         }
        //     }
        // }
        //
        // // 3、如果 zeroIndexList.get(zeroIndexList.size() - 1) 不是最后一个元素，则说明后面的元素需要向前移动
        // int endStartMoveIndex = zeroIndexList.get(zeroIndexList.size() - 1);
        // int endStopMoveIndex = nums.length;
        // if (zeroIndexList.get(zeroIndexList.size() - 1) != nums.length) {
        //     // 执行移动
        //     for (int i = endStartMoveIndex + 1; i < endStopMoveIndex; i++) {
        //         nums[i - 1] = nums[i];
        //     }
        // }
        //
        // // 4、末尾赋值 0
        // for (int i = nums.length - 1; i < zeroCount; i--) {
        //     nums[i] = 0;
        // }
    }

    /**
     * <p> 元素交换求解法 </p>
     * @param nums
     */
    public static void moveZeroesCrudeNew(int[] nums) {
        // 0 元素序列之后的第一个不为 0 的元素的下标
        int notZeroIndex = 0;
        // 当前处理到的为 0 的元素下标
        int zeroIndex = 0;
        for (int i = 0; i < nums.length ; i++) {
            // 找到当前情况下第一个不为 0 的元素和第一个为 0 的元素的下标值
            // 如果 nums[zeroIndex] 已经是 0 了则不进行交换
            // zeroIndex == -1 的时候，代表第一次进行赋值
            if (nums[i] == 0 && (zeroIndex == 0 || nums[zeroIndex] != 0)) {
                zeroIndex = i;
            } else {
                notZeroIndex = i;
            }

            // 执行元素交换
            if (zeroIndex != notZeroIndex && nums[notZeroIndex] != 0) {
                swapElementForArr(nums, zeroIndex, notZeroIndex);
                zeroIndex++;
                notZeroIndex = i;
            }
        }
    }

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

    public static void main(String[] args) {
        // 1,3,12,0,0
        int[] nums1 = new int[] {0,1,0,3,12};
        // 0
        int[] nums2 = new int[] {0};
        // 1,0
        int[] nums3 = new int[] {1, 0};

        // moveZeroesCrudeNew(nums1);
        // PrintUtilsImpl.getInstance().printArr(nums1);
        // moveZeroesCrude(nums2);
        // PrintUtilsImpl.getInstance().printArr(nums2);
        moveZeroesCrudeNew(nums3);
        PrintUtilsImpl.getInstance().printArr(nums3);
    }
}
