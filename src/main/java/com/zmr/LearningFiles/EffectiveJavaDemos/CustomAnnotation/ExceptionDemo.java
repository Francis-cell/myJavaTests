package com.zmr.LearningFiles.EffectiveJavaDemos.CustomAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionDemoContainer.class)
public @interface ExceptionDemo {
    Class<? extends Exception> value();
}
