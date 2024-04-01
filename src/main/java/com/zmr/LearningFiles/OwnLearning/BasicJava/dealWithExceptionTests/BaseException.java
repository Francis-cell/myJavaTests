package com.zmr.LearningFiles.OwnLearning.BasicJava.dealWithExceptionTests;

import com.zmr.LearningFiles.OwnLearning.BasicJava.dealWithExceptionTests.interfaces.IResponseEnum;

/**
 * @ClassName BaseException
 * @Description 自定义异常的【根异常】
 * @Author zhumengren
 * @Date 2022/3/28 14:47

 * @Version 1.0
 **/
public class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super();
    }
}
