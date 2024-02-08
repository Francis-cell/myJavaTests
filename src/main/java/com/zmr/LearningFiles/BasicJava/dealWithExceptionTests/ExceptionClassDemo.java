package com.zmr.LearningFiles.BasicJava.dealWithExceptionTests;

public class ExceptionClassDemo {
    protected static int test01() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        System.out.println(test01());
    }
}
