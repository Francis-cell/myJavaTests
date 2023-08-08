package com.zmr.NewBrushUpPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode.cn/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
 **/
public class LongestOnes {
    /**
     * @Description 最大连续1的个数 III (暴力解法)
     * @param nums
     * @param k
     * @return int
     */
    public static int longestOnes(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        // 1、先将输入的数组转换成需要的数组的形式
        Integer[] changedArr = changeNumsToCount(nums);

        // 先将数组的长度小于等于1的情况排除掉
        if (changedArr.length == 1) {
            return changedArr[0] > 0 ? changedArr[0] : k;
        }

        // 2、根据输入的k的值选择合适的0的位置,然后形成最大的1的连续数量
        for (int i = 0; i < changedArr.length; i++) {
            max = Math.max(max, getIndexMaxNums(changedArr, i, k));
        }

        return max;
    }

    /**
     * @Description 获取在nums数组中，在i位置时正数的值
     * @param nums
     * @param i
     * @param k
     * @return int
     */
    private static int getIndexMaxNums(Integer[] nums, int i, int k) {
        // 如果i = 0
        if (i == 0) {
            return nums[0] > 0 ? nums[0] : nums[1] + k;
        }
        
        // 单独处理i = 1
        if (i == 1) {
            int tmpA = nums[2] + k >= 0 ? nums[1] + nums[2] * -1 + nums[3] : nums[1] + k;
            int tmpB = nums[0] + k < 0 ? nums[1] + k : nums[1] + nums[0] * -1;
            int tmpC = nums[1] + k >= 0 ? nums[0] + nums[1] * -1 + nums[2] : Math.max(nums[0], nums[2]) + k;
            return nums[1] > 0 ? Math.max(tmpA, tmpB) : tmpC;
        }
        
        // 如果i = nums.length - 1
        if (i == nums.length - 1) {
            return nums[nums.length - 1] >= 0 ? nums[nums.length - 1] : nums[nums.length - 2] + k;
        }
        
        // 处理nums.length - 2位置的元素
        if (i == nums.length - 2) {
            // 如果当前位置左侧的元素+k > 0，说明当前位置和左侧相邻的两个元素可以拼接到一块儿
            int tmpA = nums[nums.length - 3] + k >= 0 ? nums[nums.length - 2] + nums[nums.length - 3] * -1 + nums[nums.length - 3] : nums[nums.length - 2] + k;
            // 右侧最多拼接的元素
            int tmpB = nums[nums.length - 1] + k < 0 ? nums[nums.length - 2] + k : nums[nums.length - 2] + nums[nums.length - 1] * -1;
            // 如果当前位置的元素的值 < 0，则值最大为tmpC
            int tmpC = nums[nums.length - 2] + k >= 0 ? nums[nums.length - 3] + nums[nums.length - 2] * -1 + nums[nums.length - 1] : Math.max( nums[nums.length - 3],  nums[nums.length - 1]) + k;
            return nums[nums.length - 2] > 0 ?  Math.max(tmpA, tmpB) : tmpC;
        }
        
        // 普通位置时的值
        if (nums[i] > 0) {
            // 查看nums[i - 1]和nums[i + 1] 位置的元素的值
            int tmpA = nums[i - 1] + k >= 0 ? nums[i] + nums[i - 1] * -1 + nums[i - 2] : nums[i] + k;
            int tmpB = nums[i + 1] + k >= 0 ? nums[i] + nums[i + 1] * -1 + nums[i + 2] : nums[i] + k;
            return Math.max(tmpA, tmpB);
        } else {
            return nums[i] + k >= 0 ? nums[i - 1] + nums[i] * -1 + nums[i + 1]
                    : Math.max(nums[i - 1], nums[i + 1]) + k;
        }
    }


    /**
     * @Description 将传入的nums处理成需要的数组的形式
     * @param nums
     * @return java.lang.Integer[]
     */
    private static Integer[] changeNumsToCount(int[] nums) {
        ArrayList<Integer> tmpList = new ArrayList<>();

        // 1、先将原本的nums数组处理一下，处理成一个全新的数组，连续的1直接相加(采用正数的形式)、连续的0相加，采用负数的形式
        // 记录连续的1的数量，1使用正数进行数据的保存
        int tmpOneVal = 0;
        // 记录连续的0的数量，0使用负数进行数据的保存
        int tmpZeroVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                // 检查tmpZeroVal的值是否为0，如果不为0则添加进入到tmpList中
                if (tmpZeroVal != 0) {
                    tmpList.add(tmpZeroVal);
                    // 数据还原成0，给下一个阶段的数据使用
                    tmpZeroVal = 0;
                }
                tmpOneVal++;
            } else {  
                // 检查tmpOneVal的值是否为0，如果不为0则添加进入到tmpList中
                if (tmpOneVal != 0) {
                    tmpList.add(tmpOneVal);
                    // 数据还原成0，给下一个阶段的数据使用
                    tmpOneVal = 0;
                }
                tmpZeroVal--;
            }
        }

        // 最后检查一下tmpZeroVal和rmpOneVal的值，其中有一个必然不为0
        tmpList.add(tmpOneVal == 0 ? tmpZeroVal : tmpOneVal);

        // 将上面的列表转换成数组形式
        Integer[] tmpArr = tmpList.toArray(new Integer[tmpList.size()]);

        System.out.println("处理之后的arr的值为：" + Arrays.toString(tmpArr));

        return tmpArr;
    }



    /**
     * @Description 最大连续1的个数 III (滑动窗口解法)
     * @param nums
     * @param k
     * @return int
     */
    public static int longestOnes02(int[] nums, int k) {
        // 最终的结果
        int res = 0;
        // 先获取到数组的长度
        int n = nums.length;
        // 定义滑动窗口左指针和右指针
        int left = 0, right = 0;
        // 定义一个变量用于记录滑动窗口内0的个数】
        int zeros = 0;
        // 右侧指针主动移动，驱动左侧指针被动移动
        while (right < n) {
            // 如果right指针每经过一个0，将会给zeros的值进行增加
            if (nums[right] == 0) {
                zeros++;
            }
            // 如果zeros中的0的数量大于k的时候，将会被动带着left左指针移动
            while (zeros > k) {
                if (nums[left++] == 0) {
                    zeros--;
                }
            }
            // 当滑动窗口中找到了需要的结果的时候，将会更新res的值
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    /**
     * @Description 最大连续1的个数 III (前缀和 + 二分法)
     * @param nums
     * @param k
     * @return int
     */
    public static int longestOnes03(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        // 前缀和数组(之所以声明比原数组nums的长度大1，是因为这样第0位可以不使用)
        int[] sum = new int[n + 1];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            // 二分法(在指定的区间内查看当前的区间是否满足要求)
            int l = 0, r = i;
            // 这个过程找的是以当前i作为r的时候，在这个区间内能在找到的满足 0的数量<=k最大的范围
            while (l < r) {
                int mid = (l + r) >> 1;
                // 检查l和r范围上nums数组中0的数量和k的关系，如果小于k则返回true，反之返回false
                // mid - i 范围
                if (getZeroNum(sum, mid, i, k)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            // 最后再检查一下最终的结果是否满足要求
            if (getZeroNum(sum, l, r, k)) {
                ans = Math.max(ans, i - r + 1);
            }
        }
        return ans;
    }

    /**
     * 计算数组sums(前缀和数组)在 l - r 范围上0的数量是否在 0 - k 之间
     * @param sums 
     * @param l
     * @param r
     * @param k 需要判断的0的数量范围
     * @return
     */
    private static boolean getZeroNum(int[] sums, int l, int r, int k) {
        // 当前范围在nums数组中1的数量(闭区间)
        int tol = sums[r + 1] - sums[l];
        // 如果l - r 这个闭区间范围上全是1的时候的值
        int len = r - l + 1;
        // len - tol 计算的是在 l - r 这个闭区间范围上0的数量，然后判断这个范围上0的数量和k的大小
        return len - tol <= k;
    }




    /**
     * @Description 最大连续1的个数 III (暴力递归求解方法)
     * @param nums
     * @param k
     * @return int
     */
    public static int longestOnes04(int[] nums, int k) {
        return process(nums, k, 0, 0);
    }

    /**
     * 递归辅助方法 （最初的暴力递归的解法）
     * @param nums 需要处理的数组
     * @param k 剩余反转次数
     * @param index 当前处理的索引
     * @param count 当前连续的1的数量
     * @return
     */
    private static int process(int[] nums, int k, int index, int count) {
        // base case
        if (index == nums.length) {
            return count;
        }
        
        // 如果当前元素的值为1，则count++
        if (nums[index] == 1) {
            count++;
        }
        
        // 如果当前已经使用了所有的翻转次数k, 那么检查到目前为止count的最大值
        if (count + k == index + 1) {
            return Math.max(count, process(nums, k, index + 1, count));
        }
        
        // 如果还有剩余的翻转次数可以使用，则需要考虑下面的两种情况
        // 1、反转剩余可以从0翻转到1的位置的元素，同时count继续++
        // 2、跳过当前位0的元素，然后重置count的值置为0
        return Math.max(
                Math.max(count, process(nums, k, index + 1, count)),
                process(nums, k - 1, index + 1, count)
        );
    }



    /**
     * @Description 最大连续1的个数 III (懒缓存法)
     * @param nums
     * @param k
     * @return int
     */
    public static int longestOnes05(int[] nums, int k) {
        Map<String, Integer> cache = new HashMap<>();
        return process1(nums, k, 0, 0, cache);
    }
    

    /**
     * 递归辅助方法 （最初的暴力递归的解法）
     * @param nums 需要处理的数组
     * @param k 剩余反转次数
     * @param index 当前处理的索引
     * @param count 当前连续的1的数量
     * @param cache 用于缓存重复计算的值
     * @return
     */
    private static int process1(int[] nums, int k, int index, int count, Map<String, Integer> cache) {
        // 首先获取到key位置的缓存的值
        String key = index + "_" + count;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        
        // base case
        if (index == nums.length) {
            return count;
        }
        
        if (nums[index] == 1) {
            count++;
        }
        
        // 已经没有剩余的0可以翻转了
        if (count + k == index + 1) {
            int result = Math.max(count, process1(nums, k, index + 1, count, cache));
            cache.put(key, result);
            return result;
        }
        
        // 如果还有0可以翻转，则有两种情况：1、下一个位置的0翻转；2、下一个位置的0不翻转
        int result = Math.max(
                Math.max(count, process1(nums, k, index + 1, count, cache)),
                process1(nums, k - 1, index + 1, count, cache)
        );
        cache.put(key, result);
        return result;
    }



    ///**
    // * @Description 最大连续1的个数 III (动态规划方式)
    // * @param nums
    // * @param k
    // * @return int
    // */
    //public static int longestOnes06(int[] nums, int k) {
    //    int n = nums.length;
    //    // 懒缓存中，变量有：
    //    // index: 0 - n
    //    // count: 
    //    int[][] dp = new int[n][k + 1];
    //}
    
    
    
    

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
        
        
        //Integer[] tmpNums = new Integer[] {-2, 2, -2, 3, -1, 2, -3, 4};
        //System.out.println(getIndexMaxNums(tmpNums, 6, 3));
    }
}

