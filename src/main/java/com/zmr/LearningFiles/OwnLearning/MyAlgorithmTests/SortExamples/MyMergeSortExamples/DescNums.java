package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.SortExamples.MyMergeSortExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 逆序对问题
 * @date 2023/2/10 23:07
 */
public class DescNums {
    
    /** ==========================归并排序实现方式============================== */
    /** merge方法 */
    public static int merge(int[] arr, int L, int M, int R) {
        // 先声明一个临时数组存放中间临时产生的结果数组
        int[] temp = new int[R - L + 1];
        int i = temp.length-1;
        
        // 声明两个辅助指针
        int p1 = M - 1;
        int p2 = R;
        
        // 最终结果res
        int res = 0;
        
        // 当两个指针p1和p2都没有越界的时候
        if (p1 >= L && p2 > M) {
            res += arr[p1] > arr[p2] ? (p2 - M + 1) : 0;
            temp[i--] = arr[p1] >= arr[p2] ? arr[p2--] : arr[p1--];
            //temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        
        // 两者其中一个指针越界
        while(p1 >= L) {
            temp[i--] = arr[p1--];
        }
        while (p2 > M) {
            temp[i--] = arr[p2--];
        }
        
        // 拷贝数组
        for (int j = 0; j < temp.length; j++) {
            arr[L + j] = temp[j];
        }
        
        return res;
    }
    
    /** 递归实现方式 */
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return (
                process(arr, L, mid) +
                process(arr, mid + 1, R) +
                merge(arr, L, mid, R)
        );
    }
    
    
    public static int descNums(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }
    
    
    /** ===============================对数器================================= */
    public static int comparator(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < i; j++) {
                res += arr[j] < arr[i] ? 1 : 0;
            }
        }
        return res;
    }
    
    /** 随机数组生成 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)Math.random()*(maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.random()*(maxValue + 1) - (int)Math.random()*(maxValue + 1);
        }
        return arr;
    }
    
    /** 数组拷贝方法 */
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
    
    
    /** 测试方法 */
    public static void main(String[] args) {
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机生成数组，拷贝数组，比较测试结果
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            
            if (descNums(arr1) != comparator(arr2)) {
                System.out.println("出错了！");
                System.out.println("arr1" + arr1);
                System.out.println("arr2" + arr2);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
