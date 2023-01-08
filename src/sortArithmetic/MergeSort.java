package sortArithmetic;

import MyLeetCodeTests.My2022Lists.D12_24.On.WorstBestTimeComplexity;

import java.util.Arrays;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/12/24 21:04
 */
public class MergeSort implements IArraySort{
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对arr进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 如果arr的长度小于2，则直接返回即可
        if (arr.length < 2) {
            return arr;
        }

        // 找到原数组的中间位置
        int middle = (int) Math.floor(arr.length / 2);
        // 获取left和right数组
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        // 递归合并数组
        return merge(sort(left), sort(right));
    }

    /** 合并两个数组 */
    protected int[] merge(int[] left, int[] right) {
        // 创建一个合并之后的数组
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                // 拷贝left数组从1到末尾给left数组
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        // 如果left数组还有剩余
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        // 如果right数组还有剩余
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        WorstBestTimeComplexity wbt = new WorstBestTimeComplexity();
        MergeSort ms = new MergeSort();
        int[] ints = wbt.randomNumbers(8);
        System.out.println("排序前数组：" + Arrays.toString(ints));
        System.out.println("排序后数组：" + Arrays.toString(ms.sort(ints)));
    }
}
