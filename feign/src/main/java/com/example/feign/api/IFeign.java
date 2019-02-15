package com.example.feign.api;

import com.example.feign.Impl.FeignErrorImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringCloud
 * Author: jianghaotian
 * Create Time:2019/2/13 14:57
 */
//@FeignClient("服务名")来制定调用那个服务
@FeignClient(value = "eureka-client",fallback = FeignErrorImpl.class)
public interface IFeign {

    //@FeignClient注解的定义的服务应用下的接口名，这里是服务名为eureka-client下的hello接口
    @RequestMapping("/hello")
    String consumerHello();
}
