package com.zmr.LearningFiles.OwnLearning.BasicJava.dealWithExceptionTests;

import com.zmr.LearningFiles.OwnLearning.BasicJava.dealWithExceptionTests.interfaces.IResponseEnum;

/**
 * @ClassName BusinessException
 * @Description 自定义异常(封装常见异常处理)【业务异常】
 * @Author zhumengren
 * @Date 2022/3/28 15:25

 * @Version 1.0
 **/
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }
}
