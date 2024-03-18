package com.zmr.LearningFiles.OwnLearning.BasicJava.stringArrayTests;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName StringArrayTest01
 * @Description String字符串和数组之间的转换测试类
 * @Author zhumengren
 * @Date 2022/4/16 20:36
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class StringArrayTest01 {
    /**
     * 字符串转换数组测试
     * @return void
     */
    public void stringToArray() {
        String str01 = "abcdef";
        // 第一种转换方式，返回的结果是String类型的数组
        //MyLoggerUtils.logger.info("=============String.split()方法==============");
        System.out.println("=============String.split()方法==============");
        // 最常使用的分割方法，使用 String.split("分割符") 的方法进行分割
        String[] str01Arr = str01.split("");

        // 第二种转换方式，返回的结果是Char类型的数组
        //MyLoggerUtils.logger.info("=============String.toCharArray()方法==============");
        System.out.println("=============String.toCharArray()方法==============");
        char[] str01ArrChar = str01.toCharArray();
        for (char ch : str01ArrChar) {
            // 这里返回的是对应的字母的char的值
            // 结果：a b c d e f
            System.out.println(ch);
        }

        // 第三种转换方式，返回的结果是Byte类型的数组
        //MyLoggerUtils.logger.info("=============String.getBytes()方法==============");
        System.out.println("=============String.getBytes()方法==============");
        byte[] str01Bytes = str01.getBytes();
        for (Byte b : str01Bytes) {
            // 这里返回的是对应字母的ASCII码的值
            // 结果：97 98 99 100 101 102
            System.out.println(b);
        }
    }

    /**
     * 数组转换字符串测试
     * @return void
     */
    public void arrayToString() {
        // 1、针对byte数组进行的转换
        //MyLoggerUtils.logger.info("==============byte数组转换==============");
        System.out.println("==============byte数组转换==============");
        // 初始化一个byte数组
        byte[] byteArr = new byte[6];
        int start = 97;
        // 初始化byteArr中的值
        for (int i = 0; i < byteArr.length; i++) {
            byteArr[i] = (byte)start;
            start++;
        }

        // 将这个byte数组转换成字符串形式
        String strValue1 = new String(byteArr);
        // 结果：1、strValue1的值为：abcdef
        System.out.println("1、strValue1的值为：" + strValue1);
        String strValue2 = String.copyValueOf(strValue1.toCharArray(), 0, byteArr.length);
        // 结果：2、strValue2的值为：abcdef
        System.out.println("2、strValue2的值为：" + strValue2);
    }

    /**
     * 携带编码方式的转换和还原
     * @param str 用于转换成byte[]的汉字字符串；同时测试从byte[]还原成String的流程
     * @return void
     */
    public void StringArrayWithCode(String str) {
        System.out.println("================================");
        try {
            System.out.println("========采用UTF-8编码的方式进行转换========");
            byte[] strBytes = str.getBytes("UTF-8");
            for (byte b : strBytes) {
                System.out.print(b + " ");
            }
            System.out.println();
            // 转换之后还原出原本的中文字符串形式
            System.out.println("还原中文字符串开始：");
            String strBytesString = new String(strBytes, "UTF-8");
            System.out.println(strBytesString);
            System.out.println();

            System.out.println("========采用UTF-16编码的方式进行转换========");
            byte[] strBytes1 = str.getBytes("UTF-16");
            for (byte b : strBytes1) {
                System.out.print(b + " ");
            }
            System.out.println();
            // 转换之后还原出原本的中文字符串形式
            System.out.println("还原中文字符串开始：");
            strBytesString = new String(strBytes1, "UTF-16");
            System.out.println(strBytesString);
            System.out.println();

            System.out.println("========采用ISO-8859-1编码的方式进行转换========");
            byte[] strBytes2 = str.getBytes("ISO-8859-1");
            for (byte b : strBytes2) {
                System.out.print(b + " ");
            }
            System.out.println();
            // 转换之后还原出原本的中文字符串形式
            System.out.println("还原中文字符串开始：");
            strBytesString = new String(strBytes2, "ISO-8859-1");
            System.out.println(strBytesString);
            System.out.println();

            System.out.println("========采用US-ASCII编码的方式进行转换========");
            byte[] strBytes3 = str.getBytes("US-ASCII");
            for (byte b : strBytes3) {
                System.out.print(b + " ");
            }
            System.out.println();
            // 转换之后还原出原本的中文字符串形式
            System.out.println("还原中文字符串开始：");
            strBytesString = new String(strBytes2, "US-ASCII");
            System.out.println(strBytesString);
            System.out.println();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("================================");
    }
}
