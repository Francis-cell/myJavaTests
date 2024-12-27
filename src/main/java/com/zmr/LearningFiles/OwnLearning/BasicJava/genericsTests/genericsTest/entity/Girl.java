package com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTests.genericsTest.entity;

/**
 * @ClassName Girl
 * @Description Girl实体类
 * @Author zhumengren
 * @Date 2022/8/25 8:36

 * @Version 1.0
 **/
public class Girl extends Person{
    public Girl() {
        System.out.println("Girl构造方法!!!");
    }

    public Girl(String name, Integer age) {
        super(name, age, "女");
        System.out.println("Girl构造方法!!!");
    }
}
