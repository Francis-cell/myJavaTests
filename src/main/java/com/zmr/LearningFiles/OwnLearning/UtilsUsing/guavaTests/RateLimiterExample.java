package com.zmr.LearningFiles.OwnLearning.UtilsUsing.guavaTests;

import com.google.common.util.concurrent.RateLimiter;

/**
 * <p> Guava 限流工具 RateLimiter 的使用 </p>
 * <p> 基于令牌桶算法的实现 </p>
 */
public class RateLimiterExample {
    public static void main(String[] args) {
        // 创建一个每秒只允许两个许可的 RateLimiter
        RateLimiter rateLimiter = RateLimiter.create(2);

        for (int i = 0; i < 10; i++) {
            // 获取许可，如果必要的话会阻塞直到获取到许可
            double waitTime = rateLimiter.acquire();
            System.out.println("任务 " + i + " 获取许可，等待时间 " + waitTime + " 秒");

            // 模拟任务执行
            performTask(i);
        }

        // 无穷大的数据和一个有限的数据进行数学运算，最终得到的值必然为 NAN
        // double v = Double.POSITIVE_INFINITY / 5;
        // System.out.println(v);
    }

    private static void performTask(int taskId) {
        // 这里执行任务逻辑
        System.out.println("执行任务 " + taskId);
    }
}
