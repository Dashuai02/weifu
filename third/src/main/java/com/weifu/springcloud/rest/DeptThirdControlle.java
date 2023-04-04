package com.weifu.springcloud.rest;

import com.weifu.spring.entity.Wef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptThirdControlle {
    //RestFull
    //RestTemplate 供我们直接调用就可以！注册到spring中

    //三个重要的参数（url,实体Map,Class<T> responseType）
    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程http服务的方法，简繁的restFull模板

    private static final String REST_URL_PERFIX = "http://localhost:8080/";

    @RequestMapping("/third/weifu/page")
    public List<Wef> get(){
        return restTemplate.getForObject(REST_URL_PERFIX+"/weifu/page", List.class);
    }

}
