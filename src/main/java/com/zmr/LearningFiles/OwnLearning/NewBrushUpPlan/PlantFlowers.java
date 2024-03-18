package com.zmr.LearningFiles.OwnLearning.NewBrushUpPlan;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/5/31 7:59
 * @description https://leetcode.cn/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
 */
public class PlantFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 先算出花坛中能放置最多的花的数量
        return n <= getMaxFlowersInBed01(flowerbed);
    }

    /**
     * 在flowerbed中找到它所能放置的最大的花的数量(暴力求解方式) -- (二分求解)
     * @param flowerbed
     * @return
     */
    public static int getMaxFlowersInBed01(int[] flowerbed) {
        if (flowerbed.length <= 2) {
            for (int flower : flowerbed) {
                if (flower == 1) {
                    return 0;
                }
            }
            return 1;    
        }
        
        int lastCount = 0;

        // 判断当前位置的左右是否都是0
        for (int i = 0; i < flowerbed.length; ) {
            // 如果是第0个位置，则只需判断1位置是否为0
            if (i == 0 ) {
                if (flowerbed[i] == 0 && flowerbed[1] == 0) {
                    lastCount++;
                    i += 2;
                    continue;
                }
            }
            // 如果是最后一个位置，则只需判断 n - 1 位置是否为0
            else if (i == flowerbed.length - 1) {
                if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
                    lastCount++;
                }
            }
            // 其余位置需要判断是否存在3个连续的0
            else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                lastCount++;
                i += 2;
                continue;
            }

            i++;
        }
        
        return lastCount;
    }


    /**
     * 在flowerbed中找到它所能放置的最大的花的数量(递归求解方式)
     * @param flowerbed
     * @return
     */
    public static int process(int[] flowerbed) {
        // TODO--后续求出最优解
        return 0;
    }
    
    
    public static void main(String[] args) {
        int[] flowerbed = new int[] {0, 1};
        int n = 1;

        System.out.println(canPlaceFlowers(flowerbed, n));
        //System.out.println(getMaxFlowersInBed01(flowerbed));
    }
}
