package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.compareToDemos;

public class Main {
    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber(120, 111, 1);
        PhoneNumber pn2 = new PhoneNumber(120, 121, 1);
        System.out.println(pn1.compareTo(pn2));
    }
}
