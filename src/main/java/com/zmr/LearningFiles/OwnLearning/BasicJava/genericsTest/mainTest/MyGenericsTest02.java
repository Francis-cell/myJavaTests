package com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTest.mainTest;

import com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTest.genericsClass.Persons;

/**
 * @ClassName MyGenericsTest02
 * @Description 泛型测试案例02
 * @Author zhumengren
 * @Date 2022/8/25 8:31

 * @Version 1.0
 **/
public class MyGenericsTest02 {
    public static void main(String[] args) {
        Persons<Integer> persons = new Persons<>(1);
        persons.show();
    }
}
