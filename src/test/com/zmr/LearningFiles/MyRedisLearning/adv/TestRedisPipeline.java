package com.zmr.LearningFiles.MyRedisLearning.adv;

import com.zmr.LearningFiles.MyRedisLearning.redisbase.basetypes.RedisString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/2/12 16:17
 * @description Redis pipeline测试方法
 */
@SpringBootTest
@ActiveProfiles
public class TestRedisPipeline {
    @Autowired
    private RedisPipeLine redisPipeLine;

    @Autowired
    private RedisString redisString;

    private static final int TEST_COUNT = 10000;
    
    @Test
    public void testPipeline() {
        // 单个的set操作和pipeline方式的set操作做比较

        // 1、单个的set操作
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TEST_COUNT; i++) {
            redisString.set("testStringM:key_" + i, String.valueOf(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("非pipeline操作"+ TEST_COUNT + "次字符串数据类型set写入，耗时：" + (endTime - startTime) + "毫秒！");
        
        
        // 2、pipeline类型的set操作
        ArrayList<String> keys = new ArrayList<>(TEST_COUNT);
        ArrayList<String> values = new ArrayList<>(TEST_COUNT);
        for (int i = 0; i < keys.size(); i++) {
            keys.add("testStringM:key_" + i);
            values.add(String.valueOf(i));
        }
        long pipeLineStart = System.currentTimeMillis();
        redisPipeLine.plSet(keys, values);
        long pipeLineEnd = System.currentTimeMillis();
        System.out.println("Pipeline操作"+ TEST_COUNT + "次字符串数据类型set写入，耗时：" + (pipeLineEnd - pipeLineStart) + "毫秒！");
    }
}
