package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyMergeSortExamples;

/**
 * @ClassName MergeSort
 * @Description 归并排序实现
 * @Author zhumengren
 * @Version 1.0
 **/
public class MergeSort {
    
    /** 先声明merge方法 */
    public static void merge(int[] arr, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        // 声明两个辅助指针
        int p1 = L;
        int p2 = M + 1;
        
        // 此时左侧指针p1&右侧指针p2均没越界
        while (p1 <= M && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        
        // 有两种情况，要么p1越界，要么p2越界
        while (p1 <= M) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        
        // 将temp数组拷贝到arr数组上
        for (int j = 0; j < temp.length; j++) {
            arr[L + j] = temp[j];
        }
    }
    
    /** =============================递归实现方式============================= */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    
    
    /** =============================非递归实现方式（采用步长实现方式）============================= */
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        
        int N = arr.length;
        // 步长(变化 1--2--4--8--16...)
        int mergeSize = 1;
        // 防止数组越界
        while (mergeSize < N) {
            // 当前左侧数组的第一个位置
            int L = 0;
            while (L < N) {
                // 如果步长 > 数组 - 左侧数组第一个位置的下标
                // 即下一次不够再走一步
                if (mergeSize >= N - L) {
                    break;
                }
                // 当前左侧数组的最后（用作数组的中间值位置）
                int M = L + mergeSize - 1;
                // 当前右侧数组的最右侧位置
                int R = M + Math.min(mergeSize, N - M -1);
                merge(arr, L, M, R);
                // 更新下一个左侧数组的最左侧位置
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
            
            // 步长*2
            mergeSize <<= 1;
        }
    }
    
    
    
    
    /** =============================设计对数器============================= */
    
    /** 
     * 初始化随机数组 
     * maxSize: 初始化出来的数组的大小size
     * maxValue: 初始化出来的数组中元素的最大值
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)Math.random() * (maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.random() * (maxValue + 1) - (int)Math.random() * (maxValue + 1);
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
    
    /** 判断两个数组是否一样 */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) ||
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
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {301, 784, 354};

        // 非递归-归并排序实现
        mergeSort2(arr);

    //     int testTime = 500000;
    //     int maxSize = 100;
    //     int maxValue = 100;
    //     System.out.println("测试开始！");
    //     for (int i = 0; i < testTime; i++) {
    //         // 初始化随机数组
    //         // 拷贝一份数组，并分别进行验证，看两者的结果是否一样
    //         int[] arr1 = generateRandomArray(maxSize, maxValue);
    //         int[] arr2 = copyArray(arr1);
    //
    //         mergeSort1(arr1);
    //         mergeSort2(arr2);
    //
    //         if (!isEqual(arr1, arr2)) {
    //             System.out.println("出错了！");
    //             printArray(arr1);
    //             printArray(arr2);
    //             break;
    //         }
    //     }
    //     System.out.println("测试结束！");
    }
}
