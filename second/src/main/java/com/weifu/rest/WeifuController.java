package com.weifu.rest;

import com.weifu.biz.SchoolBiz;
import com.weifu.biz.WeifuBiz;
import com.weifu.entity.School;
import com.weifu.spring.entity.Wef;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("weifu")
public class WeifuController {

    @Resource
    private WeifuBiz weifuBiz;

    @Resource
    private SchoolBiz schoolBiz;

    @Resource
    private DiscoveryClient client;

    @GetMapping("page")
    public List<Wef> selectByquery() {
        return weifuBiz.select();
    }

    @GetMapping("select")
    public List<School> selectStuden() {
        return schoolBiz.select();
    }

//    /**
//     * 推送中台模拟
//     *
//     *
//     * @return
//     */
//    @GetMapping("pushCenter")
//    public List<Wef> push(){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        //获取当前日期
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.MONTH, -1);
//        //设置为1号,当前日期既为本月第一天
//        cal.set(Calendar.DAY_OF_MONTH, 1);
//        String firstDay = sdf.format(cal.getTime());
//        //获取前月的最后一天
//        Calendar cale = Calendar.getInstance();
//        //设置为1号,当前日期既为本月第一天
//        cale.set(Calendar.DAY_OF_MONTH, 0);
//        String lastDay = sdf.format(cale.getTime());
//        System.out.println(firstDay +'+'+ lastDay);
//    return null;
////        return weifuBiz.pushCenter();
//    };



    @GetMapping("discovery")
    public Object discovery() {
        // 获取注册进来的微服务
        List<String> services = client.getServices();
        System.out.printf("service" + services);
        // 获取当前的微服务（具体的微服务）  通过 Application 获取到想要的微服务 循环遍历获取消息
        List<ServiceInstance> instances = client.getInstances("WEIFU-SECOND");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                            instance.getPort() + "\t" +
                            instance.getServiceId() + "\t" +
                            instance.getUri());
        }
        return this.client;
    }
}
