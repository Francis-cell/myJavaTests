package main.java.com.zmr.MyLeetCodeTests.My2022Lists.D12_24.On;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/12/24 21:36
 */
public class SolutionHashMap {
    /** 使用HashMap辅助计算sum和 */
    public int[] towSum(int[] nums, int target) {
        int size = nums.length;
        // 创建辅助hashMap，空间复杂度为O(n)
        HashMap<Integer, Integer> dic = new HashMap<>();
        // 单层循环，时间复杂度为O(n)
        for (int i = 0; i < size; i++) {
            if (dic.containsKey(target - nums[i])) {
                return new int[] { dic.get(target - nums[i]), i };
            }

            dic.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        SolutionHashMap shm = new SolutionHashMap();
        int[] ints = {2, 7, 11, 15};
        System.out.println("最终结果为：" + Arrays.toString(shm.towSum(ints, 22)));
    }
}
