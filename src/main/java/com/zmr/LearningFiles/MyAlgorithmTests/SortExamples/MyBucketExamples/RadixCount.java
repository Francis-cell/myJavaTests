package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyBucketExamples;

import java.util.Arrays;

/**
 * @ClassName RadixCount
 * @Description 基数排序[限制：只能处理能转换成10进制的数字]
 **/
public class RadixCount {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 执行基数排序
        radixSort(arr, 0, arr.length - 1, myBits(arr));
    }
    
    /** 找到数组arr中位数最多的那个数字的位数 */
    public static int myBits(int[] arr) {
        // 先找到最大值，然后一直/10，位数+1，最终返回
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int ans = 0;
        while (max!= 0) {
            ans++;
            max /= 10;
        }
        return ans;
    }
    
    /** 
     * 获取一个数字指定位上的数字的值 
     * x表示传入的数字
     * d表示要提取数字的某位
     *    案例：
     *    x=103, d=1, ans=3
     *    x=208, d=2, ans=0
     */
    public static int getDigit(int x, int d) {
        return ((x / (int) Math.pow(10, d - 1)) % 10);
    }
    
    
    /** 
     * 基数排序核心方法 
     * 这里的L...R表示要进行排序的数组的范围
     * digit表示最大的十进制位数
     * 案例数组：{103, 204, 15, 5, 89, 37}
     * 位数补全：{103, 204, 015, 005, 089, 037}
     */
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数，就准备多少个辅助空间（可以节省桶的申请-骚操作）
        /** [length = 6] */
        int[] help = new int[R - L + 1];
        // 有多少位就进出多少次(最外层)[1-digit,是为了方便下面取位操作]
        for (int d = 1; d <= digit; d++) {
            // 10个空间
            // count[]数组表示的是前缀和数组
            int[] count = new int[radix];
            /** [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
             * 个位处理完之后，count = {0, 0, 0, 1, 1, 2, 0, 1, 0, 1} 
             * 十位处理完之后，count = {3, 1, 0, 1, 0, 0, 0, 0, 1, 0}
             * 百位处理完之后，count = {4, 1, 1, 1, 0, 0, 0, 0, 0, 0}
             */
            for (i = L;  i <= R ; i++) {
                // x=103, d=1, ans=3
                // x=208, d=2, ans=0
                // 以个位为案例：
                // 1、获取个位的数字
                j = getDigit(arr[i], d);
                count[j]++;
            }
            
            /** 个位处理完之后，count = {0, 0, 0, 1, 2, 3, 3, 4, 4, 5}
             * 十位处理完之后，count = {3, 4, 4, 5, 5, 5, 5, 5, 6, 6}
             * 百位处理完之后，count = {4, 5, 6, 7, 7, 7, 7, 7, 7, 7}
             */
            // 计算前缀和数组
            for (int k = 1; k < radix; k++) {
                count[k] = count[k] + count[k - 1];
            }
            
            // TODO--关键--模拟了出桶操作
            // 从右往左 {103, 204, 015, 005, 089, 037}
            for (i = R; i >= L; i--) {
                // 个位操作：存储位数 {7, 9, 5, 5, 4, 3}
                j = getDigit(arr[i], d);
                // 将数字依次放到辅助数组 0  1  2  3  4  5  6  7  8  9
                // 个位操作： 初始count[] = {0, 0, 0, 1, 1, 2, 0, 1, 0, 1}
                //          前缀和count[] = {0, 0, 0, 1, 2, 4, 4, 5, 5, 6}
                //          help[] = {103, 204, 015, 005, 037, 089}
                // 十位操作：初始count[] = {3, 1, 0, 1, 0, 0, 0, 0, 1, 0}
                //         前缀和count[] = {3, 4, 4, 5, 5, 5, 5, 5, 6, 0}
                //          help[] = {103, 204, 005, 015, 037, 089}
                // 百位操作：初始count[] = {4, 1, 1, 0, 0, 0, 0, 0, 0, 0}
                //         前缀和count[] = {4, 5, 6, 6, 6, 6, 6, 6, 6, 6}
                //         help[] = {005, 015, 037, 089, 103, 204}
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            
            // 将处理之后的临时数组help拷贝给原本的数组
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }
    }
    
    
    /** 对数器 */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    
    /** 随机数组 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random()*(maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(maxValue + 1));
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
    
    /** 数组比较 */
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
    
    /** 数组打印 */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //int[] originArr = {103, 204, 15, 5, 89, 37};
        //int[] arr2 = copyArray(originArr);
        //radixSort(originArr);
        //comparator(arr2);
        //if (!isEqualArray(originArr, arr2)) {
        //    System.out.println("出错了！");
        //    printArray(originArr);
        //    printArray(arr2);
        //}
        
        
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机数组，拷贝，处理，比较
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            //printArray(arr1);

            radixSort(arr1);
            comparator(arr2);
            if (!isEqualArray(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
