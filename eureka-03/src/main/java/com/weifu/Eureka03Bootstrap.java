package com.weifu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 开启eureka服务 服务端的启动类，他可以接收别人注册进来
@EnableEurekaServer
public class Eureka03Bootstrap {
    public static void main(String[] args){
        SpringApplication.run(Eureka03Bootstrap.class, args);
    }
}
