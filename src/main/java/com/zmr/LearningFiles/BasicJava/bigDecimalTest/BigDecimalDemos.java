package com.zmr.LearningFiles.BasicJava.bigDecimalTest;

import java.math.BigDecimal;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/10/28 17:18
 * @description
 */
public class BigDecimalDemos {
    public static void main(String[] args) {
        BigDecimal balance = BigDecimal.ZERO;
        BigDecimal bigDecimal = new BigDecimal(10);

        //System.out.println(bigDecimal.compareTo(balance) < 0);
        bigDecimal.subtract(balance);
    }
}
