package com.example.eurekaribbon.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringCloud
 * Author: jianghaotian
 * Create Time:2019/2/13 09:59
 */
@RestController
public class EurekaClientController {

    @Value("${server.port}")
    private String port;

    /**
     * 提供一个服务hello
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return "hi, my port is " + port;
    }
}
