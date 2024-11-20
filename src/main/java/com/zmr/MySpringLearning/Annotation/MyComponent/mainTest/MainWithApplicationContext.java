package com.zmr.MySpringLearning.Annotation.MyComponent.mainTest;

import com.zmr.MySpringLearning.Annotation.MyComponent.ApplicationContext;
import com.zmr.MySpringLearning.Annotation.MyComponent.test.User;

public class MainWithApplicationContext {
    public static void main(String[] args) {
        String packagePath = "com.zmr.MySpringLearning.Annotation.MyComponent";
        ApplicationContext ctx = new ApplicationContext(packagePath);
        User user = (User) ctx.getBean("user");
        user.setName("小黑");
        System.out.println(user.getName());
    }
}
