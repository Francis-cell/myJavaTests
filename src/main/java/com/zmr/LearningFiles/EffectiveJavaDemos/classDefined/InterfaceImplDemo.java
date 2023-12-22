package com.zmr.LearningFiles.EffectiveJavaDemos.classDefined;

public class InterfaceImplDemo implements InterfaceDemo {
    @Override
    public void printValue() {
        System.out.println("实现类！");
    }
}
