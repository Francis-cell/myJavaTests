package com.zmr.LearningFiles.BasicJava.EffectiveJavaDemos.main;

import com.zmr.LearningFiles.BasicJava.EffectiveJavaDemos.BuilderDemo.UserBuilder;
import com.zmr.LearningFiles.BasicJava.EffectiveJavaDemos.JavaStaticFactory.ChildrenJavaStaticFactory01;
import com.zmr.LearningFiles.BasicJava.EffectiveJavaDemos.JavaStaticFactory.ChildrenJavaStaticFactory02;
import com.zmr.LearningFiles.BasicJava.EffectiveJavaDemos.JavaStaticFactory.JavaStaticFactory;
import com.zmr.LearningFiles.BasicJava.EffectiveJavaDemos.equalsDemo.CaseInsensitiveString;

public class MainTest {
    public static void main(String[] args) {
//        ChildrenJavaStaticFactory01 xiaoHei = (ChildrenJavaStaticFactory01) JavaStaticFactory.of("xiaoHei");
//        ChildrenJavaStaticFactory02 xiaoHei1 = (ChildrenJavaStaticFactory02) JavaStaticFactory.of("xiaoHei");

//        UserBuilder xiaoHei = new UserBuilder.Builder("xiaoHei", "123456", "xiaoHei@xmail.com")
//                .sex("boy")
//                .age(10)
//                .address("罗小黑战记")
//                .build();


        // equals method
        CaseInsensitiveString polish = new CaseInsensitiveString("Polish");
        System.out.println(polish.equals("polish"));
        System.out.println("polish".equals(polish));
    }
}
