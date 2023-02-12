package com.zmr.LearningFiles.MyRedisLearning.adv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/2/12 16:05
 * @description Redis下 PipeLine的使用案例
 */
@Component
public class RedisPipeLine {
    @Autowired
    private JedisPool jedisPool;
    
    public List<Object> plGet(List<String> keys) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // pipe是将所有的命令组装成pipeline
            Pipeline pipelined = jedis.pipelined();
            // 开启事务
            pipelined.multi();
            // TODO--执行相关命令
            // 提交事务
            pipelined.exec();

            // 这里使用的命令需要是pipeline提供支持的命令
            // 这里get方法、set方法等方法都是pipeline提供支持的
            for (String key : keys) {
                pipelined.get(key);
            }
            // 这里只会向Redis发送一次
            return pipelined.syncAndReturnAll();
        } catch (Exception e) {
            throw new RuntimeException("执行PipeLine获取失败!", e);
        } finally {
            // 关闭jedis
            jedis.close();
        }
    }
    
    public void plSet(List<String> keys, List<String> values) {
        if (keys.size() != values.size()) {
            throw new RuntimeException("key和value个数不匹配！");
        }
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            Pipeline pipelined = jedis.pipelined();
            for (int i = 0; i < keys.size(); i++) {
                pipelined.set(keys.get(i), values.get(i));
            }
            pipelined.sync();
        } catch (Exception e) {
            throw new RuntimeException("执行Pipeline设置失败！", e);
        } finally {
            jedis.close();
        }
    }
}
