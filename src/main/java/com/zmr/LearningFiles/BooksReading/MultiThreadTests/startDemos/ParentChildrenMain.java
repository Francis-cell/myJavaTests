package com.zmr.LearningFiles.BooksReading.MultiThreadTests.startDemos;

public class ParentChildrenMain {
    public static void main(String[] args) {
        ChildrenDemoClass childrenDemoClass = new ChildrenDemoClass();

        ParentDemoClass parentDemoClass = new ParentDemoClass();

        for (int i = 0; i < 10000; i++) {
            childrenDemoClass.doSomething();
            parentDemoClass.doSomething();
        }
    }
}
