package com.zmr.MyUtils.NumberUtils;

import java.math.BigDecimal;

public interface DoubleUtils {
    /**
     * <p> 提供精确的加法运算(Double类型参数) </p>
     * @param v1 被加数
     * @param v2 加数
     * @return double 两个参数的和
     */
    double add(double v1, double v2);

    /**
     * <p> 提供精确的加法运算(String类型参数) </p>
     * @param v1 被加数
     * @param v2 加数
     * @return BigDecimal 两个参数的和
     */
    BigDecimal add(String v1, String v2);

    /**
     * <p> 提供精确的加法运算(保留scale位小数) </p>
     * @param v1 被加数
     * @param v2 加数
     * @param scale 保留scale位小数
     * @return double 两个参数的和
     */
    double add(double v1, double v2, int scale);

    /**
     * <p> 提供精确的加法运算(保留scale位小数) </p>
     * @param v1 被加数
     * @param v2 加数
     * @param scale 保留scale位小数
     * @return String 两个参数的和
     */
    String add(String v1, String v2, int scale);

    /**
     * <p> 提供精确的减法运算(Double类型参数) </p>
     * @param v1 被减数
     * @param v2 减数
     * @return double 两个参数的差
     */
    double sub(double v1, double v2);

    /**
     * <p> 提供精确的减法运算(String类型参数) </p>
     * @param v1 被减数
     * @param v2 减数
     * @return BigDecimal 两个参数的差
     */
    BigDecimal sub(String v1, String v2);

    /**
     * <p> 提供精确的减法运算(保留scale位小数) </p>
     * @param v1    被减数
     * @param v2    减数
     * @param scale 保留scale 位小数
     * @return double 两个参数的差
     */
    double sub(double v1, double v2, int scale);

    /**
     * <p> 提供精确的减法运算(保留scale位小数) </p>
     * @param v1    被减数
     * @param v2    减数
     * @param scale 保留scale 位小数
     * @return String 两个参数的差
     */
    String sub(String v1, String v2, int scale);

    /**
     * <p> 提供精确的乘法运算(Double类型参数) </p>
     * @param v1 被乘数
     * @param v2 乘数
     * @return double 两个参数的积
     */
    double mul(double v1, double v2);

    /**
     * <p> 提供精确的乘法运算(String类型参数) </p>
     * @param v1 被乘数
     * @param v2 乘数
     * @return BigDecimal 两个参数的积
     */
    BigDecimal mul(String v1, String v2);

    /**
     * <p> 提供精确的乘法运算(保留scale位小数，并进行四舍五入处理)【对结果进行处理】 </p>
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return double 两个参数的积
     */
    double mul(double v1, double v2, int scale);

    /**
     * <p> 提供精确的乘法运算(String类型参数) </p>
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return String 两个参数的积
     */
    String mul(String v1, String v2, int scale);

    /**
     * <p> 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到小数点以后10位，
     * 以后的数字四舍五入(double类型参数) </p>
     * @param v1 被除数
     * @param v2 除数
     * @return double 两个参数的商
     */

    double div(double v1, double v2);

    /**
     * <p> 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，
     * 以后的数字四舍五入(double类型参数) </p>
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return double 两个参数的商
     */
    double div(double v1, double v2, int scale);

    /**
     * <p> 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，
     * 以后的数字四舍五入(String类型参数) </p>
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示需要精确到小数点以后几位
     * @return String 两个参数的商
     */
    String div(String v1, String v2, int scale);

    /**
     * <p> 提供精确的小数位四舍五入处理(double类型的参数) </p>
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return double 四舍五入后的结果
     */
    double round(double v, int scale);

    /**
     * <p> 提供精确的小数位四舍五入处理(String 参数) </p>
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return String 四舍五入后的结果
     */
    String round(String v, int scale);

    /**
     * <p> 取余数(String参数) </p>
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return String 余数
     */
    String remainder(String v1, String v2, int scale);

    /**
     * <p> 取余数  BigDecimal </p>
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return BigDecimal 余数
     */
    BigDecimal remainder(BigDecimal v1, BigDecimal v2, int scale);

    /**
     * <p> 比较大小 </p>
     * @param v1 被比较数
     * @param v2 比较数
     * @return boolean 如果v1 大于v2 则 返回true 否则false
     */
    boolean compare(String v1, String v2);
}
