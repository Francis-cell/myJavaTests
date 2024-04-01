package com.zmr.LearningFiles.OwnLearning.BasicJava.protectedTests.test04.p2;

import com.zmr.LearningFiles.OwnLearning.BasicJava.protectedTests.test04.p1.MyObject4;

/**
 * @ClassName ProtectedTest04
 * @Description ProtectedTest04测试类
 * @Author zhumengren
 * @Date 2022/4/18 13:32

 * @Version 1.0
 **/
public class ProtectedTest04 {
    public static void main(String[] args){
        MyObject4 myObject4 = new MyObject4();
        // 报错内容：'clone()' has protected access in 'main.java.com.zmr.LearningFiles.BasicJava.protectedTests.test04.p1.MyObject4'
        // myObject4.clone();
    }
}
