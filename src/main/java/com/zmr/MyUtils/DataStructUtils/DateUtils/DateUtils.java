package com.zmr.MyUtils.DataStructUtils.DateUtils;

import com.alibaba.excel.util.StringUtils;
import com.zmr.ImportantComponents.Exception.BusinessException;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateUtils {
    private static final DateUtils INSTANCE  = new DateUtils();

    private DateUtils() {}

    public static DateUtils getInstance() {
        return INSTANCE;
    }

    /**
     * <p> 将时间戳转换成日历 Calendar 格式 </p>
     * @param timeStamp 要转换的时间戳
     * @return 转换成 Calendar 格式的时间戳时间
     */
    public static Calendar changeTimeStampToCalender(Long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timeStamp));
        return calendar;
    }

    /**
     * <p> 将时间戳转换成日期字符串格式，连接符可以自己指定 </p>
     * @param timeStamp 要转换的时间戳
     * @param splitStr 转换后的时间分隔字符串
     * @return 以指定的分隔符连接的时间
     */
    public static String changeTimeStampToDateStr(Long timeStamp, String splitStr) {
        String ans = "";
        StringBuilder sb = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timeStamp));
        // 获取年
        int year = calendar.get(Calendar.YEAR);
        // 获取月
        int month = calendar.get(Calendar.MONTH) + 1;
        // 获取日
        int date = calendar.get(Calendar.DATE);
        sb.append(year+"");
        sb.append(splitStr);
        sb.append(month+"");
        sb.append(splitStr);
        sb.append(date+"");
        ans = sb.toString();
        return ans;
    }

    /**
     * <p> 将  YY:MM:DD HH:mm:ss 格式的时间转成 YY-MM-DD 格式 </p>
     * @param date 日期
     * @param separator 分隔符
     */
    public static <T> String changeDateFormat(T date, String separator) {
        String ans = null;
        StringBuilder sb = new StringBuilder();
        sb.append("yyyy")
                .append(separator)
                .append("MM")
                .append(separator)
                .append("dd");
        String pattern = sb.toString();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if (date instanceof java.sql.Date){
            ans = sdf.format(new Date(((java.sql.Date)date).getTime()));
        }else if(date instanceof Timestamp){
            ans = sdf.format(new Date(((Timestamp)date).getTime()));
        }
        return ans;
    }


    /**
     * <p> 检查一个时间字符串是否遵循某种时间格式 </p>
     * @param dateStr 时间字符串
     * @param formatStr 格式字符串
     * @return true - 时间字符串遵从对应的格式； false - 时间字符串不遵循对应的格式；
     */
    public static boolean checkDateStrWithFormat(String dateStr, String formatStr) {
        boolean ans = false;
        if (dateStr == null) {
            return ans;
        }
        if (formatStr == null) {
            return ans;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        // 设置为严格模式，不允许日期和时间值存在逻辑上的矛盾
        sdf.setLenient(false);
        try {
            // 尝试解析日期
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return ans;
        }
    }

    /**
     * <p> 获取当前时间的指定格式字符串 </p>
     * @param formatterPattern
     * @return
     */
    public static String getFormatCurrentDateStr(String formatterPattern) {
        // 获取当前日期对象
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterPattern);
        // 格式化
        String currentDateStr = currentDate.format(formatter);
        return currentDateStr;
    }

    /**
     * <p> 将一个日期格式的字符串转换成日期格式 </p>
     * @param dateVal 日期（支持日期格式的字符串以及本身就是日期的数据）
     * @param formatStr 日期格式
     * @return
     */
    public static <T> Date changeDateValToDateFormat(T dateVal, String formatStr) {
        Date ans = null;
        if (StringUtils.isEmpty(formatStr)) {
            throw new BusinessException("要转换的日期格式不能为空！");
        }

        // 常见的日期格式
        String[] possibleFormats = {
                "yyyy-MM-dd HH:mm:ss",
                "yyyy/MM/dd HH:mm:ss",
                "yyyy-MM-dd",
                "yyyy/MM/dd"
        };

        try {
            // 如果传入的是字符串，尝试多个格式解析
            if (dateVal instanceof String) {
                ans = tryParseDate((String) dateVal, possibleFormats);
            }
            // 如果传入的是Date，直接格式化
            else if (dateVal instanceof Date) {
                ans = (Date) dateVal;
            }

            // 如果成功解析日期，则按给定的格式转换
            if (ans != null) {
                SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
                String formattedDate = sdf.format(ans);
                ans = sdf.parse(formattedDate);
            }

        } catch (ParseException e) {
            e.printStackTrace();
            ans = null;
        }
        return ans;
    }

    /**
     * <p> 辅助方法，尝试使用多个格式解析字符串 </p>
     * @param dateStr
     * @param formats
     * @return
     */
    private static Date tryParseDate(String dateStr, String[] formats) {
        for (String format : formats) {
            try {
                return new SimpleDateFormat(format).parse(dateStr);
            } catch (ParseException ignored) {
            }
        }
        throw new BusinessException("时间格式转换失败，请检查！当前要进行转换的日期为：" + dateStr);
    }

}
