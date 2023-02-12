package com.zmr.LearningFiles.MyRedisLearning.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description Redis配置文件读取配置
 * @date 2023/2/12 15:53
 */
public class RedisConfig {
    @Value("${redis.host}")
    private String host;
    
    @Value("${redis.port}")
    private int port;
    
    @Value("${redis.timeout}")
    private int timeout;
    
    /** 连接池中的最大空闲连接 */
    @Value("${redis.maxIdle}")
    private int maxIdle;
    
    /** 连接池最大阻塞等待时间（使用负值表示没有限制） */
    @Value("${redis.maxWaitMillis}")
    private int maxWaitMillis;
    
    /** 连接耗尽时是否阻塞，false报异常，true阻塞直到超时，默认true */
    @Value("${redis.blockWhenExhausted}")
    private boolean blockWhenExhausted;
    
    /** 是否启用pool的jmx管理功能，默认true */
    @Value("${redis.JmxEnabled}")
    private boolean JmxEnabled;
    
    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞，false报异常，true阻塞直到超时，默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能，默认true
        jedisPoolConfig.setJmxEnabled(JmxEnabled);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        return jedisPool;
    }
}
