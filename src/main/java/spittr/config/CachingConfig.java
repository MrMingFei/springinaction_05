package spittr.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class CachingConfig {

    /**
     * 新版本无法通过构造函数构造RedisCacheManager
     * 此处使用静态create方法使用默认配置的manager
     * @param cf
     * @return
     */
    @Bean
    public CacheManager cachingMatcher(RedisConnectionFactory cf){
        RedisCacheManager cacheManager = RedisCacheManager.create(cf);
        return cacheManager;
    }
}
