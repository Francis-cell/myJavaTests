package com.zmr.MyUtils.DateUtils.impl;

import com.zmr.MyUtils.DateUtils.DateUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
}
