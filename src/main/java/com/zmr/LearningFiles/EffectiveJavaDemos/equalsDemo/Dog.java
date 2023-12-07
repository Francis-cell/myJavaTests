package com.zmr.LearningFiles.EffectiveJavaDemos.equalsDemo;

import java.util.Objects;

/**
 * @Author franciszmr
 * @Date 2023/12/6 23:40
 * @Version 1.0
 * @Description TODO
 **/
public class Dog extends Animal{
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    //// 错误的 equals 方法（这里是重载不是覆盖）
    //public boolean equals(Dog dog) {
    //    System.out.println("走了 Dog 的 equals 方法!");
    //    if (this == dog) {
    //        return true;
    //    }
    //    if (dog == null) {
    //        return false;
    //    }
    //
    //    return Objects.equals(breed, dog.breed);
    //}



    @Override
    public boolean equals(Object o) {
        System.out.println("走了 Dog 的 equals 方法!");
        if (this == o) {
            return true;
        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }

        if (!(o instanceof Dog)) {
            return false;
        }

        Dog dog = (Dog) o;
        return Objects.equals(breed, dog.breed);
    }
}
