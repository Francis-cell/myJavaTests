package com.zmr.LearningFiles.OwnLearning.BasicJava.JsonTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zmr.LearningFiles.OwnLearning.BasicJava.entity.ObjectDemos;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/8/8 22:15
 * @description
 */
public class JackSonDemos {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectDemos xiaoHei = new ObjectDemos("小黑", 10);

        ObjectMapper mapper = new ObjectMapper();
        
        // 对象转 JSON
        String jsonString = mapper.writeValueAsString(xiaoHei);
        System.out.println(jsonString);
        
        
        // JSON 转对象
        ObjectDemos objectDemos = mapper.readValue(jsonString, ObjectDemos.class);
        System.out.println(objectDemos.toString());
    }
}
