package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.SortExamples.MyBucketExamples.BucketMulti;

import java.util.Arrays;

/**
 * @ClassName SecondRadixCount
 * @Description 基数排序实现[限制：只能处理能转换成10进制的数字]
 **/
public class SecondRadixCount {
    /** 基数排序主方法 */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 执行基数排序
        radixSort(arr, 0,arr.length - 1, myBits(arr));
    }
    
    /** 找到数组arr中位数最多的那个数字的位数 */
    public static int myBits(int[] arr) {
        // 先找到最大值，然后一直/10，位数+1，最终返回
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int ans = 0;
        while (max != 0) {
            ans++;
            max /= 10;
        }
        return ans;
    }
    
    /** 
     * 获取一个数字指定位上的数字的值
     * x表示传入的数字
     * d表示要提取的数字的某位
     * 案例：(1表示个位，2表示十位)
     * x=103, d=1, ans=3
     * x=208, d=2, ans=0
     */
    public static int getDigit(int x, int d) {
        return ((x / (int) Math.pow(10, d - 1)) % 10);
    }
    
    /** 基数排序核心方法 */
    public static void radixSort(int[] arr, int L, int R, int digit) {
        // 桶的数量
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少数，就准备多少辅助空间(这里使用的方法可以节省出桶申请)
        int[] help = new int[R - L + 1];
        // 有多少位就进出多少次(依次处理个位、十位、百位...)
        for (int d = 1; d <= digit ; d++) {
            // count[]数组表示的是前缀和数组(初始化的时候有10个空间)
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }

            // 处理完成之后，计算前缀和数组
            for (int k = 1; k < radix; k++) {
                count[k] = count[k] + count[k - 1];
            }
            
            // 关键--模拟出桶操作(从右侧逐个出桶)
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                // 将出桶元素放置到辅助数组help[]中
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            
            // 将处理之后的临时数组help[]拷贝回原本的数组
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
