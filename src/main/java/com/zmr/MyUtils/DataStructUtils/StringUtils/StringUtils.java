package com.zmr.MyUtils.DataStructUtils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class StringUtils {
    private static final StringUtils INSTANCE  = new StringUtils();

    // 默认使用的分隔符字符串
    private static final String SPLIT_STR = ",";

    private StringUtils() {}

    public static StringUtils getInstance() {
        return INSTANCE;
    }

    /**
     * <p> 将一些字符串拼接成 'c','c','c' 的形式，为了 update 批量更新时使用 </p>
     * @param strArr 待拼接字符串
     * @return 拼接之后的更新 str 的值
     * @param <T>
     */
    public static <T> String joinStringForUpdateInSql(T[] strArr) {
        return joinStringForUpdateInSql(strArr, SPLIT_STR);
    }

    /**
     * <p> 将一些字符串拼接成 'c','c','c' 的形式，为了 update 批量更新时使用 </p>
     * @param strArr 待拼接字符串
     * @param splitStr 连接字符
     * @return 拼接之后的更新 str 的值
     * @param <T>
     */
    public static <T> String joinStringForUpdateInSql(T[] strArr, String splitStr) {
        String ans = "";
        // 1、类型校验
        // null 值校验
        if (strArr == null || splitStr == null || strArr.length == 0) {
            return ans;
        }

        // 2、字符串检查
        if (strArr[0] instanceof String) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                sb.append("'").append(strArr[i]).append("'");
                if (i != strArr.length - 1) {
                    sb.append(splitStr);
                }
            }
            ans = sb.toString();
        }
        // 3、Integer、Double 检查
        if (strArr[0] instanceof Integer || strArr[0] instanceof Double) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                sb.append("'").append(strArr[i].toString()).append("'");
                if (i != strArr.length - 1) {
                    sb.append(splitStr);
                }
            }
            ans = sb.toString();
        }
        return ans;
    }

    /**
     * <p> 从某个字符串中剔除一些字符串 </p>
     * @param str 要处理的字符串
     * @param strArr 要剔除的字符串形成的数组
     * @return
     */
    public static String cullingStringsFromAString(String str, String[] strArr) {
        return cullingStringsFromAString(str, strArr, null);
    }

    /**
     * <p> 从某个字符串中剔除一些字符串 </p>
     * @param str 要处理的字符串
     * @param strArr 要剔除的字符串形成的数组
     * @param splitStr 分割字符
     * @return
     */
    public static String cullingStringsFromAString(String str, String[] strArr, String splitStr) {
        if (str == null || "".equals(str) || strArr == null || strArr.length == 0) {
            return str;
        }
        // 包含则剔除，不包含则不处理
        for (String s : strArr) {
            if (s != null && !"".equals(s)) {
                // 使用正则替换所有对应的字符串
                // 说明指定了分割字符
                if (splitStr != null) {
                    str = str.replaceAll(Pattern.quote(splitStr + s), "");
                } else {
                    str = str.replaceAll(Pattern.quote(s), "");
                }
            }
        }
        return str;
    }

    /**
     * <p> 判断一个 str 是否为 null 或者长度为 0 </p>
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        boolean ans = true;
        if (str == null || str.length() == 0) {
            return ans;
        }
        ans = false;
        return ans;
    }

    /**
     * <p> 判断一个 str 是否不为 null 或者长度为 0 </p>
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
