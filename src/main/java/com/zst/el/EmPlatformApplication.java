package com.zst.el;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.zst.el.dao")
@EnableTransactionManagement
@EnableScheduling
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=3600) //spring-session 在redis中的存储时间
public class EmPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmPlatformApplication.class, args);
    }

}
