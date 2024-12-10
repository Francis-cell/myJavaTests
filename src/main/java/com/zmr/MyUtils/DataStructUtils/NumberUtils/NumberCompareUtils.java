package com.zmr.MyUtils.DataStructUtils.NumberUtils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NumberCompareUtils {
    private static final NumberCompareUtils INSTANCE = new NumberCompareUtils();

    private NumberCompareUtils() {}

    public NumberCompareUtils getInstance() {
        return INSTANCE;
    }

    /**
     * <p> 检查两个数据是否偏差值在某个范围内 </p>
     * @param num1 参与比较的数据01 默认基准数
     * @param num2 参与比较的数据02
     * @param percent 百分比(当想要偏差值在 5% 内判断时，输入 5 即可，不支持浮点数，范围为 1 <= percent <= 100)
     * @return
     */
    public static boolean checkSomePercentBetweenTwoNum(String num1, String num2, int percent) {
        // 两者其一为 null 直接返回 false
        if (num1 == null || num2 == null) {
            return false;
        }
        // percent 检查，不在 1% ~ 100% 之间直接返回 false（后续可以根据需要调整）
        if (percent < 1 || percent > 100) {
            return false;
        }
        // 两者无法转换成数字，则返回 false
        try {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            return isWithinNPercent(n1, n2, percent,n1);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * <p> 比较两个浮点数之间的偏差是否在 n% 之内 </p>
     * @param num1 参与比较的数据01
     * @param num2 参与比较的数据02
     * @param percent 百分比，不受限制
     * @param baseNum 基准数
     * @return true - 偏差在 n% 之内； false - 偏差不在 n% 之内；
     */
    private static boolean isWithinNPercent(double num1, double num2, int percent,Double baseNum) {
        // 转换成 BigDecimal 进行计算
        BigDecimal bdA = BigDecimal.valueOf(num1);
        BigDecimal bdB = BigDecimal.valueOf(num2);

        BigDecimal base = null;
        if(baseNum == null){
            // 计算较大的数
            base = bdA.max(bdB);
        }else {
            base = BigDecimal.valueOf(baseNum);
        }

        // 0.01
        BigDecimal bd0_01 = BigDecimal.valueOf(0.01);
        // percent
        BigDecimal bdN = BigDecimal.valueOf(percent);
        // 0.01 * n
        BigDecimal percentLast = bdN.multiply(bd0_01);
        // 计算两数之差的绝对值
        BigDecimal difference = bdA.subtract(bdB).abs();


        //基准数为0时，特殊处理
        //偏差为0
        if (base.compareTo(BigDecimal.ZERO) == 0 && difference.compareTo(BigDecimal.ZERO) == 0){
            return true;
        }
        //偏差不为0，返回false
        if (base.compareTo(BigDecimal.ZERO) == 0 && difference.compareTo(BigDecimal.ZERO) != 0){
            return false;
        }

        // 计算n%的容差值
        BigDecimal tolerance = base.abs().multiply(percentLast);
        // 比较差的绝对值是否小于5%的容差值
        return difference.compareTo(tolerance) < 0;
    }
}
