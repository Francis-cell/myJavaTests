package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyMergeSortExamples;

import java.util.Arrays;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description LeetCode链接：https://leetcode.com/problems/count-of-range-sum/
 *              给定一个数组arr，两个整数lower和upper，返回arr中有多少个子数组累加和在[lower, upper]范围上
 * 
 * ======解题步骤=======
 * 1、前缀和数组sum[]
 * 2、原本范围[lower, upper] --> 经过前缀和数组处理，对于前缀和数组上的每个元素来说，范围是[x-upper, x-lower]
 * 3、找sum[]在x位置之前有多少个元素满足 [x-upper, x-lower] 条件
 * 4、使用归并排序处理
 * 5、merge左右，找到一种不会退的方式，时间复杂度为O(N)
 * ====================
 * 
 * @date 2023/2/11 15:27
 */
public class CountOfRangeSum {
    /**===============================归并排序解法==========================================*/
    /** 求出arr数组的前缀和数组(即便是暴力破解，使用这种方式也可以将时间复杂度降低到O(n^2)) */
    public static int[] preSumArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        // 前缀和数组
        int[] preSumArr = new int[arr.length];
        preSumArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSumArr[i] = preSumArr[i-1] + arr[i];
        }
        return preSumArr;
    }
    
    /** 递归处理流程 */
    public static int process(int[] sum, int L, int R, int upper, int lower) {
        // 说明当前位置上只有一个元素，那么只需要判断是否满足 lower <= sum[X] <= upper 即可
        if (L == R) {
            return sum[L] >= lower && sum[R] <= upper ? 1 : 0;
        }

        int mid = L + ((R - L) >> 1);
        return process(sum, L, mid, upper, lower) + 
                process(sum, mid + 1, R, upper, lower) +
                merge(sum, L, mid, R, upper, lower);
    }
    
    /** merge方法 */
    public static int merge(int[] sum, int L, int M, int R, int upper, int lower) {
        int ans = 0;
        // 声明两个辅助指针，用来形成滑动窗口
        int windowL = L;
        int windowR = L;
        // 形成的区间为 [windowL, windowR)
        // 计算新形成范围的[x-upper, x-lower]的数据x来自于右侧的数组
        for (int i = M + 1; i <= R; i++) {
            long min = sum[i] - upper;
            long max = sum[i] - lower;
            // 1、右指针没有越界；2、右指针所在的前缀和数组sum[]元素 <= max
            // 那么右指针向右移动一位(还没找到临界的那个数字的下标)
            // 右指针windowR使用的是开区间，故而使用的是sum[]元素 <= max
            while (windowR <= M && sum[windowR] <= max) {
                windowR++;
            }
            // 同理左指针也一样
            // 右指针windowL使用的是闭区间，故而使用的是sum[i] < min
            while (windowL <= M && sum[windowL] < min) {
                windowL++;
            }
            // 此处因为windowR是开区间，故而有下面几种情况
            // 1、[1, 1) --> 0
            // 2、[1, 2) --> 1
            // 故而，如果windowR和windowL指向同一个位置的时候，ans的值+0
            ans += windowR - windowL;
        }


        // 声明一个临时数组
        int[] tempArr = new int[R - L + 1];
        int i = 0;

        // 声明两个辅助指针
        int p1 = L;
        int p2 = M + 1;

        // 判断是否越界
        while (p1 <= M && p2 <= R) {
            tempArr[i++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
        }

        // 两个数组必然有一个越界
        while(p1 <= M) {
            tempArr[i++] = sum[p1++];
        }
        while (p2 <= R) {
            tempArr[i++] = sum[p2++];
        }

        // 拷贝数组
        for (int j = 0; j < tempArr.length; j++) {
            sum[L+j] = tempArr[j];
        }

        return ans;
    }

    //public static int merge(int[] arr, int L, int M, int R, int lower, int upper) {
    //    int ans = 0;
    //    int windowL = L;
    //    int windowR = L;
    //    // [windowL, windowR)
    //    for (int i = M + 1; i <= R; i++) {
    //        long min = arr[i] - upper;
    //        long max = arr[i] - lower;
    //        while (windowR <= M && arr[windowR] <= max) {
    //            windowR++;
    //        }
    //        while (windowL <= M && arr[windowL] < min) {
    //            windowL++;
    //        }
    //        ans += windowR - windowL;
    //    }
    //    int[] help = new int[R - L + 1];
    //    int i = 0;
    //    int p1 = L;
    //    int p2 = M + 1;
    //    while (p1 <= M && p2 <= R) {
    //        help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
    //    }
    //    while (p1 <= M) {
    //        help[i++] = arr[p1++];
    //    }
    //    while (p2 <= R) {
    //        help[i++] = arr[p2++];
    //    }
    //    for (i = 0; i < help.length; i++) {
    //        arr[L + i] = help[i];
    //    }
    //    return ans;
    //}
    
    
    /** 主程序 */
    public static int countOfRangeSum(int[] arr, int lower, int upper) {
        return process(preSumArray(arr), 0, arr.length -1, upper, lower);
    }
    
    
    /** =====================================对数器====================================== */
    public static int test(int[] arr, int lower, int upper) {
        int res = 0;
        // 计算出前缀和数组
        int[] sum = preSumArray(arr);

        //// 判断单元素是否满足条件
        //for (int i = 0; i < sum.length; i++) {
        //    if (arr[i] >= lower && arr[i] <= upper) {
        //        res++;
        //    }
        //}
        
        
        //for (int i = 0; i < arr.length; i++) {
        //    for (int j = i; j < arr.length; j++) {
        //        int tempVal = 0;
        //        for (int k = i; k <= j; k++) {
        //            tempVal += arr[k];
        //        }
        //        if (tempVal >= lower && tempVal <= upper) {
        //            res++;
        //        }
        //    }
        //}

        // 从[i-j] 位置的 子数组的累加和为 [0,j] - [0, (i-1)] 的值
        for (int i = 0; i < sum.length; i++) {
            for (int j = i; j < sum.length; j++) {
                // 判断单元素是否满足条件
                if (i == j && arr[i] >= lower && arr[i] <= upper) {
                    res++;
                }
                else if (i == 0 && i != j) {
                    if (sum[j] >= lower && sum[j] <= upper) {
                        res++;
                    }
                }
                else if (i != j  && (sum[j] - sum[i-1]) >= lower && (sum[j] - sum[i-1]) <= upper) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    /** 随机数组生成 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
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
    
    
    public static void main(String[] args) {
        //int[] arr2 = {-75, -16, 15};
        ////int[] arr2 = {-37, 47, 51, 49, -92, -14};
        //int lower = 0;
        //int upper = 51;
        //////int val1 = countOfRangeSum(arr1, lower, upper);
        //int val2 = test(arr2, lower, upper);
        //////System.out.println(val1);
        //System.out.println(val2);


        int testTimes = 50;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 生成随机数组，拷贝数组，测试结果
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            // 生成随机的upper和lower的值
            int tempInt1 = (int) (Math.random() * (maxSize + 1));
            int tempInt2 = (int) (Math.random() * (maxSize + 1));
            int lower = Math.min(tempInt1, tempInt2);
            int upper = Math.max(tempInt1, tempInt2);

            if (countOfRangeSum(arr1, lower, upper) != test(arr2, lower, upper)) {
                System.out.println("出错了！");
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                System.out.println(countOfRangeSum(arr1, lower, upper));
                System.out.println(test(arr2, lower, upper));
                System.out.println(lower);
                System.out.println(upper);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
