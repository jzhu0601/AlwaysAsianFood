package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by jzhu on 11/20/2015.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.mycompany"})
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager("restaurants");
        //concurrentMapCacheManger is not good for production use
        // ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("restaurants");
        return cacheManager;
    }

}

