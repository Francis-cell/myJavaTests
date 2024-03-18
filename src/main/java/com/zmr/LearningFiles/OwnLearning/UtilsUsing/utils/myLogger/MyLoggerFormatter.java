package com.zmr.LearningFiles.OwnLearning.UtilsUsing.utils.myLogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * @ClassName MyLoggerUtils
 * @Description 自定义日志输入格式
 * @Author zhumengren
 * @Date 2022/4/16 20:52
 * @Email zhumengren@snoot.com
 * @Version 1.0
 **/
public class MyLoggerFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        // 1、创建一个StringBuilder对象用来存放后续需要打印的日志内容
        StringBuilder builder = new StringBuilder();

        // 2、获取当前的时间
        // 设置时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        String dateStr = date.format(formatter);

        builder.append(dateStr);
        builder.append(" - ");

        // 拼接日志级别
        builder.append(record.getLevel()).append(" - ");

        // 拼接方法名
        builder.append(record.getSourceMethodName()).append(" - ");

        // 拼接日志内容
        builder.append(record.getMessage());

        // 日志换行
        builder.append("\r\n");

        return builder.toString();
    }

    @Override
    public String getHead(Handler head) {
        // 此处定义日志的头部信息
        return "\r\n==================MyLogger Start==================\r\n";
    }

    @Override
    public String getTail(Handler tail) {
        // 此处定义日志的尾部信息
        return "==================MyLogger End==================\r\n";
    }

}
