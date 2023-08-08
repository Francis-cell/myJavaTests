package com.zmr.LearningFiles.BasicJava.JsonTests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zmr.LearningFiles.BasicJava.JsonTests.Utils.DateObject;
import com.zmr.LearningFiles.BasicJava.JsonTests.Utils.Result;
import com.zmr.LearningFiles.BasicJava.entity.ObjectDemos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/8/8 22:14
 * @description
 */
public class FastJsonDemos {

    /**
     * 常用方法代码案例
     */
    public static void usualMethodsUsing() {
        ObjectDemos xiaoHei = new ObjectDemos("小黑", 10);

        // 1、对象转 json
        String jsonString = JSON.toJSONString(xiaoHei);
        System.out.println(jsonString);

        // 2、JSON 转对象
        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println(jsonObject);

        // 3、JSON 转 JSONArray
        String arrayJsonString = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25}]";
        JSONArray jsonObjects = JSON.parseArray(arrayJsonString);
        System.out.println(jsonObjects);
    }


    /**
     * 针对 泛型对象 的序列化和反序列化案例
     */
    public static void genericMethod() {
        // 构建一个 Result 对象，包含一个字符串作为结果
        Result<String> stringResult  = new Result<>("success", "Operation successful!");
        
        // 将 Result 对象序列化成 JSON 字符串
        String jsonString = JSON.toJSONString(stringResult);
        System.out.println(jsonString);
        
        // 反序列化 JSON 字符串为 Result 对象
        Result<String> deserializedResult  = JSON.parseObject(jsonString, Result.class);
        System.out.println("反序列化的结果为：" + deserializedResult);
        System.out.println("Message 的值为: " + deserializedResult.getMessage());
    }

    /**
     * fastJson 在解析日期上存在问题，这个方法作为展示问题的示例
     */
    public static void errorTimeMethod() {
        // 创建包含日期的 JSON 字符串
        String jsonString = "{\"date\":\"2023-08-08T12:34:56.789Z\"}";
        
        // 将 JSON 字符串解析成对象
        DateObject dateObject = JSON.parseObject(jsonString, DateObject.class);

        System.out.println("解析后的时间为：" + dateObject.getDate());
    }

    /**
     * fastJson 在解析日期上存在问题，这个方法作为展示解决问题的示例代码
     */
    public static void truthTimeMethod() {
        // 创建包含日期的 JSON 字符串
        String jsonString = "{\"date\":\"2023-08-08T12:34:56.789Z\"}";
        
        JSON.toJSONStringWithDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
        
        // 将 JSON 字符串解析成对象
        DateObject dateObject = JSON.parseObject(jsonString, DateObject.class);
        
        System.out.println("解析后的时间为：" + dateObject.getDate());
    }
    
    
    public static void main(String[] args) {
        // genericMethod();
        errorTimeMethod();
        //truthTimeMethod();
    }
}
