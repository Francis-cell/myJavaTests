package com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTests.genericsTest.genericsClass;

/**
 * @ClassName Person
 * @Description 泛型类Person的定义
 * @Author zhumengren
 * @Date 2022/8/25 17:25

 * @Version 1.0
 **/
public class Persons <T>{
    /** 定义一个类属性 */
    private T attribute;

    public Persons() {
        System.out.println("无参构造方法--Persons类！");
    }

    // 方法
    public Persons(T attribute) {
        this.attribute = attribute;
    }

    public void show() {
        System.out.printf("当前传入的参数的类型为：%s", attribute.getClass().getName());
    }
}
