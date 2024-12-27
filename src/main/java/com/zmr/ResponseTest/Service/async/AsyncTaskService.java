package com.zmr.ResponseTest.Service.async;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

@Service
public class AsyncTaskService {

    // 用于存储异步任务
    private final ConcurrentHashMap<String, CompletableFuture<String>> taskMap = new ConcurrentHashMap<>();

    // 启动异步任务并返回 CompletableFuture
    public String startAsyncTask(String taskId) {
        CompletableFuture<String> future = new CompletableFuture<>();

        // 模拟异步任务执行
        new Thread(() -> {
            try {
                // 模拟耗时任务
                Thread.sleep(10000);
                // 完成任务并设置结果
                future.complete("Task " + taskId + " completed!");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        }).start();

        // 存储任务
        taskMap.put(taskId, future);

        return "创建任务" + taskId + "成功！";
    }

    // 根据任务 ID 查询结果
    public CompletableFuture<String> getTaskResult(String taskId) {
        return taskMap.get(taskId);
    }
}

