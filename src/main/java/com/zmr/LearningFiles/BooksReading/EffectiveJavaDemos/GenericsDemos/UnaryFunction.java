package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.GenericsDemos;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryFunction {
    // private static UnaryOperator<Object> IDENTIFY_FN = (t) -> t;
    //
    // @SuppressWarnings("unchecked")
    // public static <T> UnaryOperator<T> identifyFunction() {
    //     return (UnaryOperator<T>) IDENTIFY_FN;
    // }
    //
    // public static void main(String[] args) {
    //     String[] strings = { "jute", "hemp", "nylon" };
    //     UnaryOperator<String> sameString = identifyFunction();
    //     for (String s : strings) {
    //         System.out.println(sameString.apply(s));
    //     }
    //
    //     Number[] numbers = { 1, 2.0, 3L };
    //     UnaryOperator<Number> sameNumber = identifyFunction();
    //     for (Number n : numbers) {
    //     }
    // }



    private static UnaryOperator<Object> IDENTIFY_FN = (t) -> t;

    private static BinaryOperator<Object> EQUALS_FN = (t1, t2) -> t1.equals(t2);

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identifyFunction() {
        return (UnaryOperator<T>) IDENTIFY_FN;
    }

    @SuppressWarnings("unchecked")
    public static <T> BinaryOperator<T> equalsFunction() {
        return (BinaryOperator<T>) EQUALS_FN;
    }

    public static void main(String[] args) {
        String[] strings = { "jute", "hemp", "nylon" };
        // 打印每一行的方法
        UnaryOperator<String> sameString = identifyFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        // 比较两个变量值相同的方法
        // BinaryOperator<String> equalsString = equalsFunction();
        BinaryOperator<String> equalsString = (t1, t2) -> String.valueOf(t1.equals(t2));
        System.out.println(equalsString.apply(strings[0], strings[1]));



        Number[] numbers = { 1, 2.0, 3L };
        // 打印每一行的方法
        UnaryOperator<Number> sameNumber = identifyFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }

        // 比较两个变量值相同的方法 TODO 为什么这个能正常打印？但是 String 的就不行，需要强制转换一次
        BinaryOperator<Number> equalsNumber = equalsFunction();
        System.out.println(equalsNumber.apply(numbers[0], numbers[1]));
    }
}
