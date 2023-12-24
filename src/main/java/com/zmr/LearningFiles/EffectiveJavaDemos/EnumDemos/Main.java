package com.zmr.LearningFiles.EffectiveJavaDemos.EnumDemos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // BigDecimal b1 = new BigDecimal("5.5");
        // BigDecimal b2 = new BigDecimal("3.5");
        // BigDecimal b3 = new BigDecimal("4.5");
        //
        // System.out.println("=====================================");
        // System.out.println(b1.setScale(0, RoundingMode.UP));
        // System.out.println(b1.setScale(0, RoundingMode.DOWN));
        // System.out.println(b1.setScale(0, RoundingMode.HALF_UP));
        // System.out.println(b1.setScale(0, RoundingMode.HALF_DOWN));
        // System.out.println(b1.setScale(0, RoundingMode.HALF_EVEN));
        //
        // System.out.println("=====================================");
        // System.out.println(b2.setScale(0, RoundingMode.UP));
        // System.out.println(b2.setScale(0, RoundingMode.DOWN));
        // System.out.println(b2.setScale(0, RoundingMode.HALF_UP));
        // System.out.println(b2.setScale(0, RoundingMode.HALF_DOWN));
        // System.out.println(b2.setScale(0, RoundingMode.HALF_EVEN));
        //
        // System.out.println("=====================================");
        // System.out.println(b3.setScale(0, RoundingMode.UP));
        // System.out.println(b3.setScale(0, RoundingMode.DOWN));
        // System.out.println(b3.setScale(0, RoundingMode.HALF_UP));
        // System.out.println(b3.setScale(0, RoundingMode.HALF_DOWN));
        // System.out.println(b3.setScale(0, RoundingMode.HALF_EVEN));


        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
        // System.out.println(PayrollDay.FRIDAY.pay(10, 3));
    }
}
