package com.zmr.LearningFiles.OwnLearning.BasicJava.entity;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/8/8 22:22
 * @description
 */
public class ObjectDemos {
    private String name;
    
    private int age;

    @Override
    public String toString() {
        return "ObjectDemos{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ObjectDemos() {
    }

    public ObjectDemos(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
