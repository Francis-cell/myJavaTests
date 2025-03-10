package com.zmr.MyUtils.DataStructUtils.NumberUtils;

import java.math.BigDecimal;

public final class DoubleUtils {
    /** 默认除法运算精度 */
    private static final int DEF_DIV_SCALE = 10;

    private static final DoubleUtils INSTANCE = new DoubleUtils();

    private DoubleUtils() {}

    public DoubleUtils getInstance() {
        return INSTANCE;
    }

    /**
     * <p> 提供精确的加法运算(Double类型参数) </p>
     * @param v1 被加数
     * @param v2 加数
     * @return double 两个参数的和
     */
    public static double add(double v1, double v2) {
        // 首先将两个双精度的数值转换成String类型的，防止丢失当前的精度
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * <p> 提供精确的加法运算(String类型参数) </p>
     * @param v1 被加数
     * @param v2 加数
     * @return BigDecimal 两个参数的和
     */
    public static BigDecimal add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2);
    }

    /**
     * <p> 提供精确的加法运算(保留scale位小数) </p>
     * @param v1 被加数
     * @param v2 加数
     * @param scale 保留scale位小数
     * @return double 两个参数的和
     */
    public static double add(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        String s1 = Double.toString(v1);
        String s2 = Double.toString(v2);
        // 设置四舍五入保留小数的方式
        BigDecimal val = new BigDecimal(add(s1, s2, scale));
        return val.doubleValue();
    }

    /**
     * <p> 提供精确的加法运算(保留scale位小数) </p>
     * @param v1 被加数
     * @param v2 加数
     * @param scale 保留scale位小数
     * @return String 两个参数的和
     */
    public static String add(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        // 设置四舍五入保留小数的方式
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }


    /**
     * <p> 提供精确的减法运算(Double类型参数) </p>
     * @param v1 被减数
     * @param v2 减数
     * @return double 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * <p> 提供精确的减法运算(String类型参数) </p>
     * @param v1 被减数
     * @param v2 减数
     * @return BigDecimal 两个参数的差
     */
    public static BigDecimal sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2);
    }

    /**
     * <p> 提供精确的减法运算(保留scale位小数) </p>
     * @param v1    被减数
     * @param v2    减数
     * @param scale 保留scale 位小数
     * @return double 两个参数的差
     */
    public static double sub(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        String s1 = Double.toString(v1);
        String s2 = Double.toString(v2);
        BigDecimal val = new BigDecimal(sub(s1, s2, scale));
        return val.doubleValue();
    }

    /**
     * <p> 提供精确的减法运算(保留scale位小数) </p>
     * @param v1    被减数
     * @param v2    减数
     * @param scale 保留scale 位小数
     * @return String 两个参数的差
     */
    public static String sub(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * <p> 提供精确的乘法运算(Double类型参数) </p>
     * @param v1 被乘数
     * @param v2 乘数
     * @return double 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * <p> 提供精确的乘法运算(String类型参数) </p>
     * @param v1 被乘数
     * @param v2 乘数
     * @return BigDecimal 两个参数的积
     */
    public static BigDecimal mul(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2);
    }

    /**
     * <p> 提供精确的乘法运算(保留scale位小数，并进行四舍五入处理)【对结果进行处理】 </p>
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return double 两个参数的积
     */
    public static double mul(double v1, double v2, int scale) {
        String s1 = Double.toString(v1);
        String s2 = Double.toString(v2);
        BigDecimal val = new BigDecimal(mul(s1, s2, scale));
        return val.doubleValue();
    }

    /**
     * <p> 提供精确的乘法运算(String类型参数) </p>
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return String 两个参数的积
     */
    public static String mul(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * <p> 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到小数点以后10位，
     * 以后的数字四舍五入(double类型参数) </p>
     * @param v1 被除数
     * @param v2 除数
     * @return double 两个参数的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * <p> 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，
     * 以后的数字四舍五入(double类型参数) </p>
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return double 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        String s1 = Double.toString(v1);
        String s2 = Double.toString(v2);
        BigDecimal val = new BigDecimal(div(s1, s2, scale));
        return val.doubleValue();
    }

    /**
     * <p> 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，
     * 以后的数字四舍五入(String类型参数) </p>
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示需要精确到小数点以后几位
     * @return String 两个参数的商
     */
    public static String div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * <p> 提供精确的小数位四舍五入处理(double类型的参数) </p>
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return double 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * <p> 提供精确的小数位四舍五入处理(String 参数) </p>
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return String 四舍五入后的结果
     */
    public static String round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * <p> 取余数(String参数) </p>
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return String 余数
     */
    public static String remainder(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.remainder(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * <p> 取余数  BigDecimal </p>
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return BigDecimal 余数
     */
    public static BigDecimal remainder(BigDecimal v1, BigDecimal v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        return v1.remainder(v2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * <p> 比较大小 </p>
     * @param v1 被比较数
     * @param v2 比较数
     * @return boolean 如果v1 大于v2 则 返回true 否则false
     */
    public static boolean compare(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        boolean res;
        if (bj > 0) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    /**
     * <p> 检查一个数据是否是 double 类型的 </p>
     * @param str
     * @return
     */
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
