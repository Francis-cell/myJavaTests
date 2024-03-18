package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.InterfaceAbstractClass;

public abstract class AbstractFileOperation implements FileOperation {
    @Override
    public void readFile(String filePath) {
        // 实现读文件的基本逻辑
        System.out.println("Reading file from: " + filePath);
    }

    // 留给子类实现的抽象方法
    abstract void specificWriteFile(String filePath, String content);

    @Override
    public void writeFile(String filePath, String content) {
        // 调用子类实现的具体写文件方法
        specificWriteFile(filePath, content);
        System.out.println("Writing file to: " + filePath);
    }
}
