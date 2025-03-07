package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.CompositionAndInheritance;

public class Main {
    public static void main(String[] args) {
        CountingStackWithComposition<String> s = new CountingStackWithComposition<>();
        s.push("first");
        s.multiPush("second", "third");
        System.out.println(s.getPushCount());
    }
}
