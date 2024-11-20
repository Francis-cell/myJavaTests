package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import com.zmr.MyUtils.MapUtils.MapUtils;
import com.zmr.MyUtils.MapUtils.impl.MapUtilsImpl;
import com.zmr.MyUtils.PrintUtils.PrintUtils;
import com.zmr.MyUtils.PrintUtils.impl.PrintUtilsImpl;

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

        // PrintUtilsImpl.getInstance().printList(mapList);

        MapUtilsImpl.getInstance().updateMap(mapList, "f", "123", "index", 1);

        // PrintUtilsImpl.getInstance().printList(mapList);
    }
}
