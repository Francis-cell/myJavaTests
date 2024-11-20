package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

public class MyTest27 {
    public static void main(String[] args) {
        String num = "-";
        try {
            int tmpInt = Integer.parseInt(num);
            if (tmpInt <= 0) {
                System.out.println(10);
            } else if (tmpInt >= 100) {
                System.out.println(100);
            } else {
                System.out.println(tmpInt);
            }
        }
        catch (Exception e) {
            System.out.println("异常！");
        }
    }
}
