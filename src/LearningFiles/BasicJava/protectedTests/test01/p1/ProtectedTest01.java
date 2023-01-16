package LearningFiles.BasicJava.protectedTests.test01.p1;

import LearningFiles.BasicJava.protectedTests.test01.p2.Son02;

/**
 * @ClassName ProtectedTest01
 * @Description protected测试案例01
 * @Author zhumengren
 * @Date 2022/4/18 10:49
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class ProtectedTest01 {
    public static void main(String[] args) {
        Son01 son01 = new Son01();
        son01.f();
        // 报错内容： 'clone()' has protected access in 'java.lang.Object'
        // son01.clone();

        Son02 son02 = new Son02();
        son02.f();
        // 报错内容： 'clone()' has protected access in 'java.lang.Object'
        // son02.clone();

        ProtectedTest01 pt1 = new ProtectedTest01();
        try {
            pt1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
