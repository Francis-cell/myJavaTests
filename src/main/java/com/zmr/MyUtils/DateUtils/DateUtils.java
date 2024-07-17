package com.zmr.MyUtils.DateUtils;

import java.util.Calendar;
import java.util.Date;

public interface DateUtils {
    /**
     * <p> 将时间戳转换成日历 Calendar 格式 </p>
     * @param timeStamp 要转换的时间戳
     * @return 转换成 Calendar 格式的时间戳时间
     */
    Calendar changeTimeStampToCalender(Long timeStamp);

    /**
     * <p> 将时间戳转换成日期字符串格式，连接符可以自己指定 </p>
     * @param timeStamp 要转换的时间戳
     * @param splitStr 转换后的时间分隔字符串
     * @return 以指定的分隔符连接的时间
     */
    String changeTimeStampToDateStr(Long timeStamp, String splitStr);

    /**
     * <p> 将  YY:MM:DD HH:mm:ss 格式的时间转成 YY-MM-DD 格式 </p>
     * @param date 日期
     * @param separator 分隔符
     */
    <T> String changeDateFormat(T date, String separator);

    /**
     * <p> 检查一个时间字符串是否遵循某种时间格式 </p>
     * @param dateStr 时间字符串
     * @param formatStr 格式字符串
     * @return true - 时间字符串遵从对应的格式； false - 时间字符串不遵循对应的格式；
     */
    boolean checkDateStrWithFormat(String dateStr, String formatStr);

    /**
     * <p> 获取当前时间的指定格式字符串 </p>
     * @param formatterPattern
     * @return
     */
    String getFormatCurrentDateStr(String formatterPattern);

    /**
     * <p> 将一个日期格式的字符串转换成日期格式 </p>
     * @param dateStr 日期（支持日期格式的字符串以及本身就是日期的数据）
     * @param formatStr 日期格式
     * @return
     */
    <T> Date changeDateValToDateFormat(T dateVal, String formatStr);
}
