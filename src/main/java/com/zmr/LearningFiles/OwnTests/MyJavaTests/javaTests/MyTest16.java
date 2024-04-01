package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import com.zmr.LearningFiles.OwnLearning.BasicJava.MyExceptionUtils.MyExceptions;

import java.text.ParseException;
import java.util.Scanner;

/**
 * @ClassName MyTest12
 * @Description sort方法测试
 * @Author zhumengren
 * @Date 2022/6/7 10:46

 * @Version 1.0
 **/
public class MyTest16 {
    /**自定义一个判断数字的值的方法，使用自定义异常*/
    public static int myNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int a = input.nextInt();
        try {
            if (a < 0) {
                throw new MyExceptions("输入的数值不能小于0");
            } else if (a >= 100) {
                throw new MyExceptions("输入的数值不能大于100");
            }
        } catch (MyExceptions e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return a;
    }


    public static void main(String[] args) throws ParseException {

        /**数组排序*/
        //int[] intArr = {1, 3, 5, 6, 7, 2, 2, 4, 5};
        ////IntStream sorted = Arrays.stream(intArr).sorted();
        ////sorted.forEach(item->{
        ////    System.out.println(item);
        ////});
        //
        //Arrays.sort(intArr);
        //for (int i = 0; i < intArr.length; i++) {
        //    System.out.print(intArr[i]);
        //    System.out.print("-");
        //}

        System.out.println(myNumber());

    }
}
