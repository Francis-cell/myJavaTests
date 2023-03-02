package com.zmr.LearningFiles.MyAlgorithmTests.SortExamples.MyQuickSortExamples.quickSortMulti;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName SecondQuickSort
 * @Description 快速排序第二次敲
 * @Version 1.0
 **/
public class SecondQuickSort {
    /** 数组元素交换方法swap() */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    
    /** 
     * 荷兰国旗问题 
     * 返回的int[]数组存储的是arr中等于x的范围区间
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        // 传入的L和R是错误的数据
        if (L > R) {
            return new int[] {-1, 1};
        }
        if (L == R) {
            return new int[] {L, R};
        }
        
        // 声明3个辅助指针
        // 1、小于区最右侧的指针
        int less = L - 1;
        // 大于区最左侧指针
        int more = R;
        // 当前正在和x比较的数组的下标(初始的时候这个下标是数组的最左侧位置)
        int index = L;
        
        // 当前要和x比较的数的下标没有和大于区碰撞
        // 当index == more的时候发生碰撞，停止
        while (index < more) {
            // arr[R]作为每次进行比较的那个x
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                // 当前下标的数据 < 哨兵数据
                // 1、当前数和小于区的下一个数进行交换
                // 2、小于区向右扩展一位；当前要比较的数向右移动一位
                swap(arr, index++, ++less);
            } else {
                // 当前下标的数据 > 哨兵数据
                // 1、当前数和大于区的前一位数进行交换
                // 2、大于区向左扩1位；当前数据不移动
                swap(arr, index, --more);
            }
        }
        
        // 上面的比较操作完之后，将大于区最后一个元素移动到等于区，因为本身
        // 就是使用的它作为x进行比较的[和大于区第一个元素进行交换]
        swap(arr, more, R);
        // 返回等于区数据的下标范围,less + 1和more[因为more是最后换回来的x]
        return new int[] {less + 1, more};
    }
    
    /** 快速排序，递归方式 */
    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        
        // 为了避免最坏情况出现，每次都是随机一个位置的数和R位置的数据进行交换
        swap(arr, L + (int)(Math.random()*(R - L + 1)), R);
        
        // equalArea中的第一个元素是等于区的最左侧，第二个元素是等于区的最后一个元素
        int[] equalArea = netherlandsFlag(arr, L, R);
        // 递归处理小于区数据
        process(arr, L, equalArea[0] - 1);
        // 递归处理大于区数据
        process(arr, equalArea[1] + 1, R);
    }
    
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    
    
    /** 快速排序--非递归版本 */
    /** 非递归版本需要的辅助类（要处理的是什么范围上的排序） */
    public static class Op {
        public int l;
        public int r;
        
        public Op(int left, int right) {
            l = left;
            r = right;
        }
    }
    
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        
        int N = arr.length;
        // 为了避免出现最糟糕的情况，在数组中随机一个数据作为x
        swap(arr, (int)(Math.random()*N), N - 1);
        int[] equalArea = netherlandsFlag(arr, 0, N - 1);
        // 等于区最左侧元素下标
        int el = equalArea[0];
        // 等于区最右侧元素下标
        int er = equalArea[1];
        // 非递归方式，所以要自己使用栈来实现【递归方式使用的就是系统栈】
        // 栈中存放的元素为下一次要处理的数组区间(结合荷兰国旗问题进行处理)
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, el - 1));
        stack.push(new Op(er + 1, N - 1));
        
        // 如果栈中元素为空，说明结束了
        while (!stack.isEmpty()) {
            // 这里的op其实就是当前要操作的数组下标范围
            Op op = stack.pop();
            if (op.l < op.r) {
                // 随机一个位置和op.r进行交换
                swap(arr, op.r, op.l + (int)(Math.random()*(op.r - op.l + 1)));
                // 找到等于区域的范围
                equalArea = netherlandsFlag(arr, op.l, op.r);
                // 重新计算出新数组范围中等于区域的最左侧下标和最右侧区域下标
                el = equalArea[0];
                er = equalArea[1];
                stack.push(new Op(op.l, el - 1));
                stack.push(new Op(er + 1, op.r));
            }
        }
    }

    
    
    /** 随机生成数组 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random()*(maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(maxValue + 1)) - (int)(Math.random()*maxValue);
        }
        return arr;
    }
    
    /**判断两个数组是否相等 */
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
    
    
    /** 拷贝数组 */
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
    
    
    /** 对数器 */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    
    /** 输出数组的元素 */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    

    public static void main(String[] args) {
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始！");
        long start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            // 随机生成数组，拷贝数组，比较数组元素是否一致
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);

            quickSort(arr1);
            quickSort2(arr2);
            comparator(arr3);
            if (!equalArray(arr1, arr3) || !equalArray(arr2, arr3)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("测试结束！使用的时间为：" + (end - start));
    }
}
