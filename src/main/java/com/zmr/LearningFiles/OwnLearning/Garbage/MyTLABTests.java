package com.zmr.LearningFiles.OwnLearning.Garbage;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description TLAB分配测试
 * @date 2023/2/4 8:22
 */
public class MyTLABTests {
    class User {
        int id;
        String name;
        
        public User (int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    
    void alloc (int i) {
        // 这里new 的这个user就属于 “无逃逸” 对象
        new User(i, "name" + i);
    }
    
    public static void main(String[] args) {
        MyTLABTests t = new MyTLABTests();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            t.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
