package com.zmr.LearningFiles.BasicJava.JsonTests.Utils;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/8/8 22:33
 * @description 定义一个 Result 泛型类
 */
public class Result<T> {
    private T result;
    private String message;

    public Result(T result, String message) {
        this.result = result;
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
