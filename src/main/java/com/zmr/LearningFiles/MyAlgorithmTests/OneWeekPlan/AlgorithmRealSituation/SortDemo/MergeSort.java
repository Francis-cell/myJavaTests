package com.zmr.LearningFiles.MyAlgorithmTests.OneWeekPlan.AlgorithmRealSituation.SortDemo;

import java.util.Arrays;

public class MergeSort {
    /**
     * <p> 合并一个数组中的两端数据，第一段为 L ~ M，第二段数据为 M + 1 ~ R </p>
     * @param arr
     * @param L
     * @param M
     * @param R
     */
    public static void merge(int[] arr, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        // 声明两个辅助指针
        int p1 = L;
        int p2 = M + 1;

        // 此时左侧指针 p1 和右侧指针 p2 都没有越界
        while (p1 <= M && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 有两种情况，要么 p1 越界，要么 p2 越界
        while (p1 <= M) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }

        // 将 temp 数组拷贝到 arr 数组上
        for (int j = 0; j < temp.length; j++) {
            arr[L + j] = temp[j];
        }
    }

    /**
     * <p> 递归主体逻辑 </p>
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    /**
     * <p> 递归实现 </p>
     * @param arr
     */
    public static void mergeSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }


    /**
     * <p> 非递归实现(采用步长的实现方式) </p>
     * @param arr
     */
    public static void mergeSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        // 步长（变化 1--2--4--8--16...）【其实就是每次合并的数组的长度】
        int mergeSize = 1;
        // 防止数组越界
        while (mergeSize < N) {
            // 当前位置在数组的第一个位置
            int L = 0;
            while (L < N) {
                // 如果步长 > （数组 - 左侧数组第一个位置的下标）
                // 即下一次不够再走一步
                if (mergeSize > N - L) {
                    break;
                }
                // 当前左侧数组的最后位置，用作数组的中间位置
                int M = L + mergeSize - 1;
                // 当前右侧数组的最右侧位置
                int R = M + Math.min(mergeSize, N - M - 1);
                merge(arr, L, M, R);
                // 更新下一次左侧数组的最左侧位置
                L = R + 1;
            }
            // 防止溢出(例如10为int的最大值，当mergeSize的值为8的
            // 时候，下一次8*2将会越界，出现负值，所以要在mergeSize*2
            // 之前进行越界判断操作，判断当前的步长和N/2的关系，如果(步长<
            // N/2)，则下一次一定不会越界，如果>N/2，则不敢保证不会越界，
            // 直接中断即可)
            if (mergeSize > N / 2) {
                break;
            }

            // 步长 * 2
            mergeSize <<= 1;
        }
    }

    /**
     * 对数器
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
        // int[] arr = new int[] {301, 784, 354};
        //
        // // 非递归-归并排序实现
        // mergeSort02(arr);
        //
        // printArr(arr);

        // int maxSize = 100;
        int maxSize = 10;
        int maxValue = 1000;
        int testTime = 1000000;

        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            // 生成随机数组，拷贝
            int[] arr1 = generateRandomArr(maxSize, maxValue);
            // int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);

            // printArr(arr3);

            // 对数器
            testSort(arr1);
            // 递归-归并排序实现
            // mergeSort01(arr2);
            // 非递归-归并排序实现
            mergeSort02(arr3);

            // if (!isEqualArray(arr1, arr2)) {
            if (!isEqualArray(arr1, arr3)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
