package com.zmr.MySpringLearning.Annotation.MyComponent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyComponent {

    String value() default "";
}
