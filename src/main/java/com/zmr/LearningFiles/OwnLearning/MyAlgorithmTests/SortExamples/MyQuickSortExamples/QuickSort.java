package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.SortExamples.MyQuickSortExamples;

import java.util.Stack;

/**
 * @version 1.0
 * @description 快速排序 --> 来自“荷兰国旗问题”的延伸
 * @date 2023/2/12 10:10
 */
public class QuickSort {
    /**===========================荷兰国旗问题=========================*/
    /** 
     * 荷兰国旗问题 
     * 最右侧的R每次被选出来作为那个x
     * 返回值：[a,b]，表示的是数组arr中等于x的范围区间
     * 
     * 
     * 解法：
     * 1、当前数 < 目标数
     * ...当前数和小于区下一个数做交换
     * ...小于区向右扩展1位
     * ...当前数向右走1位
     * 
     * 2、当前数 == 目标数
     * ...当前数直接跳下一个
     * 
     * 3、当前数 > 目标数
     * ... 当前数和大于区前一个数做交换
     * ... 大于区向左扩展1位
     * ... 当前数停留在原地
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 }; 
        }
        if (L == R) {
            return new int[] { L, R };
        }
        // 声明3个辅助指针
        // 小于区域最右侧指针
        int less = L - 1;
        // 大于区最左侧指针(因为数组最右侧)
        int more = R;
        // 当前正在和x比较的数值的下标
        int index = L;
        
        // 当前要和x进行比较的数的下标没有和大于区碰撞(当index == more的时候碰撞停止)
        while (index < more) {
            // arr[R]作为每次比较的x
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                // 当前数和小于区下一个数做交换
                //swap(arr, index, less+1);
                //less++;
                //index++;
                
                // 简写
                swap(arr, index++, ++less);
            } else {
                // 当前数和大于区前一个数做交换
                //swap(arr, index, more-1);
                //more--;
                
                // 简写
                swap(arr, index, --more);
            }
        }
        
        // 最后将R和大于区第一个元素进行交换，因为R位置原本是作为选定的X值出现的，故而属于等于区数据
        swap(arr, more, R);
        // 返回范围{小于区最后位置 + 1, 大于区第一个位置【因为上面有最后的一次交换】}
        return new int[] { less + 1, more };
    }
    
    /** 数组中数据交换方法 */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    /**=========================快速排序(递归方式)===========================*/
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    
    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        
        // 为了避免最坏情况出现，每次都随机一个数和R位置的数据进行交换
        swap(arr, L + (int)(Math.random()* (R - L + 1)), R);
        
        // equalArea中的第一个元素是等于区最左侧，第二个元素是等于区最后一个元素位置
        int[] equalArea = netherlandsFlag(arr, L, R);
        // 递归处理小于区数据
        process(arr, L, equalArea[0] - 1);
        // 递归处理大于区数据
        process(arr, equalArea[1] + 1, R);
    }
    
    
    /**=========================快速排序(非递归方式)==========================*/
    /** 非递归版本需要的辅助类(要处理的是什么范围上的排序) */
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
        swap(arr, (int)(Math.random()*N), N - 1);
        int[] equalArea = netherlandsFlag(arr, 0, N - 1);
        // 等于区最左侧元素下标
        int el = equalArea[0];
        // 等于区最右侧元素下标
        int er = equalArea[1];
        // 非递归的方式，所以要自己使用栈来实现【递归方式实际上就是使用的系统中栈】
        // 栈中存放的元素为下一次要处理的数组区间(结合荷兰国旗问题可以很快找到)
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, el - 1));
        stack.push(new Op(er + 1, N - 1));
        
        while (!stack.isEmpty()) {
            // 这里的op就是当前正在操作的区域的数组下标范围
            Op op = stack.pop();
            if (op.l < op.r) {
                // 随机一个位置和op.r进行交换
                swap(arr, op.l + (int)(Math.random()*(op.r - op.l + 1)), op.r);
                // 找到等于区域的范围
                equalArea = netherlandsFlag(arr, op.l, op.r);
                // 计算出新的数组范围内等于区域的最左侧元素下标和最右侧元素下标
                el = equalArea[0];
                er = equalArea[1];
                stack.push(new Op(op.l, el - 1));
                stack.push(new Op(er + 1, op.r));
            }
        }
    }
    
    
    
    /**=========================对数器==========================*/
    
    /** 归并排序 */
    public static void merge(int[] arr, int L, int M ,int R) {
        // 声明临时数组
        int[] temp = new int[R - L + 1];
        int i = 0;
        // 声明两个辅助指针
        int p1 = L;
        int p2 = M + 1;
        
        // 当两个指针都没有越界的时候
        while (p1 <= M && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        
        // 两个数组越界情况处理
        while (p1 <= M) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        
        // 最后将数组拷贝回去
        for (int j = 0; j < temp.length; j++) {
            arr[L+j] = temp[j];
        }
        
    }
    
    public static void mergeSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        
        int N = arr.length;
        // 步长(1-2-4-8-...)
        int mergeSize = 1;
        // 防止数组越界
        while (mergeSize < N) {
            // 当前左侧数组的第一个位置
            int L = 0;
            while (L < N) {
                // 如果步长 > 数组 - 左侧数组的第一个位置的下标
                // 即下一次不够再走一步
                if (mergeSize >= N - L) {
                    break;
                }
                // 当前左侧数组的最后
                int M = L + mergeSize - 1;
                // 当前右侧数组的最右侧位置
                int R = M + Math.min(mergeSize, N - M - 1);
                merge(arr, L, M, R);
                // 更新下一个最左侧数组的位置
                L = R + 1;
            }

            // 防止溢出
            if (mergeSize > N / 2) {
                break;
            }
            
            // 步长*2
            mergeSize <<= 1;
        }
    }
    
    
    /** 随机数组生成方法 */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random()*(maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(maxValue + 1)) - (int)(Math.random() * maxValue);
        }
        return arr;
    }
    
    /** 拷贝数组方法 */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }
    
    
    /** 比较两个数组是否一致*/
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
    
    /** 打印数组 */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    /** 跑大样本测试 */
    public static void main(String[] args) {
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机生成数组，然后判断两种方式生成的数据是否正确
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);

            quickSort1(arr1);
            quickSort2(arr3);
            mergeSort(arr2);
            
            if (!equalArray(arr1, arr2) || !equalArray(arr3, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println("测试完毕！");
    }
}
