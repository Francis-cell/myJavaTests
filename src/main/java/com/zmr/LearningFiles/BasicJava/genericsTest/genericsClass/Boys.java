package main.java.com.zmr.LearningFiles.BasicJava.genericsTest.genericsClass;

/**
 * @ClassName Boys
 * @Description Boys泛型类
 * @Author zhumengren
 * @Date 2022/8/25 18:21
 * @Email zhumengren@sinosoft.com
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
