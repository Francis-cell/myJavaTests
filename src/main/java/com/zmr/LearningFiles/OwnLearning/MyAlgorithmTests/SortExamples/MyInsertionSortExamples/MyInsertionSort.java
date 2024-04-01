package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.SortExamples.MyInsertionSortExamples;

import java.util.Arrays;

/**
 * @ClassName MyInsertionSort
 * @Description TODO
 * @Author zhumengren
 * @Date 2023/1/3 8:17

 * @Version 1.0
 **/
public class MyInsertionSort {
    /** 插入排序 */
    public static int[] insertionSort (int[] nums) {
        // 外循环,base为当前正要执行插入操作的值，base = nums[1], nums[2]...nums[nums.length-1]
        for (int i = 1; i <= nums.length-1; i++) {
            int base = nums[i], j = i - 1;
            while (j >=0 && base < nums[j]) {
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


    /**
     * <p> 对数器 </p>
     * @param arr
     */
    public static void testSort(int[] arr) {
        Arrays.sort(arr);
    }


    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static int[] generateRandomArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }

        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    public static boolean isEqualArray(int[] arr1, int[] arr2) {
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
        // int[] arr = new int[] {901, 216, 311, 50};
        // int[] arr2 = copyArray(arr);
        // insertionSort(arr);
        // testSort(arr2);
        // printArr(arr);
        // printArr(arr2);

        int maxValue = 1000;
        int maxSize = 200;
        // int maxSize = 10;
        int testTime = 1000000;

        System.out.println("测试开始！");

        for (int i = 0; i < testTime; i++) {
            // 随机数组初始化
            int[] arr1 = generateRandomArr(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            // printArr(arr1);

            // 插入排序
            insertionSort(arr1);
            // 对数器
            testSort(arr2);
            if (!isEqualArray(arr1, arr2)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
