package com.zmr.ResponseTest.Controller.async;

import com.zmr.ResponseTest.Service.async.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/asyncNewTest")
public class AsyncNewController {
    @Autowired
    private AsyncTaskService asyncTaskService;

    // 启动异步任务，立即返回一个未完成的 CompletableFuture
    @GetMapping("/async/{taskId}")
    public String asyncRequest(@PathVariable String taskId) {
        return asyncTaskService.startAsyncTask(taskId);
    }

    // 查询任务的执行结果
    @GetMapping("/result/{taskId}")
    public CompletableFuture<String> getTaskResult(@PathVariable String taskId) {
        return asyncTaskService.getTaskResult(taskId);
    }
}

