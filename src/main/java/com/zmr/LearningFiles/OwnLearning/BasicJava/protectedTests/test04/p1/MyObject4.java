package com.zmr.LearningFiles.OwnLearning.BasicJava.protectedTests.test04.p1;

import com.zmr.LearningFiles.OwnLearning.BasicJava.protectedTests.test04.p2.ProtectedTest04;

/**
 * @ClassName MyObject4
 * @Description 自定义对象实体类
 * @Author zhumengren
 * @Date 2022/4/18 13:30

 * @Version 1.0
 **/
public class MyObject4 extends ProtectedTest04 {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
