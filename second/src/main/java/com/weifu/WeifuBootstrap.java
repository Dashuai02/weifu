package com.weifu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.weifu"}, exclude = {FlywayAutoConfiguration.class})
@EnableEurekaClient //在服务启动后自动注册到eureka中
@EnableDiscoveryClient //服务发现
/**
 * @MapperScan("com.weifu.mapper")
 * 扫描dao层映射类
 */
public class WeifuBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(WeifuBootstrap.class,args);
    }
}
