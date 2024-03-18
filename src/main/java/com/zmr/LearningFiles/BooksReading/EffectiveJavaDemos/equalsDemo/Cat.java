package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.equalsDemo;

import java.util.Objects;

/**
 * @Author franciszmr
 * @Date 2023/12/6 23:57
 * @Version 1.0
 * @Description TODO
 **/
public class Cat extends Animal{
    private int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cat cat = (Cat) o;
        // super.equals(o) 部分实际上就比较的是 name 是否相同
        return super.equals(o) && Objects.equals(age, cat.age);
    }
}
