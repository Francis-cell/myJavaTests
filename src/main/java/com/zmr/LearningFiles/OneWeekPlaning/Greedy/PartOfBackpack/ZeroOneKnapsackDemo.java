package com.zmr.LearningFiles.OneWeekPlaning.Greedy.PartOfBackpack;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Comparator;

public class ZeroOneKnapsackDemo {
    /**
     * 物品类
     */
    @Getter
    @Setter
    static class Item {
        /** 价值 */
        int value;
        /** 重量 */
        int weight;
        /** 性价比 = 价值 / 重量 */
        double ratio;

        public Item (int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    /**
     * 使用贪心算法解决背包问题(可拆分的背包问题解法)
     * @param items
     * @param capacity
     * @return
     */
    public static double greedyKnapsack(Item[] items, int capacity) {
        // 按照物品的性价比进行降序排序
        Arrays.sort(items, Comparator.comparingDouble(Item::getRatio).reversed());

        // 背包的总价值
        double totalValue = 0;
        // 背包当前重量
        int currentWeight = 0;

        // 遍历物品，尽可能选择性价较高的物品
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // 如果可以完全装入背包
                totalValue += item.value;
                currentWeight += item.weight;
            } else {
                // 如果不能完全装入，尝试装入一部分
                int remainingCapacity = capacity - currentWeight;
                totalValue += item.ratio * remainingCapacity;
                // 背包已满，结束循环
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int capacity = 50;

        double maxValue = greedyKnapsack(items, capacity);
        System.out.println("最大价值（近似解）为：" + maxValue);
    }
}
