package com.zmr.MyUtils.DateUtils;

import java.util.Calendar;

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
}
