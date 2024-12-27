package com.zmr.ResponseTest.Controller.async;

import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/asyncTest")
public class AsyncController {

    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    // 同步请求部分
    @GetMapping("/sync")
    public String syncRequest() {
        return "This is a synchronous response!";
    }

    // 异步请求部分
    @GetMapping("/async")
    public CompletableFuture<String> asyncRequest() {
        // 创建一个 CompletableFuture 作为契约
        CompletableFuture<String> future = new CompletableFuture<>();

        // 异步执行任务，模拟耗时任务
        executor.submit(() -> {
            try {
                // 模拟一个耗时任务（3秒）
                Thread.sleep(3000);
                // 任务完成后，通过契约返回结果
                future.complete("This is an asynchronous response after 3 seconds!");
            } catch (InterruptedException e) {
                e.printStackTrace();
                future.completeExceptionally(e);
            }
        });

        // 立即返回未完成的 CompletableFuture
        return future;
    }

    // 异步处理后等待返回结果
    @GetMapping("/delayed-result")
    public CompletableFuture<String> delayedResult() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // 模拟复杂耗时任务
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Delayed result received after 5 seconds!";
        }, executor);
    }
}

