package com.zmr.LearningFiles.OwnLearning.BasicJava.protectedTests.test07.p1;

/**
 * @ClassName MyObject7
 * @Description 自定义对象实体类
 * @Author zhumengren
 * @Date 2022/4/18 13:30

 * @Version 1.0
 **/
public class MyObject7 extends ProtectedTest07{
    public static void main(String[] args) {
        ProtectedTest07 pt7 = new ProtectedTest07();
        // 报错内容：'clone()' has protected access in 'java.lang.Object'
        // pt7.clone();
    }
}
