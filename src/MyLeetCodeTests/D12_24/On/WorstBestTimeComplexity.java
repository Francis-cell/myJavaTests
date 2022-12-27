package MyLeetCodeTests.D12_24.On;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/12/24 20:20
 */
public class WorstBestTimeComplexity {
    /** 生成一个数组，数组元素为{1,2,3,4,...,n }, 顺序打乱*/
    public int[] randomNumbers(int n) {
        Integer[] nums = new Integer[n];
        // 生成数组nums
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        // 随机打乱数组元素
        Collections.shuffle(Arrays.asList(nums));
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        WorstBestTimeComplexity wbt = new WorstBestTimeComplexity();
        System.out.println("打乱后的数组元素为：" + Arrays.toString(wbt.randomNumbers(8)));
    }
}
