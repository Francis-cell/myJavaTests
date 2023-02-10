package main.java.com.zmr.LearningFiles.BasicJava.genericsTest.entity;

/**
 * @ClassName Boy
 * @Description Boy实体类
 * @Author zhumengren
 * @Date 2022/8/25 8:28
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class Boy extends Person{
    public Boy() {
        System.out.println("Boy构造方法!!!");
    }

    public Boy(String name, Integer age) {
        super(name, age, "男");
        System.out.println("Boy构造方法!!!");
    }
}
