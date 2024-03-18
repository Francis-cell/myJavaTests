package com.zmr.LearningFiles.OwnLearning.BasicJava.JsonTests;

import com.google.gson.Gson;
import com.zmr.LearningFiles.OwnLearning.BasicJava.entity.ObjectDemos;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/8/8 22:15
 * @description
 */
public class GsonDemos {
    public static void main(String[] args) {
        ObjectDemos xiaoHei = new ObjectDemos("小黑", 10);
        
        Gson gson = new Gson();
        
        // 对象转 JSON
        String jsonString = gson.toJson(xiaoHei);
        System.out.println(jsonString);
        
        // JSON 转对象
        ObjectDemos objectDemos = gson.fromJson(jsonString, ObjectDemos.class);
        System.out.println(objectDemos.toString());
    }
}
