package com.zmr.LearningFiles.MyJavaTests.javaTests.myTests;

import lombok.Data;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/4/5 14:02
 * @description String测试
 */
public class StringTests {
    
    /** 辅助对象 */
    @Data
    public static class TestObj {
        private String a;
        private String b;
    } 
    
    
    /** toString() 和 asString() 测试 */
    public static void strTest01() {
        String testA = "abcd";
        TestObj testObj = new TestObj();
        testObj.setA("a");
        testObj.setB("b");

        System.out.println(testA.toString());
        // 简单的字符串无法直接使用asString()
        //System.out.println(testA.asString());

        System.out.println(testObj.toString());
        //System.out.println(testObj.asString());
    }
    
    
    public static void main(String[] args) {
        strTest01();
    }
}
