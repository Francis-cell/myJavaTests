package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyMergeSortExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 数组arr中有多少个num>右侧某数*2
 * @date 2023/2/11 13:56
 */
public class BigThanRightTwice {
    
    /**=============================归并排序实现=============================*/
    /** merge方法 */
    public static int merge(int[] arr, int L, int M, int R) {
        // 声明一个临时的数组
        int[] temp = new int[R - L + 1];
        int i = temp.length;
        
        // 声明两个辅助指针
        int p1 = M;
        int p2 = R;
        
        // 返回结果
        int res = 0;
        
        // 当p1和p2都没有越界的时候
        if (p1 >= L && p2 > M) {
            res += arr[p1] > 2 * arr[p2] ? (p2 - M + 1) : 0;
            temp[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        
        // 两个必有一个越界
        while (p1 >= L) {
            temp[i--] = arr[p1--];
        }
        while (p2 > M) {
            temp[i--] = arr[p2--];
        }
        
        // 拷贝给原本的数组
        for (int j = 0; j < temp.length; j++) {
            arr[L + j] = temp[j];
        }
        
        return res;
    }
    
    /** 递归实现 */
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        
        int mid = L + ((R - L) >> 1);
        
        return (
                process(arr, L, mid) + 
                process(arr, mid, R) +
                merge(arr, L, mid, R)
        );
        
    }
    
    public static int bigThanRightTwice(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }
    
    /** =============================对数器实现============================= */
    public static int test(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                res += arr[i] > arr[j] * 2 ? 1 : 0;
            }
        }
        return res;
    }
    
    /**=============================test=============================*/
    /** 随机生成数组 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)Math.random() * (maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.random()*(maxValue + 1) - (int)Math.random()*(maxValue + 1);
        }
        return arr;
    }
    
    /** 拷贝数组 */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        
        int[] tempArray = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            tempArray[i] = arr[i];
        }
        return tempArray;
    }
    
    public static void main(String[] args) {
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("开始测试！");
        for (int i = 0; i < testTimes; i++) {
            // 随机生成数组，拷贝数组，计算两种方式计算的结果
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            
            if (bigThanRightTwice(arr1) != test(arr2)) {
                System.out.println("出错了！");
                System.out.println(arr1);
                System.out.println(arr2);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
