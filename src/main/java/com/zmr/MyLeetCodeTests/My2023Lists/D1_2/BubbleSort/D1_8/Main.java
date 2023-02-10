package main.java.com.zmr.MyLeetCodeTests.My2023Lists.D1_2.BubbleSort.D1_8;

public class Main {
    // 考点：动态规划
    public static void main(String[] args) {
        // 1、首先获取输入的台阶阶数，此处先固定为3
        int height = 3;
        //int steps = steps(height, 2,0) + steps(height, 1, 0);
        //System.out.println(steps);
        //System.out.println(steps(height, 1, 0));
        System.out.println(steps(4, 1, 0));
    }

    /**
     * @Description 计算当前台阶数，一共有多少种方案可以走完
     * @param height 当前要走的台阶总高度
     * @param step 下一步要走的台阶数
     * @param allMethods 总解决方案
     * @return int
     */
    static int steps(int height, int step, int allMethods) {
        if (height <= 0) {
            return 0;
        } else if (height == 1) {
            if (step == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            // 初始化剩余步数
            int hasStep;
            if (height > 2) {
                allMethods += 1;
                // 可选2阶和1阶，一共增加两种方案
                if (step == 2) {
                    hasStep = steps(height-2, 1, allMethods) +
                            steps(height-2, 2, allMethods);
                } else {
                    hasStep = steps(height-1, 2, allMethods) +
                            steps(height-1, 1, allMethods);
                }
            } else {
                if (step == 2 || height == 2) {
                    return 1;
                } else {
                    return 2;
                }
            }
            return hasStep * allMethods;
        }
    }
}
