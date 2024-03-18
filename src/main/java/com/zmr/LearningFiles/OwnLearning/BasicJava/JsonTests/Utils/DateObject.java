package com.zmr.LearningFiles.OwnLearning.BasicJava.JsonTests.Utils;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.Date;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/8/8 22:46
 * @description
 */
public class DateObject {
//    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
