package com.example.lovecode.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author cuiyaocy
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public JedisPoolConfig getGenConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMaxTotal(200);
        config.setMinIdle(0);
        return config;
    }

    @Bean
    @Qualifier("myTemplate")
    public RedisTemplate<String, Object> getTemplate(JedisPoolConfig config) {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPoolConfig(config);
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }
}
