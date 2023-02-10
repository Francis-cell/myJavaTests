package main.java.com.zmr.LearningFiles.BasicJava.dealWithExceptionTests.interfaces;

import main.java.com.zmr.LearningFiles.BasicJava.dealWithExceptionTests.BaseException;

/**
 * @ClassName MyAsserts
 * @Description 自定义Asserts接口
 * @Author zhumengren
 * @Date 2022/3/28 14:20
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public interface MyAsserts {
    /***
     * 创建异常
     * @param args
     * @return BaseException
     */
    BaseException newException(Object... args);


    /***
     * 创建异常
     * @param t
     * @param args
     * @return BaseException
     */
    BaseException newException(Throwable t, Object... args);


    /***
     * 断言对象obj非空。如果对象obj为空，则抛出异常
     * @param obj 待判断对象
     * @return void
     */
    default void assertNotNull(Object obj) {
        if (obj == null) {
            throw newException(obj);
        }
    }


    /***
     * 断言对象obj非空。如果对象obj为空，则抛出异常
     * 异常信息message支持传递参数方式，避免在判断之前进行字符串的拼接操作
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     * @return void
     */
    default void assertNotNull(Object obj, Object... args) {
        if (obj == null) {
            throw newException(args);
        }
    }
}
