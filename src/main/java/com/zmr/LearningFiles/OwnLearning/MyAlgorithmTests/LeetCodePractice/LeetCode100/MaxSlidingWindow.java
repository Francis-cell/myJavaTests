package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.TestTools.PrintUtils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 滑动窗口最大值 </p>
 */
public class MaxSlidingWindow {
    /**
     * <p> 暴力解 </p>
     * <p> 时间复杂度 O((n - k + 1) * k) ~= O(nk) </p>
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingCrude(int[] nums, int k) {
        List<Integer> tmpAns = new ArrayList<>();
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            int tmpMaxVal = nums[i];
            for (int j = i; j < nums.length && j < i + k; j++) {
                tmpMaxVal = Math.max(tmpMaxVal, nums[j]);
            }
            // 后续长度已经小于 k 了，无需再进行记录了
            if (i > nums.length - k) {
                break;
            }
            tmpAns.add(tmpMaxVal);
        }

        int[] ans = new int[tmpAns.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = tmpAns.get(i);
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }

    public static void main(String[] args) {
        // [3,3,5,5,6,7]
        int[] nums1 = new int[] {1,3,-1,-3,5,3,6,7};
        int k1 = 3;

        // [1]
        int[] nums2 = new int[] {1};
        int k2 = 1;

        // [1]
        int[] nums3 = new int[] {1, -1};
        int k3 = 1;

        int[] ans1 = maxSlidingCrude(nums1, k1);
        PrintUtils.printArr(ans1);
        int[] ans2 = maxSlidingCrude(nums2, k2);
        PrintUtils.printArr(ans2);
        int[] ans3 = maxSlidingCrude(nums3, k3);
        PrintUtils.printArr(ans3);
    }
}
