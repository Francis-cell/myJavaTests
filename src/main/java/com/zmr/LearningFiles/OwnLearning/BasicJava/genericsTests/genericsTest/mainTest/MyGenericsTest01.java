package com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTests.genericsTest.mainTest;

import com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTests.genericsTest.entity.Boy;
import com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTests.genericsTest.entity.Girl;
import com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTests.genericsTest.entity.Person;

import java.util.ArrayList;

/**
 * @ClassName MyGenericsTest01
 * @Description 泛型测试案例01
 * @Author zhumengren
 * @Date 2022/8/25 8:31

 * @Version 1.0
 **/
public class MyGenericsTest01 {
    public static void main(String[] args) {
        // ArrayList中无法添加进不同实体类型的对象
        ArrayList<Person> myList = new ArrayList<>();
        myList.add(new Person("name01", 20, "男"));
        myList.add(new Person("name02", 20, "男"));
        myList.add(new Boy("name03", 20));
        myList.add(new Girl("name04", 20));
        System.out.println("当前的myList的值为：" + myList);

        // 使用反射机制获取类具体的类型
        myList.forEach(item->{
            System.out.println("item: " + item.getClass().getName());
        });

        // TODO 获取对象的相关属性的值
        //// 通过反射机制获取对象的所有属性
        //Person person = new Person();
        //Field[] declaredFields = person.getClass().getDeclaredFields();
        //System.out.println("person的属性的值为：" + declaredFields.length);
        //for (Field item : declaredFields) {
        //    // 获取对象属性名
        //    String name = item.getName();
        //    // 获取对象属性类型
        //    String typeName = item.getGenericType().getTypeName();
        //    System.out.printf("属性名: %s, 类型名: %s", name, typeName);
        //}


        //ArrayList<Integer> intArr = new ArrayList<>();
        //intArr.add(1);
        //intArr.add(2);
        //intArr.add("3");
    }
}
