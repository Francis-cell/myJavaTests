package com.zmr.MyUtils.DateUtils.impl;

import com.alibaba.excel.util.StringUtils;
import com.zmr.ImportantComponents.Exception.BusinessException;
import com.zmr.MyUtils.DateUtils.DateUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateUtilsImpl implements DateUtils {
    private static final DateUtilsImpl INSTANCE  = new DateUtilsImpl();

    private DateUtilsImpl() {}

    public static DateUtilsImpl getInstance() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     * @param timeStamp 要转换的时间戳
     * @return
     */
    @Override
    public Calendar changeTimeStampToCalender(Long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timeStamp));
        return calendar;
    }

    /**
     * {@inheritDoc}
     * @param timeStamp 要转换的时间戳
     * @param splitStr 转换后的时间分隔字符串
     * @return
     */
    @Override
    public String changeTimeStampToDateStr(Long timeStamp, String splitStr) {
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
     * {@inheritDoc}
     * @param date 日期
     * @param separator 分隔符
     * @return
     * @param <T>
     */
    @Override
    public <T> String changeDateFormat(T date, String separator) {
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
     * {@inheritDoc}
     * @param dateStr 时间字符串
     * @param formatStr 格式字符串
     * @return true - 时间字符串遵从对应的格式； false - 时间字符串不遵循对应的格式；
     */
    @Override
    public boolean checkDateStrWithFormat(String dateStr, String formatStr) {
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
     * {@inheritDoc}
     * @Param formatterPattern 时间格式
     * @return
     */
    @Override
    public String getFormatCurrentDateStr(String formatterPattern) {
        // 获取当前日期对象
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterPattern);
        // 格式化
        String currentDateStr = currentDate.format(formatter);
        return currentDateStr;
    }

    /**
     * {@inheritDoc}
     * @param dateVal
     * @param formatStr
     * @return
     */
    @Override
    public <T> Date changeDateValToDateFormat(T dateVal, String formatStr) {
        Date ans = null;
        if (StringUtils.isEmpty(formatStr)) {
            throw new BusinessException("要转换的日期格式不能为空！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            // 尝试解析日期
            if (dateVal instanceof String) {
                ans = sdf.parse((String) dateVal);
            }
            if (dateVal instanceof Date) {
                String tmpDateStr = sdf.format((Date) dateVal);
                ans = sdf.parse(tmpDateStr);
            }
        } catch (ParseException e) {
            ans = null;
        }
        return ans;
    }
}
