package com.zmr.LearningFiles.BooksReading.MultiThreadTests.startDemos;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * 事实不可变对象 demo
     * Date 被放入到 Map 之后就不会改变，那么 synchronizedMap 中的同步机制就足以使 Date 值被安全地发布，
     * 并且在访问这些 Date 值时不需要额外的同步
     */
    public Map<String, Date> lastLogin =
            Collections.synchronizedMap(new HashMap<String, Date>());


    public static void main(String[] args) {

    }
}
