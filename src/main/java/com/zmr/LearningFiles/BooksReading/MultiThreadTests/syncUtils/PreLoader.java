package com.zmr.LearningFiles.BooksReading.MultiThreadTests.syncUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.zmr.LearningFiles.BooksReading.MultiThreadTests.syncUtils.entity.ProductInfo;
import com.zmr.LearningFiles.OwnLearning.BasicJava.MyExceptionUtils.MyExceptions;

public class PreLoader {
    private final FutureTask<ProductInfo> future =
            new FutureTask<ProductInfo>(new Callable<ProductInfo>() {

                @Override
                public ProductInfo call() throws Exception {
                    return null;
                }
            });

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws MyExceptions, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof InterruptedException) {
                throw (InterruptedException) cause;
            } else {
                // ... 其他处理方式
                throw (MyExceptions) cause;
            }
        }
    }
}
