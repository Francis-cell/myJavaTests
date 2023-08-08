package com.zmr.LearningFiles.BasicJava.JsonTests;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/8/8 22:15
 * @description
 */
public class BasicJsonDemos {
    public static void main(String[] args) {
        // 创建 JSON 对象
        JSONObject jsonObject = new JSONObject();
        
        // 添加值
        jsonObject.put("小黑", "10");
        
        // 获取值
        String ans = jsonObject.getString("小黑");
        System.out.println(ans);
    }
}
