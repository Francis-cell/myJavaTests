package com.zmr.MyUtils.StringUtils;

public interface StringUtils {
    /**
     * <p> 将一些字符串拼接成 'c','c','c' 的形式，为了 update 批量更新时使用 </p>
     * @param strArr 待拼接字符串
     * @return 拼接之后的更新 str 的值
     * @param <T>
     */
    <T> String joinStringForUpdateInSql(T[] strArr);

    /**
     * <p> 将一些字符串拼接成 'c','c','c' 的形式，为了 update 批量更新时使用 </p>
     * @param strArr 待拼接字符串
     * @param splitStr 连接字符
     * @return 拼接之后的更新 str 的值
     * @param <T>
     */
    <T> String joinStringForUpdateInSql(T[] strArr, String splitStr);

    /**
     * <p> 从某个字符串中剔除一些字符串 </p>
     * @param str 要处理的字符串
     * @param strArr 要剔除的字符串形成的数组
     * @return
     */
    String cullingStringsFromAString(String str, String[] strArr);

    /**
     * <p> 从某个字符串中剔除一些字符串 </p>
     * @param str 要处理的字符串
     * @param strArr 要剔除的字符串形成的数组
     * @param splitStr 分割字符
     * @return
     */
    String cullingStringsFromAString(String str, String[] strArr, String splitStr);

}
