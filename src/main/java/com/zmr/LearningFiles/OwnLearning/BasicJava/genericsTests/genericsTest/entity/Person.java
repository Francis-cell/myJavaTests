package com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTests.genericsTest.entity;

/**
 * @ClassName Person
 * @Description Person实体类
 * @Author zhumengren
 * @Date 2022/8/25 8:27

 * @Version 1.0
 **/
public class Person {
    private String name;
    private Integer age;
    private String sex;

    public Person() {
        System.out.println("Person构造方法!!!");
    }

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        System.out.println("Person构造方法!!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
