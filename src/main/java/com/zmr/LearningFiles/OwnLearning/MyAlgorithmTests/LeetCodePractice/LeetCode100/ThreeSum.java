package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.PrintUtils.PrintUtils;

import java.util.*;

/**
 * <p> 三数之和 </p>
 */
public class ThreeSum {
    /**
     * <p> 暴力解 </p>
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumCrude(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        // 3 级循环 (O ^ 3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i != j && j != k && (nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        ans.add(innerList);
                    }
                }
            }
        }

        ans = deduplicateLists(ans);
        return ans;
    }

    /**
     * <p> 三元组数据去重处理 </p>
     * @param lists
     * @return
     */
    public static List<List<Integer>> deduplicateLists(List<List<Integer>> lists) {
        Set<List<Integer>> set = new LinkedHashSet<>();
        for (List<Integer> list : lists) {
            // Sort the list for consistent comparison
            List<Integer> sortedList = new ArrayList<>(list);
            sortedList.sort(Integer::compareTo);
            // Add the sorted list to the set, which will automatically deduplicate
            set.add(sortedList);
        }
        // Convert the set back to a list
        return new ArrayList<>(set);
    }


    /**
     * <p> 排序 + 双指针 </p>
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumSortWithTwoCurs(int[] nums) {
        // 1、排序；
        // 2、固定一个元素 k，声明两个指针 l、r；l 起始指向 k + 1 位置；r 起始指向 r；
        // 3、收集 s = nums[k] + nums[l] + nums[r] = 0 的所有元素集合
        //    a. nums[k] > 0，直接结束
        //    b. k > 0、如果 nums[k] == nums[k - 1] 则跳过 nums[k] （这些都是重复结果，因此可以直接跳过）
        // 4、根据 s 的值进行判断，根据不同情况移动左右指针
        //    a. s < 0，移动左指针 l++ --> 跳过重复值;
        //    b. s > 0，移动右指针 r-- --> 跳过重复值;
        //    c. s = 0，记录结果，l++ && r-- --> 跳过重复值;

        List<List<Integer>> ans = new ArrayList<>();

        // 1、排序
        Arrays.sort(nums);

        // 2、固定一个元素 k，声明两个指针 l、r；l 起始指向 k + 1 位置；r 起始指向 r；
        for (int k = 0; k < nums.length; k++) {
            // a. nums[k] > 0，直接结束
            if (nums[k] > 0) {
                break;
            }
            // b. k > 0、如果 nums[k] == nums[k - 1] 则跳过 nums[k] （这些都是重复结果，因此可以直接跳过）
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            // 左右指针声明
            int l = k + 1, r = nums.length - 1;
            while (l < r) {
                int s = nums[k] + nums[l] + nums[r];
                // a. s < 0，移动左指针 l++;
                if (s < 0) {
                    while (l < r && nums[l] == nums[++l]) {}
                }
                // b. s > 0，移动右指针 r--;
                else if (s > 0) {
                    while (l < r && nums[r] == nums[--r]) {}
                }
                // c. s = 0，记录结果，左右指针均移动（且按照 3b 中的处理策略跳过重复的值）;
                else {
                    // 记录结果
                    ans.add(new ArrayList<>(Arrays.asList(nums[k], nums[l], nums[r])));
                    // 左指针移动跳过重复信息
                    while (l < r && nums[l] == nums[++l]) {}
                    // 右指针移动跳过重复信息
                    while (l < r && nums[r] == nums[--r]) {}
                }
            }
        }

        return ans;
    }

    /**
     * <p> 三片数据区域解 --- 写不出来了 🤣 </p>
     * <pre>
     * 1、排序
     * 2、找到里面 0 的下标集合
     * 3、根据不同的情况进行处理
     *  a. 如果存在 0，分为两种情况
     *    ①. 三个 0；
     *    ②. 一个 0、0 左侧取一个负数、0 右侧取一个正数；
     *  b. 如果不存在 0 元素，分为两种情况
     *    ①. 左侧取两个负数、右侧取一个正数；
     *    ②. 左侧取一个负数、右侧取两个正数；
     * </pre>
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumWithThreeParts(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        // 1、排序
        Arrays.sort(nums);

        // 2、找到里面 0 的下标集合
        List<Integer> zeroIndexArr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndexArr.add(i);
            }
        }

        // 3、根据不同的情况进行处理
        // a. 如果存在 0，分为两种情况
        // ①. 三个 0；
        // ②. 一个 0、0 左侧取一个负数、0 右侧取一个正数；
        // b. 如果不存在 0 元素，分为两种情况
        // ①. 左侧取两个负数、右侧取一个正数；
        // ②. 左侧取一个负数、右侧取两个正数；
        if (zeroIndexArr.size() != 0) {
            // ①. 三个 0；
            if (zeroIndexArr.size() == 3) {
                List<Integer> innerList = new ArrayList<>();
                innerList.add(0);
                innerList.add(0);
                innerList.add(0);
                ans.add(innerList);
            }
            // ②. 一个 0、0 左侧取一个负数、0 右侧取一个正数；
            else {
                // 声明左右指针
                int leftCur = zeroIndexArr.get(0) - 1;
                int rightCur = zeroIndexArr.get(zeroIndexArr.size() - 1) + 1;
                // 没有正数或者没有负数处理
                if (leftCur < 0 || rightCur > nums.length) {
                    return ans;
                }
                // 左指针移动
                for (int i = leftCur; i >= 0 ;) {
                    // 右指针移动
                    for (int j = rightCur; j < nums.length; j++) {
                        // 命中，则内层循环直接结束，外层索引变化
                        if (nums[i] + nums[j] == 0) {
                            List<Integer> innerList = new ArrayList<>();
                            innerList.add(0);
                            innerList.add(nums[i]);
                            innerList.add(nums[j]);
                            ans.add(innerList);
                            break;
                        }
                    }
                    // 跳过重复的 left 元素
                    while (nums[leftCur] == nums[i - 1]) {
                        i--;
                    }
                }
            }
        }
        // b. 如果不存在 0 元素，分为两种情况
        else {
            // 声明左右指针
            int leftCur = zeroIndexArr.get(0) - 1;
            int rightCur = zeroIndexArr.get(zeroIndexArr.size() - 1) + 1;
            // 没有正数或者没有负数处理
            if (leftCur < 0 || rightCur > nums.length) {
                return ans;
            }
            // ①. 左侧取两个负数、右侧取一个正数；
            // 左侧数据
            for (int i = leftCur; i >= 0 ;) {

            }

            // ②. 左侧取一个负数、右侧取两个正数；

        }

        return ans;
    }

    /**
     * <p> 递归求解（想想如何写 😃） </p>
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        return solve(ans, nums, 0);
    }

    /**
     * <p> 递归求解核心方法 </p>
     * @param ans
     * @param nums
     * @param currentVal
     * @return
     */
    public List<List<Integer>> solve(List<List<Integer>> ans, int[] nums, int currentVal) {
        return ans;
    }

    public static void main(String[] args) {
        // [[-1,-1,2],[-1,0,1]]
        int[] nums1 = new int[] {-1,0,1,2,-1,-4};
        // []
        int[] nums2 = new int[] {0,1,1};
        // [[0,0,0]]
        int[] nums3 = new int[] {0,0,0};

        List<List<Integer>> ans1 = threeSumSortWithTwoCurs(nums1);
        // List<List<Integer>> ans2 =threeSumCrude(nums2);

        PrintUtils.printComplicatedList(ans1);
        // PrintUtils.printComplicatedList(ans2);
    }
}
