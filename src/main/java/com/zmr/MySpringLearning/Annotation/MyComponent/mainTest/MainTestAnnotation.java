package com.zmr.MySpringLearning.Annotation.MyComponent.mainTest;

import com.zmr.MySpringLearning.Annotation.MyComponent.MyComponent;
import com.zmr.MySpringLearning.Annotation.MyComponent.test.User;

public class MainTestAnnotation {
    public static void main(String[] args) {
        // 获取到 User 的 class 对象
        Class<User> userClass = User.class;
        // 判断 User 是否添加了 MyComponent 注解
        if (userClass.isAnnotationPresent(MyComponent.class)) {
            // 获取 User 上的 MyComponent 注解
            MyComponent annotation = userClass.getAnnotation(MyComponent.class);
            // 获取到 value 属性
            System.out.println(annotation.value());;
        }
    }
}
