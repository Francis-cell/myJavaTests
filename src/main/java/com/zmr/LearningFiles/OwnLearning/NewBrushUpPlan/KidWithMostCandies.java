package com.zmr.LearningFiles.OwnLearning.NewBrushUpPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/5/30 23:01
 * @description https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
 */
public class KidWithMostCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> lastList = new ArrayList<>();

        if (candies.length == 0) {
            return lastList;
        }
        
        // 首先找到candies中最大的那个值
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                lastList.add(true);
            } else {
                lastList.add(false);
            }
        }
        
        return lastList;
    }

    public static void main(String[] args) {
        int[] candies = new int[] {2,3,5,1,3};
        int extraCandies = 3;

        List<Boolean> tmpList = kidsWithCandies(candies, extraCandies);

        for (int i = 0; i < tmpList.size(); i++) {
            System.out.println(tmpList.get(i));
        }
    }
}
