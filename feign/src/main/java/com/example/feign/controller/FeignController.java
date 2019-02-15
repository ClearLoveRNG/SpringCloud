package com.example.feign.controller;

import com.example.feign.api.IFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringCloud
 * Author: jianghaotian
 * Create Time:2019/2/13 15:02
 */
@RestController
public class FeignController {

    @Autowired
    IFeign iFeign;

    @RequestMapping("/consumerHello")
    public String consumerHello() {
        return iFeign.consumerHello();
    }
}
