package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

/**
 * <p> 和为 k 的子数组 </p>
 * <pre>
 *      1 <= nums.length <= 2 * 104
 *      -1000 <= nums[i] <= 1000
 *      -107 <= k <= 107
 * </pre>
 */
public class SubarraySum {
    /**
     * <p> 暴力解 (双指针解) </p>
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySumCrude(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            // 先判断当前元素的值是否是 k
            if (count == k) {
                ans++;
            }
            // 当前元素值不是 k
            for (int j = i + 1; j < nums.length; j++) {
                count += nums[j];
                if (count == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * <p> 双指针解 </p>
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumWithTwoCurs(int[] nums, int k) {
        return 1;
    }

    public static void main(String[] args) {
        // 2
        int[] nums1 = new int[] {1,1,1};
        int k1 = 2;

        // 2
        int[] nums2 = new int[] {1,2,3};
        int k2 = 3;

        // 3
        int[] nums3 = new int[] {1,-1,0};
        int k3 = 0;

        // 3
        int[] nums4 = new int[] {0,0};
        int k4 = 0;

        System.out.println(subarraySumCrude(nums1, k1));
        System.out.println(subarraySumCrude(nums2, k2));
        System.out.println(subarraySumCrude(nums3, k3));
        System.out.println(subarraySumCrude(nums4, k4));
    }
}
