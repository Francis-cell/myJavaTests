package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.PrintUtils.impl.PrintUtilsImpl;
import com.zmr.MyUtils.TestToolsUtils.DataCopyUtils.DataCopyUtils;
import com.zmr.MyUtils.TestToolsUtils.GenerateDataUtils.GenerateDataUtils;
import com.zmr.MyUtils.TestToolsUtils.WatchUtils.WatchUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p> 最长连续序列 </p>
 */
public class LongestConsecutive {
    /**
     * <p> Running: 暴力解 (37ms, 击败 41.66%) </p>
     * <p> Steps: </p>
     * <p> 1、剔除相同的数据； </p>
     * <p> 2、排序； </p>
     * <p> 3、查看连续性并计数，找到最大计数； </p>
     * @param nums
     * @return
     */
    public static int longestConsecutiveCrude(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 1、剔除相同的数据
        Set<Integer> intSet = new LinkedHashSet<>();
        for (int num : nums) {
            intSet.add(num);
        }
        // 将 Set 转换回数组
        int[] numsUnique = intSet.stream().mapToInt(Integer::intValue).toArray();

        // 2、排序
        Arrays.sort(numsUnique);

        // 3、查看连续性并计数，找到最大计数
        int maxLen = 0;
        int currentLen = 1;
        for (int i = 0; i < numsUnique.length - 1; i++) {
            if (numsUnique[i + 1] == numsUnique[i] + 1) {
                currentLen++;
                continue;
            }
            if (maxLen < currentLen) {
                maxLen = currentLen;
            }
            currentLen = 1;
        }

        if (maxLen < currentLen) {
            maxLen = currentLen;
        }

        return maxLen;
    }


    /**
     * <p> 时间复杂度为 O(n) 的算法 </p>
     * <pre>
     *     1、nums 元素去重，同时维护成一个 Collections 下的数据结构；
     *     2、遍历元素，查看 当前元素 - 1 的元素在不在 hashMap 里面，
     *        a. 如果 - 1 的元素存在，则说明当前元素不是连续序列的开始，pass；
     *        b. 如果 - 1 的元素不存在，则说明当前元素是连续序列的开始；计算以当前元素为起始的序列长度，和最大长度进行比较；
     *     3、最终返回最大值
     * </pre>
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        // 伪代码：
        // 1、nums 元素去重，同时维护成一个 Collections 下的数据结构；
        // 2、遍历元素，查看 当前元素 - 1 的元素在不在 hashMap 里面，
        //    a. 如果 - 1 的元素存在，则说明当前元素不是连续序列的开始，pass；
        //    b. 如果 - 1 的元素不存在，则说明当前元素是连续序列的开始；计算以当前元素为起始的序列长度，和最大长度进行比较；
        // 3、最终返回最大值

        // 实现：
        // 1、nums 元素去重，同时维护成一个 Collections 下的数据结构；
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        // 设置最大长度值
        int longestStreak = 0;

        // 2、遍历元素，查看 当前元素 - 1 的元素在不在 hashMap 里面，
        //    a. 如果 - 1 的元素存在，则说明当前元素不是连续序列的开始，pass；
        //    b. 如果 - 1 的元素不存在，则说明当前元素是连续序列的开始；计算以当前元素为起始的序列长度，和最大长度进行比较；
        for (int num : num_set) {
            //  b. 如果 - 1 的元素不存在，则说明当前元素是连续序列的开始；
            if (!num_set.contains(num - 1)) {
                // 计算以当前元素为起始的序列长度，和最大长度进行比较；
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }

        return longestStreak;
    }


    public static void main(String[] args) {
        // 4
        // int[] nums1 = new int[] {100,4,200,1,3,2};
        // // 9
        // int[] nums2 = new int[] {0,3,7,2,5,8,4,6,0,1};
        // // 3
        // int[] nums3 = new int[] {1,2,0,1};
        // // 4
        // int[] nums4 = new int[] {9,1,-3,2,4,8,3,-1,6,-2,-4,7};

        // System.out.println(longestConsecutive(nums1));
        // System.out.println(longestConsecutiveCrude(nums2));
        // System.out.println(longestConsecutiveCrude(nums3));
        // System.out.println(longestConsecutiveCrude(nums4));

        WatchUtils.timeExecutionNano(() -> {
            int maxSize = 1000;
            int maxValue = 10000;
            int testTimes = 100000;
            System.out.println("开始测试！");
            for (int i = 0; i < testTimes; i++) {
                int[] arr = GenerateDataUtils.generateRandomIntArray(maxSize, maxValue);
                int[] arrCopy = DataCopyUtils.copyIntArray(arr);

                // System.out.println("测试到了第 " + i + "个");

                // 暴力解
                int ans1 = longestConsecutiveCrude(arr);
                // 优化解
                int ans2 = longestConsecutive(arrCopy);

                if (ans1 != ans2) {
                    System.out.println("测试失败！");
                    System.out.println("数组 arr: ");
                    PrintUtilsImpl.getInstance().printArr(arr);
                    System.out.println("ans1: " + ans1);
                    System.out.println("ans2: " + ans2);
                    return;
                }
            }
            System.out.println("测试完成！");
        });
    }
}
