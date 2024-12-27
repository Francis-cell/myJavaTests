package com.zmr.LearningFiles.OwnLearning.BasicJava.CoWTests;


import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p> 写时拷贝列表 测试 </p>
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        // 写时拷贝列表
        CopyOnWriteArrayList cowList = new CopyOnWriteArrayList<Integer>();
        cowList.add(1);
    }
}
