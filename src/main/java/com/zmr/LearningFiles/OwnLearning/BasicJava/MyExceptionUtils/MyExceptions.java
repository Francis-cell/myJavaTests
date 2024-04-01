package com.zmr.LearningFiles.OwnLearning.BasicJava.MyExceptionUtils;

/**
 * @ClassName MyExceptions
 * @Description 自定义异常Exception
 * @Author zhumengren
 * @Date 2022/9/8 20:50

 * @Version 1.0
 **/
public class MyExceptions extends Exception{
    public MyExceptions() {
        super();
    }

    public MyExceptions(String str) {
        super(str);
    }
}
