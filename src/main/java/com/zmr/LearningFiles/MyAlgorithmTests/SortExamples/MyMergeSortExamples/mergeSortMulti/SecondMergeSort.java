package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyMergeSortExamples.mergeSortMulti;

/**
 * @ClassName SecondMergeSort
 * @Description 归并排序第二次
 * @Version 1.0
 **/
public class SecondMergeSort {
    /** 先声明merge方法 */
    public static void merge(int[] arr, int L, int M, int R) {
        int[] tmp = new int[R - L + 1];
        int i = 0;
        // 声明两个辅助指针
        int p1 = L;
        int p2 = M + 1;
        
        // 当左指针和右指针都没有越界的情况下
        while (p1 <= M && p2 <= R) {
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        
        // 最终必然有一个越界
        while (p1 <= M) {
            tmp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            tmp[i++] = arr[p2++];
        }
        
        // 将tmp拷贝到arr数组中
        for (int j = 0; j < tmp.length; j++) {
            arr[L + j] = tmp[j];
        }
    }

    /** 递归方式实现 */
    public static void progress(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        progress(arr, L, mid);
        progress(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    
    public static void mergeSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        progress(arr, 0, arr.length - 1);
    }
    
    
    /** 非递归实现方式(采用步长的方式实现) */
    public static void mergeSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        
        int N = arr.length;
        // 步长的变化(1--2--4--8--16...)
        int mergeSize = 1;
        // 防止数组越界
        while (mergeSize < N) {
            // 当前左侧数组的第一个位置
            int L = 0;
            while (L < N) {
                // 如果步长 > 数组长度 - 左侧数组第一个位置下标
                // 即下一次不够再走一步
                if (mergeSize >= N - L) {
                    break;
                }
                // 当前左侧数组的最后（即当前要merge的部分的中间位置）
                int M = L + mergeSize - 1;
                // 当前右侧数组的最右侧位置(步长和剩余数组长度比较)
                int R = M + Math.min(mergeSize, N - M - 1);
                merge(arr, L, M, R);
                // 更新下一个左侧数组的最左侧位置
                L = R + 1;
            }

            // 防止溢出
            if (mergeSize > N / 2) {
                break;
            }

            // 步长*2
            mergeSize <<= 1;
        }
    }

    /** 生成随机数组 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr =  new int[(int) (Math.random() * maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(maxValue + 1)) - (int)(Math.random()*maxValue);
        }
        return arr;
    }
    
    
    /** 拷贝数组 */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    
    /** 两个数组比较是否一致 */
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
    
    public static void main(String[] args) {
        int testTimes = 500000;
        int maxValue = 100;
        int maxSize = 100;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 创建随机数组，拷贝，比较
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            
            mergeSort01(arr1);
            mergeSort02(arr2);
            
            if (!equalArray(arr1, arr2)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
