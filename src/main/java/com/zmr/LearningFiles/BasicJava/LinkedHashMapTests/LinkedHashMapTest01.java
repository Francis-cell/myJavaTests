package main.java.com.zmr.LearningFiles.BasicJava.LinkedHashMapTests;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LinkedHashMapTest01
 * @Description LinkedHashMap测试类01
 * @Author zhumengren
 * @Date 2022/3/27 13:41
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class LinkedHashMapTest01 {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name1", "小黑");
        linkedHashMap.put("name2", "小白");
        linkedHashMap.put("name3", "阿根");
        // 转变成迭代器的流程
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key: " + key + " value: " + value);
        }
    }
}
