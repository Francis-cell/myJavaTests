
package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import java.util.HashMap;

public class MyTest34 {
    public static void main(String[] args) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("projectcode", null);
        String projectcode = (String) params.getOrDefault("projectcode", null);
        System.out.println(projectcode);
        System.out.println(projectcode == null);
        System.out.println("null".equals(projectcode));
    }
}
