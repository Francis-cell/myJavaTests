package com.zmr.LearningFiles.OneWeekPlaning.Greedy.allBackPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p> 完全背包问题 </p>
 * <p> 题目描述：假设您是一名收集古董的收藏家。您发现了一处古董市场🧐，里面有n种不同类型的古董。每种古董都有其价值💵和重量🧺。您有一个背包，
 * 可以承载的最大重量是W。您的目标是在不超过背包最大重量的前提下，选择一些古董放入背包，使得这些古董的总价值最大。
 * 与之前的例子不同的是，每种古董可能有多个相同的副本。这意味着您可以选择多个相同类型的古董，只要总重量不超过背包的最大重量。 </p>
 * <p> 示例：</p>
 * <p>假设有3种古董，它们的重量和价值如下，以及每种古董的副本数量：</p>
 *
 * <p>古董  重量	价值	 副本数量</p>
 * <p> 1	2	 10	   3</p>
 * <p> 2	3	 9	   2</p>
 * <p> 3	4	 8	   1</p>
 * <p>背包的最大承载重量W为10。</p>
 */
public class AntiqueCollection {
    /** 古董类 */
    static class Item {
        /** 编号 */
        int serialNo;

        /** 重量 */
        int weight;
        /** 价值 */
        int value;
        /** 剩余数量 */
        int remainingCount;
        /** 性价比 */
        double ratio;

        public Item(int serialNo, int weight, int value, int remainingCount) {
            this.serialNo = serialNo;
            this.weight = weight;
            this.value = value;
            this.remainingCount = remainingCount;
            this.ratio = weight != 0 ? (double)(value / weight) : 0;
        }

        public double getRatio() {
            return ratio;
        }

        public int getRemainingCount() {
            return remainingCount;
        }

        public void setRemainingCount(int remainingCount) {
            this.remainingCount = remainingCount;
        }
    }

    /**
     * 贪心方法求解
     * @param items 剩余古董情况列表
     * @param M 当前背包剩余可承重
     * @return
     */
    public static Object[] greedyKnapsack(Item[] items, int M) {
        Object[] ans = new Object[2];
        // 放置古董的编号信息
        ArrayList<Integer> ans1 = new ArrayList<>();
        // 先按照古董的性价比进行排序
        Arrays.sort(items, Comparator.comparingDouble(Item::getRatio).reversed());

        // 当前背包已承受的重量
        int currentWeight = 0;
        // 当前已经放入背包中的古董的价值和
        int currentValue = 0;

        // // TODO 优化前代码
        // for (int i = 0; i < items.length; ) {
        //     // 当前背包已经装不下当前的古董了
        //     if (currentWeight + items[i].weight > M) {
        //         // 尝试下一种古董是否能继续放入背包
        //         i++;
        //         continue;
        //     }
        //     // 装入当前的古董，对应的古董数量 - 1
        //     currentWeight += items[i].weight;
        //     currentValue += items[i].value;
        //     items[i].setRemainingCount(items[i].remainingCount - 1);
        //     ans1.add(items[i].serialNo);
        //
        //     // 如果当前的古董数量已经为 0，则尝试下一个古董
        //     if (items[i].remainingCount == 0) {
        //         i++;
        //     }
        // }

        // TODO 优化后代码
        for (int i = 0; i < items.length; i++) {
            // 计算能放入多少个当前的古董
            // (M - currentWeight) / items[i].weight --> 可以查看如果全部放入当前的古董能放入多少个?
            int maxQuantity = Math.min(items[i].remainingCount, (M - currentWeight) / items[i].weight);

            // 如果可以放入多个当前的多个古董
            if (maxQuantity > 0) {
                int weightAdd = maxQuantity * items[i].weight;
                currentWeight += weightAdd;
                currentValue += maxQuantity * items[i].value;
                for (int j = 0; j < maxQuantity; j++) {
                    ans1.add(items[i].serialNo);
                }
            }
            // 背包已经装满了，后面的古董无需再查看了
            if (currentWeight >= M) {
                break;
            }
        }

        // 背包中装入古董的总价值
        ans[0] = currentValue;
        // 背包中装入的古董的编号信息
        ans[1] = ans1;
        return ans;
    }

    /**
     * <p> 打印列表中的元素 </p>
     * @param lists
     * @param <E>
     */
    private static <E> void printList(List<E> lists) {
        for (E e : lists) {
            System.out.printf(e + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(1, 2, 10, 10),
                new Item(2, 3, 12, 23),
                new Item(3, 1, 2, 32),
                new Item(4, 5, 8, 13),
                new Item(5, 2, 10, 231),
                new Item(6, 7, 100, 2),
        };
        int M = 100;
        Object[] ans = greedyKnapsack(items, M);
        System.out.println("近似解的值为：" + ans[0]);
        System.out.println("放入的古董列表为：");
        printList((ArrayList<Integer>) ans[1]);
    }
}
