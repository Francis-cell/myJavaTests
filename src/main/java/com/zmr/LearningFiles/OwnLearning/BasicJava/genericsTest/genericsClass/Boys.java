package com.zmr.LearningFiles.OwnLearning.BasicJava.genericsTest.genericsClass;

/**
 * @ClassName Boys
 * @Description Boys泛型类
 * @Author zhumengren
 * @Date 2022/8/25 18:21

 * @Version 1.0
 **/
public class Boys <T> extends Persons<T>{
    public Boys() {
        System.out.println("");
    }


    public Boys(T attribute) {
        super(attribute);
    }
}
