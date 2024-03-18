package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.EnumDemos;

import java.util.Arrays;
import java.util.Collection;

public class OperationTest {

    /***
     * 使用接口模拟可扩展的枚举（方式1）
     * @param opEnumType
     * @param x
     * @param y
     * @param <T>
     */
    private static <T extends Enum<T> & OperationInterface> void test01(
            Class<T> opEnumType, double x, double y) {
        for (OperationInterface op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }

    private static void test02(Collection<? extends OperationInterface> opSet,
                               double x, double y) {
        for (OperationInterface op : opSet) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }

    public static void main(String[] args) {
        double x = 3.5;
        double y = 2.1;
        test01(ExtendedOperation.class, x, y);
        test02(Arrays.asList(ExtendedOperation.values()), x, y);
    }
}
