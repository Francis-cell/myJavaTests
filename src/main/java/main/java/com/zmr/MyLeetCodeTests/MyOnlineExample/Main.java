package main.java.com.zmr.MyLeetCodeTests.MyOnlineExample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 获取充电设备的个数
        int n = in.nextInt();
        int[] powerArr = new int[n];
        int maxVal = 0;

        // 获取充电设备的输出功率
        for (int i = 0; i < n; i++) {
            powerArr[i] = in.nextInt();
        }
        // 获取充电站的最大输出功率p_max
        int powMax = in.nextInt();

        // 如果powerArr中最小的元素大于powMax，则输出结果为0
        // 执行排序
        int[] tempArr = bubbleSort(powerArr);

        for (int i = 0; i < n; i++) {
            if (powMax - tempArr[i] >= 0) {
                maxVal += tempArr[i];
                powMax -= tempArr[i];
            }
        }

        System.out.println(maxVal);
    }

    /** 冒泡排序 */
    static int[] bubbleSort(int[] nums) {
        // 外循环，需要循环n-1, n-2, ..., 1
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环，进行冒泡操作
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    int tempVal = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tempVal;
                }
            }
        }
        return nums;
    }
}
