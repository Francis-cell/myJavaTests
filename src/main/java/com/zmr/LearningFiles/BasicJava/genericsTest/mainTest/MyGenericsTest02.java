package main.java.com.zmr.LearningFiles.BasicJava.genericsTest.mainTest;

import main.java.com.zmr.LearningFiles.BasicJava.genericsTest.genericsClass.Persons;

/**
 * @ClassName MyGenericsTest02
 * @Description 泛型测试案例02
 * @Author zhumengren
 * @Date 2022/8/25 8:31
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyGenericsTest02 {
    public static void main(String[] args) {
        Persons<Integer> persons = new Persons<>(1);
        persons.show();
    }
}
