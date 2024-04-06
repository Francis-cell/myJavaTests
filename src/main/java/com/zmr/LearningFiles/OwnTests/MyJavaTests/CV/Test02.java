package com.zmr.LearningFiles.OwnTests.MyJavaTests.CV;

/**
 * @Author franciszmr
 * @Date 2024/4/6 19:29
 * @Version 1.0
 * @Description TODO
 **/
public class Test02 {
    public static boolean solve (String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        return (A + A).contains(B);
    }

    public static void main(String[] args) {
        String A = "youzan";
        String B = "zanyou";
        System.out.println(solve(A, B));
    }
}
