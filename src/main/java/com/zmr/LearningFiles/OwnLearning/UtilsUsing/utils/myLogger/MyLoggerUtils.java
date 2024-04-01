package com.zmr.LearningFiles.OwnLearning.UtilsUsing.utils.myLogger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 * @ClassName MyLoggerUtils
 * @Description myLogger工具类
 * @Author zhumengren
 * @Date 2022/4/16 21:08

 * @Version 1.0
 **/
public class MyLoggerUtils {
    // 获取当前系统的路径分割符
    public static final String FILE_SEPARATOR = File.separator;

    // 默认配置了一个无需保存到本地的日志对象
    public static Logger logger = MyLoggerUtils.myLogger();

    /**
     * 不指定日志保存到本地的日志对象(仅仅显示在控制台上)
     * @return Logger
     */
    public static Logger myLogger() {
        return myLogger(false, "", false);
    }

    /**
     * 以追加写入日志的方式新建一个Logger对象
     * @param path 日志存储路径(需要携带文件的名称)
     * @return Logger
     */
    public static Logger myLogger(String path){
        // 处理 path 的分割符
        path = dealWithPath(path);
        // 默认采用追加的方式添加日志信息
        return myLogger(true, path, true);
    }

    /**
     * 返回Java日志对象(初始定义)
     * @param saveOrNot 是否保存到本地
     * @param path 日志存储路径(需要携带文件的名称)
     * @param appendOrNot 是否进行日志的追加
     * @return Logger
     */
    public static Logger myLogger(boolean saveOrNot, String path, boolean appendOrNot){
        // 创建一个Logger对象：注意该对象的名称必须和下面的 getLogger()方法 中的名称保持一致
        Logger myLogger = Logger.getLogger("myLogger");

        try {
            if (saveOrNot) {
                // 1、需要保存到本地文件
                // 以追加的方式写入日志
                //FileHandler fileHandler = new FileHandler("d:" + File.separator + "java" + File.separator + "logger.log", appendOrNot);
                FileHandler fileHandler = new FileHandler(path, appendOrNot);
                // 创建日志格式文件：采用自定义的Formatter
                fileHandler.setFormatter(new MyLoggerFormatter());
                // 将FileHandler对象添加到Logger对象中
                myLogger.addHandler(fileHandler);
            } else {
                // 2、不需要保存到本地文件
                FileHandler fileHandler = new FileHandler();
                // 创建日志格式文件：采用自定义的Formatter
                fileHandler.setFormatter(new MyLoggerFormatter());
                // 将FileHandler对象添加到Logger对象中
                myLogger.addHandler(fileHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        return myLogger;
    }

    /**
     * 将手动输入的Windows下的路径转换成当前系统的路径(这里输入的路径以“\\”为分割符)
     * @param path 文件的具体路径
     * @return String
     */
    private static String dealWithPath(String path) {
        String result = "";
        // 将path进行处理
        String[] pathTemps = path.split("\\\\");
        StringBuilder sbTemp = new StringBuilder();
        for (int i = 0; i < pathTemps.length; i++) {
            if (i == pathTemps.length - 1) { // 说明当前元素是pathTemp的最后一个元素
                sbTemp.append(pathTemps[i]);
                result = sbTemp.toString();
            }
            sbTemp.append(pathTemps[i]);
            sbTemp.append(FILE_SEPARATOR);
        }
        return result;
    }

}
