package main.java.com.zmr.MyLeetCodeTests.My2022Lists.D11_4;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/5 14:13
 */
public class Solution {
    /**
     * 思路：假设油量可以为负值，亏空最大
     * */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int val = canCompleteCircuit(gas, cost);
        System.out.println("最终的结果为：" + val);
    }
}
