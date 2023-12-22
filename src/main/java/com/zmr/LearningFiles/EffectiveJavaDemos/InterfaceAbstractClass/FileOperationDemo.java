package com.zmr.LearningFiles.EffectiveJavaDemos.InterfaceAbstractClass;

public class FileOperationDemo implements FileOperation{
    @Override
    public void readFile(String filePath) {

    }

    @Override
    public void writeFile(String filePath, String content) {

    }

    @Override
    public void defaultMethod() {
        FileOperation.super.defaultMethod();
    }
}
