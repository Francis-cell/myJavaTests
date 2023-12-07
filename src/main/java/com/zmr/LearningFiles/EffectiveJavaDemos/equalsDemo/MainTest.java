package com.zmr.LearningFiles.EffectiveJavaDemos.equalsDemo;

import java.math.BigInteger;

/**
 * @Author franciszmr
 * @Date 2023/12/6 23:44
 * @Version 1.0
 * @Description TODO
 **/
public class MainTest {
    public static void main(String[] args) {
        Animal animal = new Animal("abc");
        Dog dog = new Dog("abc", "Labrador");
        boolean equals = animal.equals(dog);
//        boolean equals = dog.equals(animal);
        System.out.println(equals);

        BigInteger bigInteger = new BigInteger(String.valueOf(10));
    }
}
