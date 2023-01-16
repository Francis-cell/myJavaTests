package LearningFiles.BasicJava.dateGetTests;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateGetTest01
 * @Description 时间获取方法
 * @Author zhumengren
 * @Date 2022/4/13 17:41
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class DateGetMethods {

    /**
     * 获取当前时间(方式1)
     * @return String
     */
    public String dateGetWithTimeMillis() {
        // 设置时间的格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        // 将当前的时间戳转换成需要的时间格式
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    /**
     * 获取当前时间(方式2)
     * @return String
     */
    public String dateGetWithDate() {
        // 使用Java自带的Date()方法
        // 设置时间的格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date();
        return formatter.format(date);
    }

    /**
     * 获取当前时间(方式3)
     * @return String
     */
    public String dateGetWithCalendar() {
        // 设置时间的格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        // 使用Calendar获取当前日期和时间
        Calendar calendar = Calendar.getInstance();
        return formatter.format(calendar.getTime());
    }

    /**
     * 获取当前时间==仅仅获取当前的日期(没有时间)
     * @return String
     */
    public String dateGetWithLocalDate() {
        // 设置时间的格式(注意这种获取方式，没有具体的时间，只有当前的日期)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        return date.format(formatter);
    }

    /**
     * 获取当前时间==仅仅获取当前的时间(没有日期)
     * @return String
     */
    public String dateGetWithLocalTime() {
        // 设置当前的时间的格式(注意这种获取方式，没有具体的日期，只有当前的时间)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime date = LocalTime.now();
        return date.format(formatter);
    }

    /**
     * 获取当前时间
     * @return String
     */
    public String dateGetWithLocalDateTime() {
        // 设置时间的格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        return date.format(formatter);
    }
}
