package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.MethodsDemo;

import java.util.Date;

public class PeriodTest {
    /**
     * 打破 Period 不可变类中参数示例
     */
    private static void demo01() {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        // Modifies internals of p
        end.setYear(78);
    }

    /**
     * 正确的使用案例 (Date 已经过时，不应该在新代码中使用)
     * 对构造器使用保护性拷贝是必要的
     */
    private static void demo02() {
        // 通过调整 Period 类的构造方法进行调整（引入保护性拷贝进行处理）
    }

    public static void main(String[] args) {

    }
}
