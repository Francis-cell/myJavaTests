package com.zmr.LearningFiles.MyAlgorithmTests.AlgorithmRealSituation.SortDemo;


/**
 * <p> 插入排序 demo </p>
 * <p> 习题链接：https://leetcode.cn/problems/sort-an-array/description/ </p>
 */
public class InsertSortDemo {
    /**
     * <p> 插入排序实现 </p>
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // base 是后面的值，nums[j] 是 base 前面的值
            int base = nums[i], j = i - 1;
            while (j >= 0 && base < nums[j]) {
                swap(nums, j, j + 1);
                j--;
            }
        }
        return nums;
    }


    /**
     * <p> 将数组 arr 中在下标 indexA 和 indexB 位置的元素进行交换 </p>
     * @param arr
     * @param indexA
     * @param indexB
     */
    public static void swap(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,2,3,1};
        sortArray(arr);
        printArr(arr);
    }
}
