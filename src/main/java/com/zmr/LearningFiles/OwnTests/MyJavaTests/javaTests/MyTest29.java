package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import com.zmr.MyUtils.DataStructUtils.MapUtils.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest29 {
    public static void main(String[] args) {
        List<Map<String, Object>> mapList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("index", i);
            // map.put("val", "a" + i);
            // map.put("z", "b" + i);
            mapList.add(map);
        }

        // PrintUtils.printList(mapList);

        MapUtils.updateMap(mapList, "f", "123", "index", 1);

        // PrintUtils.printList(mapList);
    }
}
