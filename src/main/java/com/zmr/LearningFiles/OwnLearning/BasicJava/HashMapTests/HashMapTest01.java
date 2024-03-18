package com.zmr.LearningFiles.OwnLearning.BasicJava.HashMapTests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName HashMapTest01
 * @Description HashMap测试类
 * @Author zhumengren
 * @Date 2022/3/27 13:50
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class HashMapTest01 {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name1", "小黑");
        hashMap.put("name2", "小白");
        hashMap.put("name3", "阿根");
        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key: " + key + " value: " + value);
        }
    }
}
