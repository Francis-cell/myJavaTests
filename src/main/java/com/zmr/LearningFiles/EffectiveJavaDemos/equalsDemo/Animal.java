package com.zmr.LearningFiles.EffectiveJavaDemos.equalsDemo;

import org.checkerframework.checker.units.qual.A;

import java.util.Objects;

/**
 * @Author franciszmr
 * @Date 2023/12/6 23:37
 * @Version 1.0
 * @Description TODO
 **/
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // 正确的 equals 方法
    @Override
    public boolean equals(Object o) {
        System.out.println("走了 Animal 的 equals 方法!");
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }
}
