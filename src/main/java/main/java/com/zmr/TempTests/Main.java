package main.java.com.zmr.TempTests;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static int incrementValue() {
        int a = 0;
        // return ++a;
        return a++;
    }

    public static void main(String[] args) {
        // BigDecimal b1 = new BigDecimal(100);
        // BigDecimal b2 = new BigDecimal(0);
        // System.out.println(b1.divide(b2, 3, RoundingMode.DOWN));

        // FinalDemo finalDemo = new FinalChildDemo();
        // finalDemo.setA("x");
        // FinalDemo finalDemo2 = new FinalChildDemo();
        // System.out.println(finalDemo.getA());
        // System.out.println(finalDemo2.getA());

        // String a = "True";
        // if ("True".equals(a)) {
        //     System.out.println(1);
        // } else {
        //     System.out.println(2);
        // }
        //
        // System.out.println("==========================");
        //
        // String b = "True".equals(a) ? a : "False";
        // System.out.println(b);

        // System.out.println(incrementValue());

        Double a = null;
        if (a instanceof Number) {
            System.out.println("a");
        } else {
            System.out.println("b");
        }
    }
}
