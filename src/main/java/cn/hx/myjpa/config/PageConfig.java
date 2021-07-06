package cn.hx.myjpa.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@ConfigurationProperties(prefix = "jpa.default")
@PropertySource(value = "classpath:jpa.properties")
@Data
//@EnableCaching
public class PageConfig {

    public int pagesize;
    public int page;
    @Bean
    public PageRequest setPageRequest(){
        System.out.println("default page: "+page+"/n default pagesize: "+pagesize);
        return PageRequest.of(page,pagesize, Sort.unsorted());

    }
    @Bean
    public CacheManager setCacheMan(RedisConnectionFactory connectionFactory){

        RedisCacheWriter rcw=RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        RedisSerializer<Object> rs=new GenericFastJsonRedisSerializer();
        RedisSerializationContext.SerializationPair sp=RedisSerializationContext.SerializationPair.fromSerializer(rs);
        RedisCacheConfiguration cacheConfiguration=RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(sp);

        return new RedisCacheManager(rcw,cacheConfiguration);

    }
}
