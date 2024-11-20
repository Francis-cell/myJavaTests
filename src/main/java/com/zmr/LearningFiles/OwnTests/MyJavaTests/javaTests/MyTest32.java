package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import com.alibaba.excel.util.StringUtils;
import com.zmr.ImportantComponents.Exception.BusinessException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest32 {

    // public static <T> Date changeDateValToDateFormat(T dateVal, String formatStr) {
    //     Date ans = null;
    //     if (StringUtils.isEmpty(formatStr)) {
    //         // throw new BusinessException("要转换的日期格式不能为空！");
    //         System.out.println("要转换的日期格式不能为空！");
    //     }
    //     SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
    //     try {
    //         // 尝试解析日期
    //         if (dateVal instanceof String) {
    //             ans = sdf.parse((String) dateVal);
    //         }
    //         if (dateVal instanceof Date) {
    //             String tmpDateStr = sdf.format((Date) dateVal);
    //             ans = sdf.parse(tmpDateStr);
    //         }
    //     } catch (ParseException e) {
    //         ans = null;
    //     }
    //     return ans;
    // }
    //
    // public static void main(String[] args) {
    //     Date ans = null;
    //     Date ans1 = null;
    //     String dateVal = "2024-10-01 00:00:00.0";
    //     String dateVal1 = "2024/10/01 00:00:00.0";
    //     String dateVal2 = "01/10/2024 00:00:00.0";
    //     String formatStr = "yyyy-MM-dd HH:mm:ss";
    //     String formatStr1 = "yyyy/MM/dd HH:mm:ss";
    //     ans = changeDateValToDateFormat(dateVal, formatStr);
    //     ans1 = changeDateValToDateFormat(dateVal1, formatStr1);
    //     System.out.println(ans);
    //     System.out.println(ans1);
    //
    // }




        public static <T> Date changeDateValToDateFormat(T dateVal, String formatStr) {
            Date ans = null;
            if (StringUtils.isEmpty(formatStr)) {
                System.out.println("要转换的日期格式不能为空！");
                return null;
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

        // 辅助方法，尝试使用多个格式解析字符串
        private static Date tryParseDate(String dateStr, String[] formats) {
            for (String format : formats) {
                try {
                    return new SimpleDateFormat(format).parse(dateStr);
                } catch (ParseException ignored) {
                }
            }
            throw new BusinessException("时间格式转换失败，请检查！当前要进行转换的日期为：" + dateStr);
        }

        public static void main(String[] args) {
            String dateVal1 = "2024-10-01 00:00:00.0";
            String dateVal2 = "2024/10/01 00:00:00.0";
            // String dateVal3 = "2024=10=01 00:00:00.0";
            String dateVal4 = "01/10/2024 00:00:00.0";
            String formatStr = "yyyy/MM/dd HH:mm:ss";
            String formatStr4 = "dd/MM/yyyy HH:mm:ss";

            System.out.println(changeDateValToDateFormat(dateVal1, formatStr));
            System.out.println(changeDateValToDateFormat(dateVal2, formatStr));
            // System.out.println(changeDateValToDateFormat(dateVal3, formatStr));
            System.out.println(changeDateValToDateFormat(dateVal4, formatStr4));
        }


}
