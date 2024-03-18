package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.SortExamples.MyQuickSortExamples.quickSortMulti;

import java.util.Arrays;

/**
 * @ClassName ThirdQuickSort
 * @Description 快速排序实现--荷兰国旗问题
 **/
public class ThirdQuickSort {
    /** 数组元素交换方法 */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /** 
     * 荷兰国旗问题 
     * 返回的int[]数组存储的是arr中等于x的范围区间
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        // 如果传入的L和R是错误的数据
        if (L > R) {
            return new int[] {-1, 1};
        }
        // base case
        if (L == R) {
            return new int[] {L, R};
        }
        
        // 声明3个辅助指针
        // 1、小于区最右侧指针
        int less = L - 1;
        // 2、大于区最左侧指针
        int more = R;
        // 3、当前正在和x比较的数组的下标指针
        int index = L;
        
        // 当前要和x进行比较的数的下标没有和大于区碰撞
        // 当index == more的时候发生碰撞，停止
        while (index < more) {
            // arr[R]作为每次进行比较的那个x
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                // 当前下标的数据 < 哨兵数据
                // 1、当前数和小于区的下一个数(属于等于区的数据)进行交换
                // 2、小于区向右扩展一位；当前要比较的数index++
                //swap(arr, index, less+1);
                //less++;
                //index++;
                
                swap(arr, index++, ++less);
            } else {
                // 当前下标的数据 > 哨兵数据
                // 1、当前数和大于区前一位数据进行交换
                // 2、大于区向左扩展1位(因为交换过去的数据确定比哨兵大)；当前数据不移动
                //swap(arr, index, more-1);
                //more--;
                
                swap(arr, index, --more);
            }
        }
        
        // 上面的操作完成之后，将大于区最后一个元素(作为此次交换使用的哨兵数据)
        // 移动到等于区(和大于区最左侧数据进行交换即可)
        swap(arr, more, R);
        // 返回等于区数据的下标范围, less + 1 和 more
        return new int[] {less + 1, more};
    }
    
    /** 快速排序--递归方式实现 */
    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        
        // 为了避免排序过程中最坏的情况发生，每次都是随机一个位置和哨兵数据进行交换，作为此次比较的哨兵数据
        swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
        
        // 通过荷兰过期处理方法获取equalArea中的元素
        // 第一个元素是等于区的最左侧，第二个元素是等于区的最右侧
        int[] equalArea = netherlandsFlag(arr, L, R);
        // 递归处理小于区的数据
        process(arr, L, equalArea[0] - 1);
        // 递归处理大于区的数据
        process(arr, equalArea[1] + 1, R);
    }
    
    /** 快速排序主要方法 */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    
    /** 对数器方法 */
    public static void test(int[] arr) {
        Arrays.sort(arr);
    }
    
    /** 随机生成数组 */
    public static int[] generateRandomArray(int maxValue, int maxSize) {
        int[] arr = new int[(int)(Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * maxValue + 1) - (int)(Math.random() * maxValue + 1);
        }
        return arr;
    }
    
    /** 数组拷贝方法 */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] tempArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        return tempArr;
    }
    
    /** 两个数组判断是否元素一样 */
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
        int maxSize = 100;
        int maxValue = 100;
        int testTimes = 100000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机生成数组，拷贝，分别处理，比较
            int[] arr1 = generateRandomArray(maxValue, maxSize);
            int[] arr2 = copyArray(arr1);
            
            quickSort(arr1);
            test(arr2);
            
            if (!isEqualArray(arr1, arr2)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
