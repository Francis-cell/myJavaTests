package com.zmr.MySpringLearning.Annotation.MyComponent.test;

import com.zmr.MySpringLearning.Annotation.MyComponent.MyComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MyComponent(value = "test")
@Resource
public class User {
    private String name;
    private Integer age;

    public void innerTest() {
        System.out.println("内部测试方法!");
    }
}
