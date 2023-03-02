package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyMergeSortExamples.mergeSortMulti;

import java.util.Arrays;

/**
 * @ClassName ThirdMergeSort
 * @Description 归并排序第三次写
 **/
public class ThirdMergeSort {
    /** 先声明merge方法 */
    public static void merge(int[] arr, int L, int M, int R) {
        int[] tmp = new int[R - L + 1];
        int i = 0;
        // 声明两个指针，用于标记左右两个数组的最左侧位置
        int p1 = L;
        int p2 = M + 1;
        
        // 此时左侧指针和右侧指针均未越界
        while (p1 <= M && p2 <= R) {
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        
        // 有两种情况，必然有一个先越界
        while (p1 <= M) {
            tmp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            tmp[i++] = arr[p2++];
        }
        
        // 将tmp数组拷贝回arr中
        for (int j = 0; j < tmp.length; j++) {
            arr[L + j] = tmp[j];
        }
    }

    /** 递归方式实现 */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    
    /** 非递归方式实现 */
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        
        int N = arr.length;
        // 使用步长的方式进行解决
        int mergeSize = 1;
        // 防止数组越界
        while (mergeSize < N) {
            // 当前左侧数组的第一个位置
            int L = 0;
            while (L < N) {
                if (mergeSize >= N - L) {
                    break;
                }
                
                // 当前左侧数组的最后位置
                int M = L + mergeSize - 1;
                // 当前右侧数组的最后位置
                int R = M + Math.min(mergeSize, N - M - 1);
                merge(arr, L, M, R);
                // 更新下一个左侧数组的最左侧位置
                L = R + 1;
            }
            
            // 如果步长超过了当前正在操作的数组的一半长度，则直接停止步长增长
            if (mergeSize > N / 2) {
                break;
            }
            
            // 步长 * 2
            mergeSize <<= 1;
        }
    }
    
    /** 对数器 */
    public static void comparatorSort(int[] arr) {
        Arrays.sort(arr);
    }
    
    /** 随机数组 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random()*(maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(maxValue + 1)) - (int)(Math.random()*maxValue);
        }
        return arr;
    }
    
    /** 数组拷贝 */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        return tmp;
    }
    
    /** 两个数组比较 */
    public static boolean equalArray(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 != null ||
        arr1 != null && arr2 == null) {
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
    
    /** 数组打印 */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        //int[] tmpArr = new int[] {17, 9, -1, 81, 29, -23, -40, 28, -40};
        //printArray(tmpArr);
        //mergeSort2(tmpArr);
        //printArray(tmpArr);
        
        
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机数组，拷贝，比较
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);

            //printArray(arr1);

            mergeSort(arr1);
            mergeSort2(arr2);
            comparatorSort(arr3);

            if (!equalArray(arr1, arr3) || !equalArray(arr2, arr3)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
