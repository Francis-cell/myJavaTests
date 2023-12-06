package com.zmr.LearningFiles.BasicJava.EffectiveJavaDemos.JavaStaticFactory;

public class JavaStaticFactory {
    /** userName */
    private String userName;

    JavaStaticFactory(String userName) {
        this.userName = userName;
    }

    /**
     * 静态工厂方法
     * 优势：
     * 1、有名称，在构造器较多的时候可以正确的选择构造器；
     * 2、不必每次调用都创建一个新的对象，因为是类的方法而不是实例方法；
     * 3、可以返回原返回类型的任何子类型；
     * 4、所返回对象的类可以随着每次调用而发生变化，取决于静态工厂方法的参数值（例如版本变化，可以调整中间的某个方法，用户不自知）
     * 5、【牵强】方法返回对象所属的类，在编写包含该静态工厂方法的类时可以不存在；
     */
    public static JavaStaticFactory of(String userName) {
        return new JavaStaticFactory(userName);
    }
}
