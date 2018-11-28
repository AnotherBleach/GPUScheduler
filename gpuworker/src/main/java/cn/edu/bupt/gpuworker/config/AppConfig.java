package cn.edu.bupt.gpuworker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ComponentScan("cn.edu.bupt.gpuworker")

public class AppConfig {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {

        RedisTemplate<String, String> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        System.out.println("**********************");
        return redisTemplate;
    }

}
