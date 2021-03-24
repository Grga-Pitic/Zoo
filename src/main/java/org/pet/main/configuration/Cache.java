package org.pet.main.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Cache {

    @Bean
    public CacheManager caffeineCacheManager() {
        return new CaffeineCacheManager("animals");
    }
}
