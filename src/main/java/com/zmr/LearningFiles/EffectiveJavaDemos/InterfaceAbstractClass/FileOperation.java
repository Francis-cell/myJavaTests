package com.zmr.LearningFiles.EffectiveJavaDemos.InterfaceAbstractClass;

public interface FileOperation {
    void readFile(String filePath);
    void writeFile(String filePath, String content);

    default void defaultMethod() {
        System.out.println("123");
    }
}
