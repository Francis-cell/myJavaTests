package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.CommonDemos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BasicAndPackingTypeDemo {

    /**
     * 方法被调用之后，返回值为 -1
     * i < j 部分可以正常判断
     * i == j 部分是存在问题的，它在对象引用上执行了同一性比较，所以两个变量引用不一样，从而结果为 false
     * TODO 说明：对于装箱基本类型运用 == 操作符几乎总是错误的
     */
    public static void IntegerBasicAndPackingDemo01() {
        Comparator<Integer> naturalOrder =
                (i, j) -> (i < j) ? -1 : (i == j ? 0 : -1);
        int compare = naturalOrder.compare(new Integer(4), new Integer(4));
        System.out.println(compare);
    }

    /**
     * 解决 demo01 中存在的问题
     * method1：调用 Comparator.naturalOrder() 方法
     */
    public static void IntegerBasicAndPackingDemo02() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(10);
        integers.add(3);
        integers.add(9);
        integers.add(20);
        System.out.printf("排序前: %s%n", integers);
        Collections.sort(integers, Comparator.naturalOrder());
        System.out.printf("排序后: %s%n", integers);
    }

    /**
     * 解决 demo01 中存在的问题
     * method2：添加两个局部变量，用来保存装箱类型对应的基本类型的值
     */
    public static void IntegerBasicAndPackingDemo03() {
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed;
            return i < j ? -1 : (i == j ? 0 : 1);
        };
        int compare = naturalOrder.compare(new Integer(4), new Integer(4));
        System.out.println(compare);
    }

    public static void main(String[] args) {
        // IntegerBasicAndPackingDemo01();
        // IntegerBasicAndPackingDemo02();
        IntegerBasicAndPackingDemo03();
    }
}
