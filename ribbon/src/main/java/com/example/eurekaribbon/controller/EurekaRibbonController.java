package com.example.eurekaribbon.controller;

import com.example.eurekaribbon.service.EurekaRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringCloud
 * Author: jianghaotian
 * Create Time:2019/2/13 09:59
 */

/**
 *  此时的架构是:
 *  1.一个服务注册中心，eureka-server,端口为1111
    2.eureka-client工程跑了两个实例，端口分别为2222,3333，分别向服务注册中心注册
    3.eureka-ribbon端口为4444,向服务注册中心注册
    4.eureka-ribbon通过restTemplate调用eureka-client的hello接口时，因为用ribbon进行了负载均衡，
      会轮流的调用eureka-client:2222和3333两个端口的hello接口；
 */
@RestController
public class EurekaRibbonController {

    @Autowired
    private EurekaRibbonService eurekaRibbonService;

    /**
     * 消费eureka-client提供的hello服务
     * @return
     */
    @RequestMapping("/consumerHello")
    public String consumerHello() {
        /**
         * 多次调用会显示
         * hi, my port is 2222
         * hi, my port is 3333
         * 说明已经做了负载均衡，访问了不同的端口的服务实例。
         */
        return eurekaRibbonService.consumeHello();
    }
}
