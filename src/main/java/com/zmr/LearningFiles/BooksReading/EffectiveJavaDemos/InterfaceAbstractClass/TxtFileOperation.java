package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.InterfaceAbstractClass;

public class TxtFileOperation extends AbstractFileOperation {

    @Override
    void specificWriteFile(String filePath, String content) {
        // 实现写txt文件的具体逻辑
        System.out.println("Writing txt file with content: " + content);
    }
}
