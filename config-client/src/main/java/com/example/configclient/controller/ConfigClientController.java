package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringCloud
 * Author: jianghaotian
 * Create Time:2019/2/15 15:08
 */
@RefreshScope
@RestController
public class ConfigClientController {


    //配置客户端会把配置服务端的配置信息加载进来，存到ApplicationContext实例中
    @Value("${env}")
    private String env;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/getEnv")
    public String getEnv() {
        return "env:" + env + "server.port:" + port;
    }
}
