package main.java.com.zmr.MyLeetCodeTests.My2023Lists.D1_2.BubbleSort;

import java.util.Arrays;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 冒泡排序实现
 * @date 2023/1/2 10:48
 */
public class MyBubbleSort {
    /** 冒泡排序 */
    static int[] bubbleSort(int[] nums) {
        int count = 0;
        // 外循环，待排序的元素数量为n-1、n-2、n-3...1
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环，冒泡操作
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    // 交换nums[j]和nums[j+1]的元素的值
                    int tempVal = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tempVal;
                    count++;
                }
            }
        }
        System.out.println("普通冒泡排序，" + count);
        return nums;
    }

    /** 引入flag的冒泡排序优化 */
    static int[] bubbleSortWithFlags(int[] nums) {
        // 如果某轮内循环没有交换元素，那么说明数组元素已经排序完成，可以跳出此轮内循环
        // 外循环，待排序的元素数量为n-1、n-2、n-3...1
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = false;
            // 内循环，冒泡操作
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    // 交换nums[j]和nums[j+1]的元素的值
                    int tempVal = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tempVal;
                    flag = true;
                    count++;
                }
            }
            // 如果内层循环中某一轮没有交换元素，那么直接结束排序并返回最终结果
            if (!flag) {
                break;
            }
        }
        System.out.println("冒泡排序带Flag，" + count);
        return nums;
    }

    public static void main(String[] args) {
        // 初始化数组
        int[] nums = {1, 4, 5, 7, 3, 6, 0, 2};
        int[] nums1 = {1, 3, 4, 5, 7, 6, 0, 2};
        int[] ints = bubbleSort(nums);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(bubbleSortWithFlags(nums1)));
    }
}
