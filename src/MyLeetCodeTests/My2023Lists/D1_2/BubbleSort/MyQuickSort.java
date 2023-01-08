package MyLeetCodeTests.My2023Lists.D1_2.BubbleSort;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @descriptipon 快速排序
 * @date 2023/1/2 11:42
 */
public class MyQuickSort {
    /** 元素交换方法 */
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /** 哨兵划分 */
    static int partition (int[] nums, int left, int right) {
        // 以nums[left]作为基准数
        int i = left, j = right;
        while (i < j) {
            // 从右向左找首个小于基准数的元素, nums[j]表示当前元素
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            // 从左向右找首个大于基准数的元素, nums[i]表示当前元素
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            // 交换这两个元素的值
            swap(nums, i, j);
        }
        // 将基准数交换到i和j重合的位置上
        swap(nums, i, left);
        // 返回基准数的索引
        return i;
    }

    /** 快速排序 */
    static void quickSort(int[] nums, int left, int right) {
        // 子数组长度为1时终止递归
        while (nums.length == 1) {
            return;
        }
        // 哨兵划分
        int pivot = partition(nums, left, right);
        // 递归左子数组、右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public static void main(String[] args) {

    }
}
