package com.zmr.MiddleWare.LogAbout.Log4J.codeDemo;

import com.zmr.ImportantComponents.Exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jDemo01 {
    // 初始化日志对象
    private static final Logger logger = LogManager.getLogger(Log4jDemo01.class);

    public static void main(String[] args) {

        int a = 10;
        int b = 0;
        try {
            int c = a / b;
        } catch (Exception e) {
            logger.info("异常记录: ");
            logger.info(e);
            throw new BusinessException("xxx / zero");
        }

        // 记录不同级别的日志
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

        // 使用占位符输出变量
        String variable = "variable";
        logger.info("This is an info message with variable: {}", variable);
    }
}
