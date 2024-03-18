package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.MethodsDemo;

public class AssertDemo {
    private static void assertCheck(int[] a, int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
        // ...
    }

    public static void main(String[] args) {
        int[] a = null;
        int offset = 3;
        int length = 5;
        assertCheck(a, offset, length);
        System.out.println("断言之后的代码片段!");
    }
}
