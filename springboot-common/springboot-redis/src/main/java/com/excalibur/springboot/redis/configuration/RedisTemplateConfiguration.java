package com.excalibur.springboot.redis.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redisTemplate的配置
 *
 * @author: mingfa.zheng
 * @date: 2018/2/19 11:18
 */
@Configuration
public class RedisTemplateConfiguration {
    private Logger logger = LoggerFactory.getLogger(getClass());
//    @Bean
//    @SuppressWarnings("rawtypes")
//    public RedisSerializer fastJson2JsonRedisSerializer() {
//        return new FastJson2JsonRedisSerializer<Object>(Object.class);
//    }

    @Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        FastJson2JsonRedisSerializer fastJson2JsonRedisSerializer = new FastJson2JsonRedisSerializer(Object.class);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJson2JsonRedisSerializer);

        try {
            logger.debug("redis ping:{}", redisTemplate.getConnectionFactory().getConnection().ping());
        } catch (Exception e) {
            logger.error("redis connection fail", e);
        }
        return redisTemplate;
    }
}
