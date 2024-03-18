package com.zmr.LearningFiles.OneWeekPlaning.Greedy.PartOfBackpack;

import java.util.*;

/**
 * 宝石矿问题
 * <p>假设您是一名收集稀有宝石的探险家。您发现了一处宝石矿💎，里面有n种不同类型的宝石。每种宝石都有其价值和重量。您有一个背包🎒，
 * 可以承载的最大重量是W。您的目标是在不超过背包最大重量的前提下，选择一些宝石放入背包，使得这些宝石的总价值💵最大。</p>
 */
public class GemStone {
    /** 单颗宝石 */
    static class Item {
        /** 重量 */
        int weight;
        /** 价值 */
        int value;
        /** 性价比 */
        double ratio;
        /** 编号 */
        int serialNo;

        public Item(int serialNo, int weight, int value) {
            this.serialNo = serialNo;
            this.weight = weight;
            this.value = value;
            this.ratio = weight != 0 ? (double)(value / weight) : 0;
        }

        public double getRatio() {
            return ratio;
        }
    }

    /**
     * 贪心算法求解-非最优解（宝石价值）
     * @param items
     * @param weight
     * @return
     */
    public static Object[] greedyKnapsack(Item[] items, int weight) {
        Object[] ans = new Object[2];
        // 放置宝石的编号信息
        ArrayList<Integer> ans1 = new ArrayList<>();

        // 先按照性价比进行排序(逆序排序)
        Arrays.sort(items, Comparator.comparingDouble(Item::getRatio).reversed());

        // 当前背包中宝石的总价值
        int currentValue = 0;
        // 当前背包中已经放入的宝石的总重量
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= weight) {
                currentWeight += item.weight;
                currentValue += item.value;
                // 存入宝石的编号信息
                ans1.add(item.serialNo);
            } else {
                break;
            }
        }

        ans[0] = currentValue;
        ans[1] = ans1;
        return ans;
    }

    /**
     * 列表信息打印
     * @param lists
     * @param <E>
     */
    public static <E> void printList(List<E> lists) {
        for (E e : lists){
            System.out.println(e + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(1, 2, 10),
                new Item(2, 3, 9),
                new Item(3, 4, 8),
                new Item(4, 5, 120),
                new Item(5, 9, 6)
        };
        int weight = 10;
        // System.out.println("最终获得到的近似解为：" + greedyKnapsack(items, weight));
        Object[] ans = greedyKnapsack(items, weight);
        System.out.println("近似解：" + (Integer) ans[0]);
        System.out.println("宝石编号列表:" );
        printList((ArrayList<Integer>)ans[1]);
    }
}
