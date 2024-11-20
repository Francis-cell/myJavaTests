package com.zmr.MyUtils.TestToolsUtils.WatchUtils;

/**
 * <p> 监测一段代码的执行时间长短 </p>
 */
public class WatchUtils {
    /**
     * 计算并打印执行Runnable的时间（毫秒）。
     *
     * @param runnable 要执行的代码块
     */
    public static void timeExecution(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("执行时间: " + duration + " ms");
    }

    /**
     * 计算并打印执行Runnable的时间（纳秒）。
     *
     * @param runnable 要执行的代码块
     */
    public static void timeExecutionNano(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("执行时间: " + duration + " ns");
    }

    // public static void main(String[] args) {
    //     // 示例使用
    //     timeExecutionNano(() -> {
    //         // 这里放置要测试的代码
    //         for (int i = 0; i < 1000000; i++) {
    //             // 模拟一些工作
    //         }
    //     });
    // }
}
