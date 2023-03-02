package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyMergeSortExamples;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 小和问题（使用归并排序的方式实现）
 * @date 2023/2/10 22:29
 */
public class SmallSum {
    /** ==========================归并排序解决方式============================= */
    
    /** 声明merge方法 */
    public static int merge (int[] arr, int L, int M, int R) {
        // 辅助数组，用于最后拷贝数据
        int[] tempArr = new int[R - L + 1];
        int i = 0;
        // 声明两个辅助指针
        int p1 = L;
        int p2 = M + 1;
        
        // 小和问题的最终返回值
        int res = 0;
        
        // 如果左指针&右指针都没有越界
        if (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            // 当右侧数据大于左侧的时候，才会执行操作
            tempArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        
        // 有两种情况，p1越界，p2越界
        while (p1 <= M) {
            tempArr[i++] = arr[p1++];
        }
        while (p2 <= R) {
            tempArr[i++] = arr[p2++];
        }
        
        // 将temp数组拷贝到arr上
        for (int j = 0; j < arr.length; j++) {
            arr[L + j] = tempArr[j];
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
    
    
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }
    
    
    /** ============================暴力破解方式=================================== */
    public static int comparator(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }
    
    
    /** ===============================对数器===================================== */
    
    /** 随机生成数组方法 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)Math.random()*(maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.random()*(maxValue + 1) - (int)Math.random()*(maxValue + 1);
        }
        return arr;
    }    
    
    /** 比较两个数组是否一致 */
    public static boolean isEqual(int[] arr1, int[] arr2) {
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
    
    
    public static void main(String[] args) {
        int testTime = 500000;
        int maxValue = 100;
        int maxSize = 100;
        System.out.println("开始测试！");
        for (int i = 0; i < testTime; i++) {
            // 初始化随机数组，拷贝一份两者分别进行处理
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            
            // 使用两种不同的处理方式处理
            if (smallSum(arr1) != comparator(arr2)) {
                System.out.println("出错了！");
                System.out.println("arr1:" + arr1);
                System.out.println("arr2:" + arr2);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
