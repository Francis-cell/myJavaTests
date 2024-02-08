package com.zmr.LearningFiles.EffectiveJavaDemos.ThreadDemos;

public class Main {
    public static void main(String[] args) {
        String str1 = new String("hi");
        String str2 = "hi";
        String str3 = str1.intern();
        String str4 = str2.intern();
        System.out.println(str3 == str4);
    }
}
