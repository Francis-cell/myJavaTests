package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

public class MyTest24 {
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String number = "阿水阿水";
        boolean isDouble = isDouble(number);
        System.out.println(number + " 是一个浮点数吗？ " + isDouble);
    }
}
