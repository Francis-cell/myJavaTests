package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

public class MyTest26 {
    public static void main(String[] args) {
        // List<Map<String, String>> maps = new ArrayList<>();
        // HashMap<String, String> map1 = new HashMap<>();
        // map1.put("ID", "1");
        // map1.put("V", "V1");
        // HashMap<String, String> map2 = new HashMap<>();
        // map2.put("ID", "2");
        // map2.put("V", "V2");
        // HashMap<String, String> map3 = new HashMap<>();
        // map3.put("ID", "3");
        // map3.put("V", "V3");
        //
        // maps.add(map1);
        // maps.add(map2);
        // maps.add(map3);
        //
        // List<String> ids = maps.stream().map(item -> item.get("ID")).collect(Collectors.toList());
        // PrintUtils.printList(ids);
        String newString = "111".replaceAll(".$", "2");
        System.out.println(newString);
    }
}
