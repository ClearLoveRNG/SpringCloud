package com.example.eurekaribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringCloud
 * Author: jianghaotian
 * Create Time:2019/2/13 10:48
 */
@Service
public class EurekaRibbonService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 在url中使用eureka-client代替localhost:2222或者localhost:3333
     * 在这里我们直接用的程序名替代了具体的url地址，在ribbon中它会根据服务名来选择具体的服务实例，
     * 根据服务实例在请求的时候会用具体的url替换掉服务名
     * @return
     */
    //@HystrixCommand开启熔断器功能，fallbackMethod属性指定熔断方法
    @HystrixCommand(fallbackMethod = "error")
    public String consumeHello(){
        return restTemplate.getForObject("http://eureka-client/hello",String.class);
    }

    /**
     * 熔断方法，当调用http://eureka-client/hello不可用(例如停止eureka-client项目)时，会返回指定的熔断方法的返回值
     * @return
     */
    private String error(){
        return "sorry,error";
    }
}
